//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(arr[mid] == target){
                return mid;
            }else if(mid - 1 >= 0 && arr[mid] < arr[mid - 1]){
                if(arr[mid - 1] == target){
                    return mid - 1;
                }else if(arr[mid - 1] < target){
                    low = mid + 1;
                }else{
                    high = mid - 2;
                }
            }else if(mid + 1 < arr.length && arr[mid] > arr[mid + 1]){
                if(arr[mid + 1] == target){
                    return mid + 1;
                }else if(arr[mid] < target){
                    low = mid + 2;
                }else{
                    high = mid - 1;
                }
            }else{
                if(arr[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}


//{ Driver Code Starts.

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            int target = sc.nextInt();
            if (sc.hasNextLine()) sc.nextLine();
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            int ans = sln.findTarget(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends