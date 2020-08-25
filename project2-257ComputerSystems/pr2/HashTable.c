// luckjd Joey luck
// cmsc 257 project 2

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#include "Assert257.h"
#include "HashTable.h"
#include "HashTable_priv.h"

// A private utility function to grow the hashtable (increase
// the number of buckets) if its load factor has become too high.
static void ResizeHashtable(HashTable ht);

// a free function that does nothing
static void NullFree(void *freeme) { }

HashTable AllocateHashTable(uint32_t num_buckets) {
  HashTable ht;
  uint32_t  i;

  // defensive programming
  if (num_buckets == 0) {
    return NULL;
  }

  // allocate the hash table record
  ht = (HashTable) malloc(sizeof(HashTableRecord));
  if (ht == NULL) {
    return NULL;
  }

  // initialize the record
  ht->num_buckets = num_buckets;
  ht->num_elements = 0;
  ht->buckets =
    (LinkedList *) malloc(num_buckets * sizeof(LinkedList));
  if (ht->buckets == NULL) {
    // make sure we don't leak!
    free(ht);
    return NULL;
  }
  for (i = 0; i < num_buckets; i++) {
    ht->buckets[i] = AllocateLinkedList();
    if (ht->buckets[i] == NULL) {
      // allocating one of our bucket chain lists failed,
      // so we need to free everything we allocated so far
      // before returning NULL to indicate failure.  Since
      // we know the chains are empty, we'll pass in a
      // free function pointer that does nothing; it should
      // never be called.
      uint32_t j;
      for (j = 0; j < i; j++) {
        FreeLinkedList(ht->buckets[j], NullFree);
      }
      free(ht);
      return NULL;
    }
  }

  return (HashTable) ht;
}

void FreeHashTable(HashTable table,
                   ValueFreeFnPtr value_free_function) {
  uint32_t i;

  Assert257(table != NULL);  // be defensive

  // loop through and free the chains on each bucket
  for (i = 0; i < table->num_buckets; i++) {
    LinkedList  bl = table->buckets[i];
    HTKeyValue *nextKV;

    // pop elements off the the chain list, then free the list
    while (NumElementsInLinkedList(bl) > 0) {
      Assert257(PopLinkedList(bl, (void **) &nextKV));
      value_free_function(nextKV->value);
      free(nextKV);
    }
    // the chain list is empty, so we can pass in the
    // null free function to FreeLinkedList.
    FreeLinkedList(bl, NullFree);
  }

  // free the bucket array within the table record,
  // then free the table record itself.
  free(table->buckets);
  free(table);
}

uint64_t NumElementsInHashTable(HashTable table) {
  Assert257(table != NULL);
  return table->num_elements;
}

uint64_t FNVHash64(unsigned char *buffer, unsigned int len) {
  // This code is adapted from code by Landon Curt Noll
  // and Bonelli Nicola:
  //
  // http://code.google.com/p/nicola-bonelli-repo/
  static const uint64_t FNV1_64_INIT = 0xcbf29ce484222325ULL;
  static const uint64_t FNV_64_PRIME = 0x100000001b3ULL;
  unsigned char *bp = (unsigned char *) buffer;
  unsigned char *be = bp + len;
  uint64_t hval = FNV1_64_INIT;

  /*
   * FNV-1a hash each octet of the buffer
   */
  while (bp < be) {
    /* xor the bottom with the current octet */
    hval ^= (uint64_t) * bp++;
    /* multiply by the 64 bit FNV magic prime mod 2^64 */
    hval *= FNV_64_PRIME;
  }
  /* return our new hash value */
  return hval;
}

uint64_t FNVHashInt64(uint64_t hashme) {
  unsigned char buf[8];
  int i;

  for (i = 0; i < 8; i++) {
    buf[i] = (unsigned char) (hashme & 0x00000000000000FFULL);
    hashme >>= 8;
  }
  return FNVHash64(buf, 8);
}

uint64_t HashKeyToBucketNum(HashTable ht, uint64_t key) {
  return key % ht->num_buckets;
}

int foundInHashTable(uint32_t key, LLIter *iter, LinkedList chain,
    HTKeyValue **valuePtr) {
	if (NumElementsInLinkedList(chain) == 0) {
	  return 0;
  }
	do {
    LLIteratorGetPayload(*iter, (void **) valuePtr);
    if ((*valuePtr)->key == key) {
     	return 1;
    }
  } while (LLIteratorNext(*iter));
  return 0;
}

int InsertHashTable(HashTable table,
                    HTKeyValue newkeyvalue,
                    HTKeyValue *oldkeyvalue) {
  uint32_t insertbucket;
  LinkedList insertchain;

  Assert257(table != NULL);
  ResizeHashtable(table);

  // calculate which bucket we're inserting into,
  // grab its linked list chain
  insertbucket = HashKeyToBucketNum(table, newkeyvalue.key);
  insertchain = table->buckets[insertbucket];

  // Step 1 -- finish the implementation of InsertHashTable.
  // This is a fairly complex task, so you might decide you want
  // to define/implement a helper function that helps you find
  // and optionally remove a key within a chain, rather than putting
  // all that logic inside here.  You might also find that your helper
  // can be reused in steps 2 and 3.
  // allocate size
  HTKeyValue *keyValue = (HTKeyValue*) malloc(sizeof(HTKeyValue));
  if (keyValue == NULL) {
      return 0;
  }
  // instanciate variables
  HTKeyValuePtr bucket;
  HTKeyValuePtr *valuePtr = &bucket;
  *keyValue = newkeyvalue;
  // if there isn't an element in the chain
  // the insert the new values into the hast table
  if (NumElementsInLinkedList(insertchain) == 0) {
    if (PushLinkedList(insertchain, keyValue)) {
      table->num_elements++;
      return 1;
    }
    free(keyValue);
    return 0;
  }
  // making an iterator 
  LLIter iter = LLMakeIterator(insertchain, 0);
  if (iter == NULL) {
    free(keyValue);
    return 0;
  }
  // searches hashtable
  int found = foundInHashTable(newkeyvalue.key, &iter, insertchain, valuePtr);
  // if the key wasn't there then insert new key value into the hashtable
  if (found == 0 && PushLinkedList(insertchain, (void *)keyValue)) {
      table->num_elements += 1;
      LLIteratorFree(iter);
      return 1;
  } 
  // if the key is found replace it with the new key value
  else if (found == 1 && PushLinkedList(insertchain, (void *)keyValue)) {
  		*oldkeyvalue = **valuePtr;
  		LLIteratorDelete(iter, NullFree);
      LLIteratorFree(iter);
    	free(*valuePtr);
    	return 2;
  }
  LLIteratorFree(iter);
  free(keyValue);
  return 0;  // You may need to change this return value.
}

int LookupHashTable(HashTable table,
                    uint64_t key,
                    HTKeyValue *keyvalue) {
  Assert257(table != NULL);

  // Step 2 -- implement LookupHashTable.
  // instanciate variables
  uint32_t insert;
  LinkedList insertList;
  insert = HashKeyToBucketNum(table, key);
  insertList = table->buckets[insert];
  HTKeyValuePtr value;
  HTKeyValuePtr *valuePtr = &value;
  if (insertList == NULL) {
    return -1;
  }
  if (NumElementsInLinkedList(insertList) == 0)
    return 0;
  LLIter iter = LLMakeIterator(insertList, 0);
  if (iter == NULL) {
    return 0;
  }
  // searches the hashtable
  int found = foundInHashTable(key, &iter, insertList, valuePtr);
  if (found == 1) {
    keyvalue->key = (*valuePtr)->key;
    keyvalue->value = (*valuePtr)->value;
    LLIteratorFree(iter);
    return 1;
  }
  else {
    LLIteratorFree(iter);
    return 0;  // you may need to change this return value.
  }
}

int RemoveFromHashTable(HashTable table,
                        uint64_t key,
                        HTKeyValue *keyvalue) {
  Assert257(table != NULL);

  // Step 3 -- impelment RemoveFromHashTable.
  uint32_t insert;
  LinkedList insertList;
  insert = HashKeyToBucketNum(table, key);
  insertList = table->buckets[insert];
  HTKeyValuePtr value;
  HTKeyValuePtr *valuePtr = &value;
  // if no element in list
  if (NumElementsInLinkedList(insertList) == 0)
    return 0;
  LLIter iter = LLMakeIterator(insertList, 0);
  if (iter == NULL) {
    return -1;
  }
  int found = foundInHashTable(key, &iter, insertList, valuePtr);
  if (found == 0) {
    // the key wasn't found in the hashtable
    LLIteratorFree(iter);
    return 0;
  } 
  else {
    //the key was found
    *keyvalue = **valuePtr;
    free(*valuePtr);
    LLIteratorDelete(iter, NullFree);
    table->num_elements--;
    LLIteratorFree(iter);
    return 1;
  }
}

HTIter HashTableMakeIterator(HashTable table) {
  HTIterRecord *iter;
  uint32_t      i;

  Assert257(table != NULL);  // be defensive

  // malloc the iterator
  iter = (HTIterRecord *) malloc(sizeof(HTIterRecord));
  if (iter == NULL) {
    return NULL;
  }

  // if the hash table is empty, the iterator is immediately invalid,
  // since it can't point to anything.
  if (table->num_elements == 0) {
    iter->is_valid = false;
    iter->ht = table;
    iter->bucket_it = NULL;
    return iter;
  }

  // initialize the iterator.  there is at least one element in the
  // table, so find the first element and point the iterator at it.
  iter->is_valid = true;
  iter->ht = table;
  for (i = 0; i < table->num_buckets; i++) {
    if (NumElementsInLinkedList(table->buckets[i]) > 0) {
      iter->bucket_num = i;
      break;
    }
  }
  Assert257(i < table->num_buckets);  // make sure we found it.
  iter->bucket_it = LLMakeIterator(table->buckets[iter->bucket_num], 0UL);
  if (iter->bucket_it == NULL) {
    // out of memory!
    free(iter);
    return NULL;
  }
  return iter;
}

void HTIteratorFree(HTIter iter) {
  Assert257(iter != NULL);
  if (iter->bucket_it != NULL) {
    LLIteratorFree(iter->bucket_it);
    iter->bucket_it = NULL;
  }
  iter->is_valid = false;
  free(iter);
}

int HTIteratorNext(HTIter iter) {
  Assert257(iter != NULL);

  // Step 4 -- implement HTIteratorNext.
  if (iter->ht->num_elements != 0 || iter->is_valid ||
      iter->bucket_it != NULL) {
    if (LLIteratorNext(iter->bucket_it)) {
      return 1;
    } 
    else {
      int num = iter->ht->num_buckets +1;
      for (int i = iter->bucket_num + 1; i < iter->ht->num_buckets; i++) {
        if (NumElementsInLinkedList(iter->ht->buckets[i]) > 0) {
          num = i;
          iter->bucket_num = i;
          break;
        }
      }
      if (num >= iter->ht->num_buckets) {
        iter->is_valid = false;
        return 0;
      } 
      else {
        LLIteratorFree(iter->bucket_it);
        iter->bucket_it = LLMakeIterator(iter->ht->buckets[num], 0);
        if (iter->bucket_it == NULL) {
          HTIteratorFree(iter);
          return 0;
        }
        return 1;
      }
    }
  } 
  else {
    iter->is_valid = false;
    return 0;
  }
}

int HTIteratorPastEnd(HTIter iter) {
  Assert257(iter != NULL);

  // Step 5 -- implement HTIteratorPastEnd.
    if (iter->ht->num_elements == 0 || !iter->is_valid) {
    return 1;
  }
  return 0;  // you might need to change this return value.
}

int HTIteratorGet(HTIter iter, HTKeyValue *keyvalue) {
  Assert257(iter != NULL);

  // Step 6 -- implement HTIteratorGet.
  if (iter->ht->num_elements != 0
    && iter->is_valid) {
    HTKeyValuePtr value;
    HTKeyValuePtr *valuePtr = &value;
    LLIteratorGetPayload(iter->bucket_it, (void **) valuePtr);
    *keyvalue = **valuePtr;
    return 1;
 }
  return 0;  // you might need to change this return value.
}

int HTIteratorDelete(HTIter iter, HTKeyValue *keyvalue) {
  HTKeyValue kv;
  int res, retval;

  Assert257(iter != NULL);

  // Try to get what the iterator is pointing to.
  res = HTIteratorGet(iter, &kv);
  if (res == 0)
    return 0;

  // Advance the iterator.
  res = HTIteratorNext(iter);
  if (res == 0) {
    retval = 2;
  } else {
    retval = 1;
  }
  res = RemoveFromHashTable(iter->ht, kv.key, keyvalue);
  Assert257(res == 1);
  Assert257(kv.key == keyvalue->key);
  Assert257(kv.value == keyvalue->value);

  return retval;
}

static void ResizeHashtable(HashTable ht) {
  // Resize if the load factor is > 3.
  if (ht->num_elements < 3 * ht->num_buckets)
    return;

  // This is the resize case.  Allocate a new hashtable,
  // iterate over the old hashtable, do the surgery on
  // the old hashtable record and free up the new hashtable
  // record.
  HashTable newht = AllocateHashTable(ht->num_buckets * 9);

  // Give up if out of memory.
  if (newht == NULL)
    return;

  // Loop through the old ht with an iterator,
  // inserting into the new HT.
  HTIter it = HashTableMakeIterator(ht);
  if (it == NULL) {
    // Give up if out of memory.
    FreeHashTable(newht, &NullFree);
    return;
  }

  while (!HTIteratorPastEnd(it)) {
    HTKeyValue item, dummy;

    Assert257(HTIteratorGet(it, &item) == 1);
    if (InsertHashTable(newht, item, &dummy) != 1) {
      // failure, free up everything, return.
      HTIteratorFree(it);
      FreeHashTable(newht, &NullFree);
      return;
    }
    HTIteratorNext(it);
  }

  // Worked!  Free the iterator.
  HTIteratorFree(it);

  // Sneaky: swap the structures, then free the new table,
  // and we're done.
  {
    HashTableRecord tmp;

    tmp = *ht;
    *ht = *newht;
    *newht = tmp;
    FreeHashTable(newht, &NullFree);
  }

  return;
}
