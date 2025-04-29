//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
      public static int merge(int[] arr, int low, int mid, int high) {
    ArrayList<Integer> list = new ArrayList<>();
    int i = low;
    int j = mid + 1;
    int result = 0;

    while (i <= mid && j <= high) {
      if (arr[i] > arr[j]) {
        result += mid - i + 1;
        list.add(arr[j]);
        j++;
      } else {
        list.add(arr[i]);
        i++;
      }
    }

    while (i <= mid) {
      list.add(arr[i]);
      i++;
    }

    while (j <= high) {
      list.add(arr[j]);
      j++;
    }

    for (int k = low; k <= high; k++) {
      arr[k] = list.get(k - low);
    }
    return result;
  }

      public static int divide(int[] arr, int low, int high) {
        int result = 0;
        if (low < high) {
          int mid = (high - low) / 2 + low;
          result += divide(arr, low, mid);
          result += divide(arr, mid + 1, high);
          result += merge(arr, low, mid, high);
        }
        return result;
      }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int result = divide(arr, 0, arr.length - 1);
        return result;
        
    }
}