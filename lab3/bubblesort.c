#include <stdio.h> 
#include <stdbool.h>

// te swap function
void swap(int *xp, int *yp) 
{ 
    int temp = *xp; 
    *xp = *yp; 
    *yp = temp; 
} 
  
// A function to implement bubble sort 
void bubbleSort(int arr[], int n) 
{ 
   int i, j; 
   for (i = 0; i < n-1; i++) {      
      bool isSwap = false; 
       // Last i elements are already in place    
       for (j = 0; j < n-i-1; j++) { 
           if (arr[j] > arr[j+1]) {
              swap(&arr[j], &arr[j+1]);
              isSwap = true;    //set swap flag
           }
       } 
       if(!isSwap) break;       // No swap in this pass, so array is sorted
   }
} 
  
/* Function to print the array */
void display(int arr[], int size) 
{ 
    int i; 
    for (i=0; i < size; i++) 
        printf("%d ", arr[i]);  
} 
  
 
int main() 
{ 
    printf("Give the length of the array:");
    int n;
    scanf("%d", &n);
    int arr[n];
    printf("Give elements:");
    
    for(int i = 0; i<n; i++) {
      scanf("%d", &arr[i]);
    }

   printf("the array before Sorting:");
   display(arr,n);
   bubbleSort(arr, n);
   printf("\n");
   printf("the array After Sorting:");
   display(arr,n); 
    return 0; 
}