// luckjd Joey luck
// cmsc 257 project 2

#include <stdio.h>
#include <stdlib.h>

#include "Assert257.h"
#include "LinkedList.h"
#include "LinkedList_priv.h"

LinkedList AllocateLinkedList(void) {
  // allocate the linked list record
  LinkedList ll = (LinkedList) malloc(sizeof(LinkedListHead));
  if (ll == NULL) {
    // out of memory
    return (LinkedList) NULL;
  }

  // Step 1. This step is given as an example
  // initialize the newly allocated record structure
  ll->num_elements = 0;
  ll->head = NULL;
  ll->tail = NULL;
  // return our newly minted linked list
  return ll;
}

void FreeLinkedList(LinkedList list,
                    LLPayloadFreeFnPtr payload_free_function) {
  // defensive programming: check arguments for sanity.
  Assert257(list != NULL);
  Assert257(payload_free_function != NULL);

  // Step 2.
  // sweep through the list and free all of the nodes' payloads as
  // well as the nodes themselves
  while (list->head != NULL) {
    payload_free_function(list->head->payload);
  	LinkedListNodePtr next = list->head->next;
  	free(list->head);
  	list->head = next;
  }
  // free the list record
  free(list);
}

uint64_t NumElementsInLinkedList(LinkedList list) {
  // defensive programming: check argument for safety.
  Assert257(list != NULL);
  return list->num_elements;
}

bool PushLinkedList(LinkedList list, void *payload) {
  // defensive programming: check argument for safety. The user-supplied
  // argument can be anything, of course, so we need to make sure it's
  // reasonable (e.g., not NULL).
  Assert257(list != NULL);

  // allocate space for the new node.
  LinkedListNodePtr ln =
    (LinkedListNodePtr) malloc(sizeof(LinkedListNode));
  if (ln == NULL) {
    // out of memory
    return false;
  }

  // set the payload
  ln->payload = payload;

  if (list->num_elements == 0) {
    // degenerate case; list is currently empty
    Assert257(list->head == NULL);  // debugging aid
    Assert257(list->tail == NULL);  // debugging aid
    ln->next = ln->prev = NULL;
    list->head = list->tail = ln;
    list->num_elements = 1U;
    return true;
  }

  // STEP 3. Solution for this step is given as an example
  // typical case; list has >=1 elements
  Assert257(list->head != NULL);
  Assert257(list->tail != NULL);

  ln->next = list->head;
  ln->prev = NULL;
  list->head->prev = ln;
  list->head = ln;
  list->num_elements += 1;
  // return success
  return true;
}

bool PopLinkedList(LinkedList list, void **payload_ptr) {
  // defensive programming.
  Assert257(payload_ptr != NULL);
  Assert257(list != NULL);

  // Step 4: implement PopLinkedList.  Make sure you test for
  // and empty list and fail.  If the list is non-empty, there
  // are two cases to consider: (a) a list with a single element in it
  // and (b) the general case of a list with >=2 elements in it.
  // Be sure to call free() to deallocate the memory that was
  // previously allocated by PushLinkedList().
  if (list == NULL) {
  	return false;
  }
  // if the list is empty return false
  if (list->num_elements == 0) {
    return false;
  }
  	*payload_ptr = list->head->payload;
    LinkedListNodePtr nodePtr = list->head;
  // if it is the last element in the list
  if (NumElementsInLinkedList(list) == 1) {
  	list->head = list->tail = NULL;
  } 
  // if there is 2 or more elements in the list 
  else {
      list->head = list->head->next;
      list->head->prev = NULL;
  }
  // decrement number of elements
  list->num_elements -= 1;
  free(nodePtr);
  return true;
}

bool AppendLinkedList(LinkedList list, void *payload) {
  // defensive programming: check argument for safety.
  Assert257(list != NULL);

  // Step 5: implement AppendLinkedList.  It's kind of like
  // PushLinkedList, but obviously you need to add to the end
  // instead of the beginning.
  LinkedListNodePtr nodePtr =
    (LinkedListNodePtr) malloc(sizeof(LinkedListNode));
  if (nodePtr == NULL) {
    return false;
  }
  nodePtr->payload = payload;
  if (list->num_elements == 0) {
    Assert257(list->head == NULL);
    Assert257(list->tail == NULL); 
    nodePtr->next = nodePtr->prev = NULL;
    list->head = list->tail = nodePtr;
    list->num_elements = 1U;
    return true;
  }
  nodePtr->prev = list->tail;
  nodePtr->next = NULL;
  list->tail->next = nodePtr;
  list->tail = nodePtr;
  list->num_elements += 1;
  return true;
}

bool SliceLinkedList(LinkedList list, void **payload_ptr) {
  // defensive programming.
  Assert257(payload_ptr != NULL);
  Assert257(list != NULL);

  // Step 6: implement SliceLinkedList.
  if (list == NULL) {
  	return false;
   }
  if (list->num_elements == 0) {
    return false;
  }
	*payload_ptr = list->tail->payload;
  LinkedListNodePtr nodePtr = list->tail;
	if (NumElementsInLinkedList(list) == 1) {
		list->head = list->tail = NULL;
	} else {
		list->tail = list->tail->prev;
		list->tail->next = NULL;
	}
  free(nodePtr);
  list->num_elements -= 1;
  return true;
}

void SortLinkedList(LinkedList list, unsigned int ascending,
                    LLPayloadComparatorFnPtr comparator_function) {
  Assert257(list != NULL);  // defensive programming
  if (list->num_elements < 2) {
    // no sorting needed
    return;
  }

  // we'll implement bubblesort! nice and easy, and nice and slow :)
  int swapped;
  do {
    LinkedListNodePtr curnode;

    swapped = 0;
    curnode = list->head;
    while (curnode->next != NULL) {
      int compare_result = comparator_function(curnode->payload,
                                               curnode->next->payload);
      if (ascending) {
        compare_result *= -1;
      }
      if (compare_result < 0) {
        // bubble-swap payloads
        void *tmp;
        tmp = curnode->payload;
        curnode->payload = curnode->next->payload;
        curnode->next->payload = tmp;
        swapped = 1;
      }
      curnode = curnode->next;
    }
  } while (swapped);
}

LLIter LLMakeIterator(LinkedList list, int pos) {
  // defensive programming
  Assert257(list != NULL);
  Assert257((pos == 0) || (pos == 1));

  // if the list is empty, return failure.
  if (NumElementsInLinkedList(list) == 0U)
    return NULL;

  // OK, let's manufacture an iterator.
  LLIter li = (LLIter) malloc(sizeof(LLIterSt));
  if (li == NULL) {
    // out of memory!
    return NULL;
  }

  // set up the iterator.
  li->list = list;
  if (pos == 0) {
    li->node = list->head;
  } else {
    li->node = list->tail;
  }

  // return the new iterator
  return li;
}

void LLIteratorFree(LLIter iter) {
  // defensive programming
  Assert257(iter != NULL);
  free(iter);
}

bool LLIteratorHasNext(LLIter iter) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // Is there another node beyond the iterator?
  if (iter->node->next == NULL)
    return false;  // no

  return true;  // yes
}

bool LLIteratorNext(LLIter iter) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // Step 7: if there is another node beyond the iterator, advance to it,
  // and return true.
  if (LLIteratorHasNext(iter)) {
    iter->node = iter->node->next;
    return true;
  }
  // Nope, there isn't another node, so return failure.
  return false;
}

bool LLIteratorHasPrev(LLIter iter) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // Is there another node beyond the iterator?
  if (iter->node->prev == NULL)
    return false;  // no

  return true;  // yes
}

bool LLIteratorPrev(LLIter iter) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // Step 8:  if there is another node beyond the iterator, advance to it,
  // and return true.
  if (LLIteratorHasPrev(iter)) {
    iter->node = iter->node->prev;
    return true;
  }
  // nope, so return failure.
  return false;
}

void LLIteratorGetPayload(LLIter iter, void **payload) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // set the return parameter.
  *payload = iter->node->payload;
}

bool LLIteratorDelete(LLIter iter,
                      LLPayloadFreeFnPtr payload_free_function) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // Step 9: implement LLIteratorDelete.  This is the most
  // complex function you'll build.  There are several cases
  // to consider:
  //
  // - degenerate case: the list becomes empty after deleting.
  // - degenerate case: iter points at head
  // - degenerate case: iter points at tail
  // - fully general case: iter points in the middle of a list,
  //                       and you have to "splice".
  //
  // Be sure to call the payload_free_function to free the payload
  // the iterator is pointing to, and also free any LinkedList
  // data structure element as appropriate.
  LinkedListNodePtr nodePtr = iter->node;
  iter->list->num_elements--;
  // if its the only element in the list
  if (NumElementsInLinkedList(iter->list) == 0) {
    iter->list->head = NULL;
    iter->list->tail = NULL;
    iter->node = NULL;
    payload_free_function(nodePtr->payload);
    free(nodePtr);
    return false;
  }
  // if the iterator is at the head
  if (!LLIteratorHasPrev(iter)) {
    iter->node = iter->node->next;
    iter->list->head = iter->list->head->next;
    iter->list->head->prev = NULL;
  } 
  // if the iterator is at the tail
  else if (!LLIteratorHasNext(iter)) {
    iter->node = iter->node->prev;
    iter->list->tail = iter->list->tail->prev;
    iter->list->tail->next = NULL;
  } 
  // if the iterator is in the middle
  else {
    iter->node->next->prev = iter->node->prev;
    iter->node->prev->next = iter->node->next;
    iter->node = iter->node->next;
  }
  payload_free_function(nodePtr->payload);
  free(nodePtr);
  return true;
}

bool LLIteratorInsertBefore(LLIter iter, void *payload) {
  // defensive programming
  Assert257(iter != NULL);
  Assert257(iter->list != NULL);
  Assert257(iter->node != NULL);

  // If the cursor is pointing at the head, use our
  // PushLinkedList function.
  if (iter->node == iter->list->head) {
    return PushLinkedList(iter->list, payload);
  }

  // General case: we have to do some splicing.
  LinkedListNodePtr newnode =
    (LinkedListNodePtr) malloc(sizeof(LinkedListNode));
  if (newnode == NULL)
    return false;  // out of memory

  newnode->payload = payload;
  newnode->next = iter->node;
  newnode->prev = iter->node->prev;
  newnode->prev->next = newnode;
  newnode->next->prev = newnode;
  iter->list->num_elements += 1;
  return true;
}
