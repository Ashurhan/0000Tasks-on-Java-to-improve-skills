

public class Q2 {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        int target =2;
        int index=binarySearch(arr,target);

        if(index != -1) {
            System.out.println("Number found at index: " + index);
        } else {
            System.out.println("Number not found in the array.");
        }

    }

    public static int binarySearch(int []arr , int target){
        int left = 0;
        int right = arr.length - 1;

        // Binary search works by repeatedly dividing the search interval in half
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid;
            }

            // If target is smaller than mid, ignore the right half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If target is greater than mid, ignore the left half
            else {
                left = mid + 1;
            }
        }
        // Target not found
        return -1;
    }
}
