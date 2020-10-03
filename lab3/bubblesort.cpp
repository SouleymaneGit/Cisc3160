#include <iostream>
using namespace std;
void swap(int &a, int &b) {      //swap the content of a and b
   int temp;
   temp = a;
   a = b;
   b = temp;
}
void display(int *tab, int size) {
   for(int i = 0; i<size; i++)
      cout << tab[i] << " ";
      cout << endl;
}
void bubbleSort(int *tab) {
   int size = sizeof(*tab); // get the length of the array tab
   for(int i = 0; i<size; i++) {
      bool isSwap = false;         //flag to detect any swap is there or not
      for(int j = 0; j<size-i-1; j++) {
         if(tab[j] > tab[j+1]) {       //when the current item is bigger than next
            swap(tab[j], tab[j+1]);
            isSwap = true;    //set swap flag
         }
      }
      if(!isSwap) break;       // No swap in this pass, so array is sorted
      
   }
} 
int main() {
   int n;
   cout << "Give the length of the array: ";
   cin >> n;
   int arr[n];     //create an array of n elements
   cout << "Give elements:" << endl;
   for(int i = 0; i<n; i++) {
      cin >> arr[i];
   }
   cout << "the array before Sorting: ";
   display(arr, n);
   bubbleSort(arr);
   cout << "And the array after Sorting it: ";
   display(arr, n);
}