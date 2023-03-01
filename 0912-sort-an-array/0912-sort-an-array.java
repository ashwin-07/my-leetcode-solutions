class Solution {
         
    public int[] sortArray(int[] nums) {    
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }
    
    void mergeSort(int[] arr, int left, int right, int[] temp) {
        
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    
    void merge(int[] arr, int left, int mid, int right, int[] temp) {
            
        int start1 = left, end1 = mid - left + 1;
        int start2 = mid + 1, end2 = right - mid;
        
        for (int i = 0; i < end1; i++) {
            temp[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < end2; i++) {
            temp[start2 + i] = arr[start2 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < end1 && j < end2) {
            if (temp[start1 + i] <= temp[start2 + j]) {
                arr[k] = temp[start1 + i];
                i += 1;
            } else {
                arr[k] = temp[start2 + j];
                j++;
            }
            k++;
        }

        while (i < end1) {
            arr[k] = temp[start1 + i];
            i++;
            k++;
        }
        while (j < end2) {
            arr[k] = temp[start2 + j];
            j++;
            k++;
        }
    }
}