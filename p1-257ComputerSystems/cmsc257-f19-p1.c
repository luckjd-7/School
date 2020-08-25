////////////////////////////////////////////////////////////////////////////////
//
//  File           : cmsc257-f19-p1.c
//  Description    : This is the main source code for for the first assignment
//                   of CMSC257.  See the related assignment page for details.
//
//   Author        : Joey Luck
//   Last Modified : 10/06/2019
//

// Include Files
#include <stdio.h>
#include <math.h>
#include <stdlib.h>

// Project Includes
#include "p1-support.h"

//
// Functions

////////////////////////////////////////////////////////////////////////////////
//
// Function     : main
// Description  : The main function for the CMSC257 project #1
//
// Inputs       : argc - the number of command line parameters
//                argv - the parameters
// Outputs      : 0 if successful test, -1 if failure

// Function 	: ???
// ???
int main(int argc, char *argv[]) {

	// Local variables
	// NOTE: this is where you will want to add some new variables
	int int_array1[10], int_array2[10];
	unsigned int uint_array1[10];
    int i;

    //????
    //int n;

    if (argc < 11)
	{
		printf("Exiting the program, missing input");
		return 0;
	}

	// Step a - read in the integer numbers to process
	for (i=1; i<11; i++) {
        //scanf("%d\n",&n);
		int_array1[i-1] = atoi(argv[i]);//converting input to integer
		//int_array2[i-1] = n;

	}
	bitwise_abs(int_array1,int_array2); //performs abs operations on array
	printf("abs array 2: ");
	display_array(int_array2); //prints array
	printf("\n");

	printf("mod array: ");
	bitwise_mod128(int_array2); //performs 128 mod operation
	display_array(int_array2);
	printf("\n");

	printArrayInfo(int_array2);

	intToShort(int_array2,uint_array1);//transfers int array to unsigned int array
	swap_ints(uint_array1); //swaps values in array
	update(uint_array1); //performs reverse bits operation on each element of array
	printf("\n array with binary: \n");
	printArrayWithBinary(uint_array1); // prints array along with binary string

    // Step b - Convert numbers into positive values by taking their
	//           absolute values and save them in int_array2.
	// Print all numbers in a single line using display_array function
    // ????

    // Step c - Convert these positive integers to numbers
	//           in the range 0,…,128 by implementing the  mod operation
	//           save them back into int_array2.
	// Print all numbers in a single line using display_array function
    // ????

    // Step d - for each integer in int_array2 print:
	//           number, number of 1 bits, even or odd
    //????

    // Step e - Cast each element of int_array2 to unsigned short
	//			 and store them into uint_array1.
    // ????

    // Step f - Reverse the order of array elements in uint_array1
	//           using swap function.
    // ????

    // Step g - Update each element of uint_array1 by using reverseBits function.
    // ????

    // Step h - Print each element of uint_array1 in a separate line along with
	//           binary representation of each of the numbers using binaryString function.
    //????

	// Return successfully
	return(0);
}
