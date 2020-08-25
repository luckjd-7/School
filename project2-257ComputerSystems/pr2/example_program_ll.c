#include <stdio.h>
#include <stdlib.h>

#include "Assert257.h"
#include "LinkedList.h"

// the payload type we'll add
typedef struct {
  int num;
} ExamplePayload, *ExamplePayloadPtr;

// prototype of our payload free function
void ExamplePayloadFree(void *payload);

// prototype of our payload comparator function
int ExamplePayloadComparator(void *p1, void *p2);

// our main function; here, we demonstrate how to use some
// of the linked list functions.
int main(int argc, char **argv) {
  ExamplePayloadPtr payload;
  LinkedList list;
  LLIter iter;
  int i;

  // allocate a list
  list = AllocateLinkedList();
  Assert257(list != NULL);

  // insert 100 elements
  for (i = 0; i < 100; i++) {
    payload = (ExamplePayloadPtr) malloc(sizeof(ExamplePayload));
    Assert257(payload != NULL);
    payload->num = i;
    Assert257(PushLinkedList(list, (void *) payload) == 1);

    // make sure our list total is correct
    Assert257(NumElementsInLinkedList(list) == i+1);
  }

  // sort the list in descending order
  SortLinkedList(list, 0, &ExamplePayloadComparator);

  // pop off the first element
  Assert257(PopLinkedList(list, (void **) &payload) == 1);
  Assert257(payload->num == 99);
  Assert257(NumElementsInLinkedList(list) == 99);
  free(payload);

  // slice off the last element
  Assert257(SliceLinkedList(list, (void **) &payload) == 1);
  Assert257(payload->num == 0);
  Assert257(NumElementsInLinkedList(list) == 98);
  free(payload);

  // make an iterator from the head
  iter = LLMakeIterator(list, 0);
  Assert257(iter != NULL);

  // peek at the current iterator payload
  LLIteratorGetPayload(iter, (void **) &payload);
  Assert257(payload->num == 98);

  // move the iterator, peek at next payload
  Assert257(LLIteratorNext(iter) == 1);
  LLIteratorGetPayload(iter, (void **) &payload);
  Assert257(payload->num == 97);

  // free the iterator
  LLIteratorFree(iter);

  // free the linked list
  FreeLinkedList(list, &ExamplePayloadFree);
  return 0;
}


void ExamplePayloadFree(void *payload) {
  Assert257(payload != NULL);
  free(payload);
}

// prototype of our payload comparator function
int ExamplePayloadComparator(void *p1, void *p2) {
  int i1, i2;
  Assert257(p1 != NULL);
  Assert257(p2 != NULL);

  i1 = ((ExamplePayloadPtr) p1)->num;
  i2 = ((ExamplePayloadPtr) p2)->num;

  if (i1 > i2)
    return 1;
  if (i1 < i2)
    return -1;
  return 0;
}
