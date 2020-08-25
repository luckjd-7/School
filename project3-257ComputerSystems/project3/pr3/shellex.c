/* @Joey Luck // Joseph Luck */


/* $begin shellmain */
#include "csapp.h"
#define MAXARGS   128

/* Function prototypes */
void eval(char *cmdline);
void help();
void cd(char **argv);
void sigHandler(int sig_num);
int parseline(char *buf, char **argv);
int builtin_command(char **argv); 

int main(int argc, char *argv[]) 
{
    char cmdline[MAXLINE]; /* Command line */
    signal(SIGINT, sigHandler);
    while (1) {
	/* checks for arguments */
    if(argc >= 3&&argv[1]&&!strcmp(argv[1], "-p")){
	    printf("%s> ",argv[2]); /* sets prompt name */
    }
    else if(argc == 2&&argv[1]&&!strcmp(argv[1], "-p")){
        printf("no argument for prompt\n");
        printf("my257sh> ");  /* sets default but with message saying no argument given after -p */
    }
    else{
        printf("my257sh> "); /* default */
    }
    /* Read */
	Fgets(cmdline, MAXLINE, stdin); 
	if (feof(stdin))
	    exit(0);

	/* Evaluate */
	eval(cmdline);
    } 
}
/* $end shellmain */
  
/* $begin eval */
/* eval - Evaluate a command line */
void eval(char *cmdline) 
{
    char *argv[MAXARGS]; /* Argument list execve() */
    char buf[MAXLINE];   /* Holds modified command line */
    int bg;              /* Should the job run in bg or fg? */
    pid_t pid;           /* Process id */
    
    strcpy(buf, cmdline);
    bg = parseline(buf, argv); 
    if (argv[0] == NULL)  
	return;   /* Ignore empty lines */
    if (!builtin_command(argv)) { 
        if ((pid = Fork()) == 0) {   /* Child runs user job */
            if (execvp(argv[0], argv) < 0) {
                printf("Execution failed (in fork)\n"); 
                printf(": No such file or directory\n");
                exit(1);
            }
        }
    

	/* Parent waits for foreground job to terminate */
	    if (!bg) {
	        int status;
	        if (waitpid(pid, &status, 0) < 0){
		        unix_error("waitfg: waitpid error");
            }
            /* prints child exit status */ 
            if (WIFEXITED(status)) {
            int es = WEXITSTATUS(status);
            printf("Child exit status %d\n", es);
        }
        }
	    else
	        printf("%d %s", pid, cmdline);
    }
    return;
}
/* If first arg is a builtin command, run it and return true */
int builtin_command(char **argv) 
{
    if (!strcmp(argv[0], "quit")){ /* quit command */
	exit(0);  
    }
    if (!strcmp(argv[0], "&")){   /* Ignore singleton & */
	return 1;
    }
    if(!strcmp(argv[0], "exit")){ /* exit command */
    printf("Terminated\n");
    exit(0);
    }
    if(!strcmp(argv[0], "pid")){ /* pid command */
    printf("%d\n", getpid());
    return 1;
    }
    if(!strcmp(argv[0], "ppid")){ /* ppid command */
    printf("%d\n", getppid());
    return 1;
    }
    if(!strcmp(argv[0], "help")){ /* help command */
    help();
    return 1;
    }
    if(!strcmp(argv[0], "cd")){ /* change directory command */
    cd(argv);
    return 1;
    }
    else
    return 0;                     /* Not a builtin command */
}
/* handles ctrl C input */
void sigHandler(int sig_num) 
{ 
    signal(SIGINT, sigHandler);
    fflush(stdout); 
} 
/* changes directory or prints current directory */
void cd(char **argv){
    char buf[FILENAME_MAX];
    /* changes directory */
    if(argv[1]!=NULL){
        chdir(argv[1]);
    }
    /* prints current directory */
    else if(argv[0]!="NULL"){
        getcwd(buf, FILENAME_MAX);
        printf("%s\n",buf);
    }
    /* no such directory */
    else
    {
        printf("No such Directory\n");
    }
}
/* prints built in commands */
void help(){
   printf("Joey Luck\n");
   printf("./my257sh -p <prompt> allows user to select a user-defined shell prompt\n");
   printf("Built in commands:\n");
   printf("pid: gets current pid\n");
   printf("ppid: gets current ppid\n");
   printf("quit: quits program\n");
   printf("exit: quits program\n");
   printf("help: brings up list of built in commands\n");
   printf("cd: changed directory\n");
   printf("use man for non built in commands\n");
}
/* $end eval */
/* $begin parseline */
/* parseline - Parse the command line and build the argv array */
int parseline(char *buf, char **argv) 
{
    char *delim;         /* Points to first space delimiter */
    int argc;            /* Number of args */
    int bg;              /* Background job? */

    buf[strlen(buf)-1] = ' ';  /* Replace trailing '\n' with space */
    while (*buf && (*buf == ' ')) /* Ignore leading spaces */
	buf++;

    /* Build the argv list */
    argc = 0;
    while ((delim = strchr(buf, ' '))) {
	argv[argc++] = buf;
	*delim = '\0';
	buf = delim + 1;
	while (*buf && (*buf == ' ')) /* Ignore spaces */
            buf++;
    }
    argv[argc] = NULL;
    
    if (argc == 0)  /* Ignore blank line */
	return 1;

    /* Should the job run in the background? */
    if ((bg = (*argv[argc-1] == '&')) != 0)
	argv[--argc] = NULL;

    return bg;
}
/* $end parseline */

