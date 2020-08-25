#include <stdio.h>
#include <stdlib.h>

#include "Assert257.h"
#include "HashTable.h"

typedef struct {
  int num;
} ExampleValue, *ExampleValuePtr;

// prototype of our free function
void ExampleValueFree(void *value);

// our main function; here, we demonstrate how to use some
// of the hash table functions
int main(int argc, char **argv) {
  ExampleValuePtr evp;
  HashTable ht;
  HTIter iter;
  HTKeyValue kv, old_kv;
  int i;

  // allocate a hash table with 10,000 initial buckets
  ht = AllocateHashTable(10000);
  Assert257(ht != NULL);

  // insert 20,000 elements (load factor = 2.0)
  for (i = 0; i < 20000; i++) {
    evp = (ExampleValuePtr) malloc(sizeof(ExampleValue));
    Assert257(evp != NULL);
    evp->num = i;

    // make sure HT has the right # of elements in it to start
    Assert257(NumElementsInHashTable(ht) == (uint64_t) i);

    // insert a new element
    kv.key = FNVHashInt64(i);
    kv.value = (void *) evp;
    Assert257(InsertHashTable(ht, kv, &old_kv) == 1);

    // make sure hash table has right # of elements post-insert
    Assert257(NumElementsInHashTable(ht) == (uint64_t) (i+1));
  }

  // look up a few values
  Assert257(LookupHashTable(ht, FNVHashInt64(100), &kv) == 1);
  Assert257(kv.key == FNVHashInt64(100));
  Assert257(((ExampleValuePtr) kv.value)->num == 100);

  Assert257(LookupHashTable(ht, FNVHashInt64(18583), &kv) == 1);
  Assert257(kv.key == FNVHashInt64(18583));
  Assert257(((ExampleValuePtr) kv.value)->num == 18583);

  // make sure non-existent value cannot be found
  Assert257(LookupHashTable(ht, FNVHashInt64(20000), &kv) == 0);

  // delete a value
  Assert257(RemoveFromHashTable(ht, FNVHashInt64(100), &kv) == 1);
  Assert257(kv.key == FNVHashInt64(100));
  Assert257(((ExampleValuePtr) kv.value)->num == 100);
  ExampleValueFree(kv.value);   // since we malloc'ed it, we must free it

  // make sure it's deleted
  Assert257(LookupHashTable(ht, FNVHashInt64(100), &kv) == 0);
  Assert257(NumElementsInHashTable(ht) == (uint64_t) 19999);

  // loop through using an iterator
  i = 0;
  iter = HashTableMakeIterator(ht);
  Assert257(iter != NULL);

  while (HTIteratorPastEnd(iter) == 0) {
    Assert257(HTIteratorGet(iter, &kv) == 1);
    Assert257(kv.key != FNVHashInt64(100));   // we deleted it

    // advance the iterator
    HTIteratorNext(iter);
    i++;
  }
  Assert257(i == 19999);

  // free the iterator
  HTIteratorFree(iter);

  // free the hash table
  FreeHashTable(ht, &ExampleValueFree);
  return 0;
}

void ExampleValueFree(void *value) {
  Assert257(value != NULL);
  free(value);
}
