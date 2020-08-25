#ifndef _PR2_HASHTABLE_PRIV_H_
#define _PR2_HASHTABLE_PRIV_H_

#include "./LinkedList.h"
#include "./HashTable.h"

// Define the internal, private structs and helper functions associated with a
// HashTable.

// This is the struct that we use to represent a hash table. Quite simply, a
// hash table is just an array of buckets, where each bucket is a linked list
// of HTKeyValue structs.
typedef struct htrec {
  uint64_t        num_buckets;   // # of buckets in this HT?
  uint64_t        num_elements;  // # of elements currently in this HT?
  LinkedList     *buckets;       // the array of buckets
} HashTableRecord;

// This is the struct we use to represent an iterator.
typedef struct ht_itrec {
  bool       is_valid;    // is this iterator valid?
  HashTable  ht;          // the HT we're pointing into
  uint64_t   bucket_num;  // which bucket are we in?
  LLIter     bucket_it;   // iterator for the bucket, or NULL
} HTIterRecord;

// This is the internal hash function we use to map from uint64_t keys to a
// bucket number.
uint64_t HashKeyToBucketNum(HashTable ht, uint64_t key);

#endif  // _PR2_HASHTABLE_PRIV_H_
