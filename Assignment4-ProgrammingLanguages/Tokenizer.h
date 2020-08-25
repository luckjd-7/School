#ifndef TOKENIZER_H
#define TOKENIZER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Givens.h"

// method to tokenize incoming file
_Bool tokenizer(struct lexics *aLex, int *numLex, FILE *inf); 

#endif