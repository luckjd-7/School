#ifndef _PR2_TEST_HASHTABLE_H_
#define _PR2_TEST_HASHTABLE_H_

#include "gtest/gtest.h"

namespace pr2 {

class Test_HashTable : public ::testing::Test {
 protected:
  Test_HashTable() {
    // Do set-up work for each test here.
  }

  virtual ~Test_HashTable() {
    // Do clean-up work for each test here.
  }

  virtual void SetUp() {
    // Code here will be called after the constructor and
    // right before each test.
  }

  virtual void TearDown() {
    // Code here will be called after each test and
    // right before the destructor.
  }

  static void SetUpTestCase() {
    // Code here will be called once for the entire
    // text fixture.  Note it is a static member function
    // (i.e., a class method, not an object instance method).
  }

  static void TearDownTestCase() {
    // Code here will be called once for the entire
    // text fixture.  Note it is a static member function
    // (i.e., a class method, not an object instance method).
  }

  // Objects declared here can be used by all tests in
  // the test case.
};  // class Test_HashTable

}  // namespace pr2

#endif  // _PR2_TEST_HASHTABLE_H_
