//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            List<Integer> crr = new ArrayList<>();

            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }

            String input2 = sc.nextLine();
            Scanner ss2 = new Scanner(input2);
            while (ss2.hasNextInt()) {
                brr.add(ss2.nextInt());
            }

            String input3 = sc.nextLine();
            Scanner ss3 = new Scanner(input3);
            while (ss3.hasNextInt()) {
                crr.add(ss3.nextInt());
            }

            Solution ob = new Solution();
            List<Integer> res = ob.commonElements(arr, brr, crr);

            if (res.size() == 0) System.out.print(-1);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

// class Solution {
    
//     public boolean binarySearch(List<Integer> result, int target){
//         int low = 0;
//         int high = result.size() - 1;
//         while(low <= high){
//             int mid = (high - low)/2 + low;
//             if(result.get(mid) == target){
//                 return true;
//             }else if(result.get(mid) > target){
//                 high = mid - 1;
//             }else{
//                 low = mid + 1;
//             }
//         }
//         return false;
//     }
    
//     // Function to find common elements in three arrays.
//     public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
//         int i = 0;
//         int j = 0;
//         int k = 0;
//         List<Integer> result = new ArrayList<>();
        
//         while(i < arr1.size() && j < arr2.size() && k < arr3.size()){
//             if(arr1.get(i) == arr2.get(j) && arr2.get(j) == arr3.get(k)){
//                 if(!binarySearch(result, arr1.get(i))){
//                     result.add(arr1.get(i));
//                 }
//             }
//             int min = Math.min(arr1.get(i), Math.min(arr2.get(j), arr3.get(k)));
//             if(arr1.get(i) == min){
//                 i++;
//             }else if(arr2.get(j) == min){
//                 j++;
//             }else{
//                 k++;
//             }
//         }
//         if(result.size() == 0){
//             result.add(-1);
//         }
//         return result;
//     }
// }

class Solution {
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            int a = arr1.get(i), b = arr2.get(j), c = arr3.get(k);
            
            // If all elements are equal, add to result
            if (a == b && b == c) {
                result.add(a);

                // Skip duplicates in all arrays
                while (i < arr1.size() && arr1.get(i) == a) i++;
                while (j < arr2.size() && arr2.get(j) == b) j++;
                while (k < arr3.size() && arr3.get(k) == c) k++;
            } else {
                // Move the pointer which has the smallest value
                int min = Math.min(a, Math.min(b, c));
                if (a == min) i++;
                if (b == min) j++;
                if (c == min) k++;
            }
        }

        if (result.isEmpty()) result.add(-1);
        return result;
    }
}
