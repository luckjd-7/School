#ifndef _PR2_TEST_LINKEDLIST_H_
#define _PR2_TEST_LINKEDLIST_H_

#include "gtest/gtest.h"

namespace pr2 {

class Test_LinkedList : public ::testing::Test {
 protected:
  Test_LinkedList() {
    // Do set-up work for each test here.
  }

  virtual ~Test_LinkedList() {
    // Do clean-up work for each test here.
  }

  virtual void SetUp() {
    // Code here will be called after the constructor and
    // right before each test.
  }

  virtual void TearDown() {
    // Code here will be called after each test and
    // right before the destructor.

    // Verify that none of the tests modifies any of the
    // testing constants.
    EXPECT_EQ(1U, kOne);
    EXPECT_EQ(2U, kTwo);
    EXPECT_EQ(3U, kThree);
    EXPECT_EQ(4U, kFour);
    EXPECT_EQ(5U, kFive);
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

  // These values are used as payloads for the LinkedList tests.
  // They cannot be const, as stored value pointers are non-const.
  static uint64_t kOne, kTwo, kThree, kFour, kFive;
};  // class Test_LinkedList

}  // namespace pr2

#endif  // _PR2_TEST_LINKEDLIST_H_
