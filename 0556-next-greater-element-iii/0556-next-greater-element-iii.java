class Solution {
    
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public long numberFromArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }

    public int nextGreaterElement(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        int i = arr.length - 2;

        // Step 1: Find first decreasing digit
        while(i >= 0 && arr[i] >= arr[i + 1]) i--;

        if(i < 0) return -1;

        // Step 2: Find just larger digit to swap with
        int j = arr.length - 1;
        while(arr[j] <= arr[i]) j--;

        // Step 3: Swap and reverse
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Step 4: Reverse the rest
        int left = i + 1, right = arr.length - 1;
        while(left < right){
            char t = arr[left];
            arr[left++] = arr[right];
            arr[right--] = t;
        }

        try {
            int result = Integer.parseInt(new String(arr));
            return result;
        } catch(NumberFormatException e) {
            return -1;
        }
    }
}
