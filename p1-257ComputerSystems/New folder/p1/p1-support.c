#include <stdio.h>
#include <limits.h>

void display_array(int *arr){
    int i;
    for(i = 0; i < 10;i++){
        printf(" %d ",*arr);
        arr++;
    }
}

int countBits(unsigned int n){
    unsigned int count = 0;
    while(n){
        count += n & 1;
        n >>= 1;
    }
    return count;
}
unsigned int reverseBits(unsigned int num)
{
    unsigned int bitNum = sizeof(num) * 8;
    unsigned int reverse = 0, i, temp;

    for (i = 0; i < bitNum; i++)
    {
        temp = (num & (1 << i));
        if(temp)
            reverse |= (1 << ((bitNum - 1) - i));
    }

    return reverse;
}

char* evenOrOdd(int num)
{
        if(num % 2 == 0){
                return "even";
        }
        else {
                return "odd";
        }
}
void printArrayInfo(int *arr){
    int i;
    for(i = 0;i<10;i++){
       printf("number %d : %d number of 1 bits: %u  %s \n",i,arr[i],countBits(arr[i]),evenOrOdd(arr[i]));
    }

}
int abs(int);
void bitwise_abs(int *arr, int *arr2){
    int i;
    for(i = 0;i<10;i++){
        arr2[i] = abs(arr[i]);
    }
}
void bitwise_mod128(unsigned int *arr){
    int i;
    for(i=0;i<10;i++){
        arr[i] = arr[i]%128;
    }
}
void intToShort(int *arr, unsigned int *uarr){
    int i;
    for(i=0;i<10;i++){
        uarr[i] = (unsigned)arr[i];
    }
}
void swap_ints(unsigned int *arr){
    int i, temp;
    int j = 9;
    for(i=0;i<j;i++){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
    }
}
void update(unsigned int *arr){
    int i;
    for(i=0;i<10;i++){
        arr[i] = reverseBits(arr[i]);
    }
}
void binaryString(int num){
    int i,k,andmask;

    for(i=32;i>=0;i--)
    {
        andmask = 1 << i;
        k = num & andmask;

        k == 0 ? printf("0") : printf("1");
    }
}
void printArrayWithBinary(unsigned int *arr){
    int i;
    for(i=0;i<10;i++){
        printf("number %d reversed: %u " ,arr[i]);
        binaryString(arr[i]);
        printf("\n");
    }
}
