#include "gtest/gtest.h"

using std::cout;
using std::endl;

unsigned int pr2_maxpoints = 230;
unsigned int pr2_points = 0;

void PR2ResetPoints() {
  pr2_points = 0;
}

void PR2Addpoints(unsigned int points) {
  pr2_points += points;
  cout << " (" << pr2_points << "/" << pr2_maxpoints << ")" << endl;
}

class PR2Environment : public ::testing::Environment {
 public:

  virtual void SetUp() {
    // Code here is run once for the entire test suite.
    cout << "PR2: there are " << pr2_maxpoints;
    cout << " points available." << endl;
  }
  virtual void TearDown() {
    // Code here is run once for the entire test suite.
    cout << endl;
    cout << "You earned " << pr2_points << " out of ";
    cout << pr2_maxpoints << " points available (";
    cout << ((100.0*pr2_points) / pr2_maxpoints) << "%)" << endl;
    cout << endl;
  }
};

int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  ::testing::AddGlobalTestEnvironment(new PR2Environment);
  return RUN_ALL_TESTS();
}
