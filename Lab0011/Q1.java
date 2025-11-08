
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of elements");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter the numbers");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        mergeSort(arr); // Call the recursive merge sort function


        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

    }


    // Recursive Merge Sort function
    public static void mergeSort(int arr[]){
        int len = arr.length;

        // Base case: a single element is already sorted
        if(len==1){
            return;
        }
        int mid=len/2;
        int[] l=new int[mid];  // Left half of the array
        int[] r =new int[len-mid];  // Right half of the array


        // Copy elements into left subarray
        for(int i=0;i<l.length;i++){
            l[i]=arr[i];
        }

        // Copy elements into right subarray
        for(int j=mid;j<r.length;j++){
            r[j-mid]=arr[j];
        }

        // Recursively sort left and right subarrays
        mergeSort(l);
        mergeSort(r);


        // Merge the sorted subarrays back into the original array
        merge(arr,l,r);

    }

    // Merge two sorted subarrays into the original array
    public static void merge(int[] arr, int []l, int[]r){
        int left=l.length;
        int right=r.length;
        int i=0;    // the index which responsible for arr left
        int j=0; // the inddex which responsible for arr right
        int ind=0;      // the index which responsible original arr


        // Compare elements from both subarrays and copy the smaller one
        while(i<left && j<right ){
            if(l[i] > r[j]){
                arr[ind]=r[j];
                ind++;
                j++;
            }else{
                arr[ind]=l[i];
                ind++;
                i++;
            }
        }

        // Copy any remaining elements from the left subarray
        for(int ii=0;ii<left;ii++) {
            arr[ind++]=l[ii];
            // Copy any remaining elements from the right subarray
        }for(int jj=0;jj<right;jj++){
            arr[ind++]=r[jj];
        }
    }
}
