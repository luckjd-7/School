#ifndef CMSC257_A1SUPPORT_INCLUDED
#define CMSC257_A1SUPPORT_INCLUDED

////////////////////////////////////////////////////////////////////////////////
//
//  File          : cmsc257-s17-assign1-support.h
//  Description   : This is a set of general-purpose utility functions we use
//                  for the 257 assignment #1.
//
// Joey Luck
//
// Functional Prototypes
//displays an array
void display_array(int *arr);//?? fix this function prototype
	// This function prints out the array of integer values
//counts bits from int
int countBits(unsigned int n);
	// return the number of nonzero bits in an integer
//reverse int bits
unsigned int reverseBits(unsigned int num);
//creates a binary string from an int
void binaryString(int num);
//performs bitwise 128 modular operation
void bitwise_mod128(unsigned int *arr);
//gets absolute values from array
void bitwise_abs(int *arr, int *arr2);
//returns even or odd
char* evenOrOdd(int num);
//swaps values in array
void swap_ints(unsigned int *arr);
//moves value from int array to unsigned array
void intToShort(int *arr, unsigned int *uarr);
//prints info about array
void printArrayInfo(int *arr);
//uses reverse method on each element of array
void update(unsigned int *arr);
//prints reverse array with binary string
void printArrayWithBinary(unsigned int *arr);

//??? binaryString(???);

//??? bitwise_mod128(???);

//??? bitwise_abs(???);

//??? bit_get(???);

//??? evenOrOdd(???);

//??? swap_ints(???);

//??? add other helper functions as needed. functions above are minimums.


#endif // CMSC257_A1SUPPORT_INCLUDED
