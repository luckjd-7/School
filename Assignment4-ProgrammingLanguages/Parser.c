#include "Parser.h"

// method to check if term
_Bool term(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("term start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(someLexics[counter].token==IDENTIFIER||someLexics[counter].token==NUMBER){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if expression
_Bool expression(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("expression start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(term(someLexics,numberOfLexics,counter) || (someLexics[counter].token==LEFT_PARENTHESIS && expression(someLexics,numberOfLexics,counter+1) && someLexics[counter+1].token==RIGHT_PARENTHESIS)){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if assignment
_Bool assignment(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("assignment start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(someLexics[counter].token==IDENTIFIER && someLexics[counter+1].token==EQUAL && expression(someLexics,numberOfLexics,counter+2) && someLexics[counter+3].token==EOL
    && count < (numberOfLexics - 3)){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if return
_Bool Return(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("return start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(someLexics[counter].token==RETURN_KEYWORD && expression(someLexics,numberOfLexics,counter+1) && someLexics[counter+2].token==EOL
    && count < (numberOfLexics - 3)){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if while loop
_Bool whileLoop(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("whileLoop start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(someLexics[counter].token==WHILE_KEYWORD && someLexics[counter+1].token==LEFT_PARENTHESIS && expression(someLexics,numberOfLexics,counter+2) && someLexics[counter+3].token==RIGHT_PARENTHESIS && statement(someLexics,numberOfLexics,counter+4) 
    && count < (numberOfLexics - 5)){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if statement
_Bool statement(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("statement start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(whileLoop(someLexics,numberOfLexics,counter) || Return(someLexics,numberOfLexics,counter) || assignment(someLexics,numberOfLexics,counter) || body(someLexics,numberOfLexics,counter)){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if statement list
_Bool statementList(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("statementList start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(statement(someLexics,numberOfLexics,counter) || (statement(someLexics,numberOfLexics,counter) && statementList(someLexics,numberOfLexics,counter+1))){
        return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if body
_Bool body(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("body start: \n");
    // printf("count: %d\n", *count);
    int counter = count;
    if(someLexics[counter].token==LEFT_BRACKET && (statementList(someLexics,numberOfLexics,counter+1) && someLexics[counter+2].token==RIGHT_BRACKET)){
        return TRUE;
        // if(statementList(someLexics,numberOfLexics,counter+1)){
        //     if(someLexics[counter+2].token==RIGHT_BRACKET){
        //         return TRUE;
        //     }
        //     else
        //     {
        //         return FALSE;
        //     }
            
        // }
        // else
        // {
        //     return FALSE;
        // }
            
    }
    else{
        return FALSE;
    }
}

// method to check if arg decl
_Bool arDecl(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("arDecl start: \n");
    int counter = count;
    // printf("count: %d\n", count);
    // //*count = counter + 1;
    // printf("count: %d\n", count);

    if((someLexics[counter].token==VARTYPE && someLexics[counter+1].token==IDENTIFIER) ||
    (someLexics[counter].token==VARTYPE && someLexics[counter+1].token==IDENTIFIER && someLexics[counter+2].token==COMMA && arDecl(someLexics,numberOfLexics,counter+3))){
         return TRUE;
    }
    else{
        return FALSE;
    }
}

// method to check if header
_Bool header(struct lexics *someLexics, int numberOfLexics, int count){
    // printf("header start: \n");
    // printf("count: %d\n", count);
    int counter = count;
    if(someLexics[counter].token==VARTYPE && someLexics[counter+1].token==IDENTIFIER && someLexics[counter+2].token==LEFT_PARENTHESIS && arDecl(someLexics,numberOfLexics,counter+3) && someLexics[counter+4].token==RIGHT_PARENTHESIS){
        return TRUE;
        //  count = counter + 3;
        //  printf("count: %d\n", count);
        //  if(arDecl(someLexics,numberOfLexics,count)){
        //      counter = count;
        //      count = counter + 3;
        //      printf("count: %d\n", count);
        //      if(someLexics[counter].token==RIGHT_PARENTHESIS){
        //          return TRUE;
        //      }
        //      else
        //      {
        //          return FALSE;
        //      }
        //  }
    }
    else{
        return FALSE;
    }
}

// method to check if function
_Bool function(struct lexics *someLexics, int numberOfLexics, int count){
    //printf("function start: \n");
    //printf("count: %d\n", *count);
    int counter = count;
    if(header(someLexics,numberOfLexics,counter) && body(someLexics,numberOfLexics,counter+1)){
        return FALSE;
    }
    else{
        return TRUE;
    }
}

// main method for parsing
_Bool parser(struct lexics *someLexics, int numberOfLexics){
    int count = 0;
    //printf("parser start: \n");
    if(someLexics[0].token!=VARTYPE){
        return FALSE;
    }
    if(someLexics[1].token!=IDENTIFIER){
        return FALSE;
    }
    if(someLexics[2].token!=LEFT_PARENTHESIS){
        return FALSE;
    }
    if(!arDecl(someLexics,numberOfLexics,3 && someLexics[3].token!=RIGHT_PARENTHESIS)){
        if(someLexics[5].token!=RIGHT_PARENTHESIS && someLexics[5].token!=COMMA){
            return FALSE;
        }
        return TRUE;
    }
    return function(someLexics,numberOfLexics,count);
}