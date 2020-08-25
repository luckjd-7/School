    #include "Tokenizer.h"
    
    #define readChar(ch, f); (ch = fgetc(f)) 
    #define isLetter(ch) (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ch == '_')
    #define isDigit(ch)  ('0' <= ch && ch <= '9')
    #define isSymbol(ch)  (ch == '(' || ch == ')' || ch == '{' || ch == '}' || '=' == ch || ',' == ch||  ';' == ch|| '%' == ch|| '+' == ch|| '*' == ch || '==' == ch|| '!=' == ch)
    #define isEmpty(ch) (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r') 

    // method to check next character
    char peekChar(FILE* inf) {
        fpos_t pos;
        char ch; 
        fgetpos(inf, &pos);
        readChar(ch, inf);
        fsetpos(inf, &pos);
        return ch;
    }

    // method to check string
    char peekString(FILE* inf,char input[]) {
        fpos_t pos;
        fgetpos(inf, &pos);
        fgets(input,MY_CHAR_MAX, inf);
        fsetpos(inf, &pos);
        return input[0];
    }

    // method to read numbers
    int readNumber(FILE* inf, char ch, char* number,int *numLex) {

        int size = 1;
        number[0] = ch;
        while (isDigit(peekChar(inf))) {
            readChar(ch, inf);
            number[size] = ch;
            size++;
        }
        //printf("%s\n",number);
        number[size] = '\0';
        return NUMBER;

    }

    // method to read symbols
    int readSymbol(FILE* inf, char ch, char* symbol,struct lexics *aLex,int *numLex) {

        int size = 1;
        symbol[0] = ch;
        symbol[size] = '\0';
        //printf("symbol: %s\n",symbol);
        if (strcmp(symbol, "(") == 0) {
            return LEFT_PARENTHESIS;
        } else if (strcmp(symbol, ")") == 0) {
            return RIGHT_PARENTHESIS;
        } else if (strcmp(symbol, "{") == 0) {
            return LEFT_BRACKET;
        } else if (strcmp(symbol, "}") == 0) {
            return RIGHT_BRACKET;
        } else if (strcmp(symbol, "=") == 0) {
            return EQUAL;
        } else if (strcmp(symbol, ",") == 0) {
            return COMMA;
        } else if (strcmp(symbol, ";") == 0) {
            return EOL;
        } else {
            return BINOP;
        }
    }

    // method to read identifiers
    int readIdentifier(FILE *inf, char ch, char* str,struct lexics *aLex,int *numLex) {

        int size = 1;
        str[0] = ch;
        while ((isLetter(peekChar(inf)) || isDigit(peekChar(inf))) && !isEmpty(peekChar(inf))) {
            readChar(ch, inf);
            str[size] = ch;
            size++;
        }
        str[size] = '\0';
        //printf("str: %s\n",str);
        if (strcmp(str, "while") == 0) {
            return WHILE_KEYWORD;
        } else if (strcmp(str, "return") == 0) {
            return RETURN_KEYWORD;
        } else if (strcmp(str, "int") == 0 || strcmp(str, "void") == 0) {
            return VARTYPE;
        } else {
            return IDENTIFIER;
        }
    }

    // main tokenizer method
    _Bool tokenizer(struct lexics *aLex, int *numLex, FILE *inf){
        char input[MY_CHAR_MAX];
        char output[MY_CHAR_MAX];
        char ch;
        peekString(inf,input);
        //printf("%s\n",input);
        readChar(ch, inf);
        if (feof(inf)) {
            return NULL; 
        }
        while(feof(inf)<1){
            while (isEmpty(ch)) {
            readChar(ch, inf);   
                if (feof(inf)) {
                    return NULL; 
                }
            }
            if(isDigit(ch)){
                aLex[*numLex].token = readNumber(inf,ch,output,numLex);
                strcpy(aLex[*numLex].lexeme,output);
            }
            else if(isLetter(ch)){
               // printf("is letter \n");
                aLex[*numLex].token = readIdentifier(inf,ch,output,aLex,numLex);
                strcpy(aLex[*numLex].lexeme,output);
            }
            else if(isSymbol(ch)){
                //printf("is symbol \n");
                aLex[*numLex].token = readSymbol(inf,ch,output,aLex,numLex);
                strcpy(aLex[*numLex].lexeme,output);
            }
            //printf("token: %d\n",aLex[*numLex].token);
            *numLex = *numLex + 1;
            readChar(ch, inf);
            //printf("numlex: %d\n",*numLex);
        }
        return TRUE;
    }