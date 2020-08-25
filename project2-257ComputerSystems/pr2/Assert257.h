#ifndef _PR2_ASSERT257_H_
#define _PR2_ASSERT257_H_

// A wrapper for assert that permits side-effects within the
// Assert257() statement.  Borrowed from:
//
//   http://www.acm.uiuc.edu/sigops/roll_your_own/2.a.html

void AssertionFailure(const char *exp, const char *file,
                      const char *basefile, int line);

#define Assert257(exp) if (exp) ; \
  else AssertionFailure(#exp, __FILE__, __BASE_FILE__, __LINE__)

#endif  // _PR2_ASSERT257_H_
