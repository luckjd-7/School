#ifndef PARSER_H
#define PARSER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Givens.h"


// method to parse tokens and see if they fit into the grammar
_Bool parser(struct lexics *someLexics, int numberOfLexics);

_Bool term(struct lexics *someLexics, int numberOfLexics, int count);

_Bool statement(struct lexics *someLexics, int numberOfLexics, int count);

_Bool function(struct lexics *someLexics, int numberOfLexics, int count);

_Bool header(struct lexics *someLexics, int numberOfLexics, int count);

_Bool argDecl(struct lexics *someLexics, int numberOfLexics, int count);

_Bool body(struct lexics *someLexics, int numberOfLexics, int count);

_Bool statementList(struct lexics *someLexics, int numberOfLexics, int count);

_Bool whileLoop(struct lexics *someLexics, int numberOfLexics, int count);

_Bool Return(struct lexics *someLexics, int numberOfLexics, int count);

_Bool assignment(struct lexics *someLexics, int numberOfLexics, int count);

_Bool expression(struct lexics *someLexics, int numberOfLexics, int count);



#endif