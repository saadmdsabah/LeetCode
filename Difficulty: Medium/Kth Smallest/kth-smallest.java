//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
            out.println("~");
        }
        out.flush();
    }
}

// } Driver Code Ends

class Solution {
    
    public static void heapifyArr(ArrayList<Integer> arr, int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largest = index;
        if(left < arr.size() && arr.get(left) < arr.get(largest)){
            largest = left;
        }
        if(right < arr.size() && arr.get(right) < arr.get(largest)){
            largest = right;
        }
        if(largest != index){
            int temp = arr.get(largest);
            int t = arr.get(index);
            arr.set(index, temp);
            arr.set(largest, t);
            heapifyArr(arr, largest);
        }
    }
    
    public static int removeElement(ArrayList<Integer> heap){
        int min = heap.get(0);
        int max = heap.get(heap.size() - 1);
        heap.set(0, max);
        heap.remove(heap.size() - 1);
        heapifyArr(heap, 0);
        return min;
    }
    
    public static int kthSmallest(int[] arr, int k) {
        if(arr.length == 1){
            if(k > 1){
                return -1;
            }else{
                return arr[0];
            }
        }
        ArrayList<Integer> heap = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            heap.add(arr[i]);
        }
        
        for(int i=heap.size()/2; i>=0; i--){
            heapifyArr(heap, i);
        }
        
        int min = 0;
        for(int i=0; i<k; i++){
            min = removeElement(heap);
        }
        return min;
    }
}
