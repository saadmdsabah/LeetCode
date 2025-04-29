//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        for(int i : arr){
            if(i < 0){
                negative.add(i);
            }else{
                positive.add(i);
            }
        }
        
        int i = 0;
        int even = 0;
        int odd = 0;
        while(i < arr.size() && even < positive.size() && odd < negative.size()){
            if(i%2 == 0){
                arr.set(i, positive.get(even));
                even++;
            }else{
                arr.set(i, negative.get(odd));
                odd++;
            }
            i++;
        }
        while(i < arr.size() && even < positive.size()){
            arr.set(i, positive.get(even));
            i++;
            even++;
        }
        
        while(i < arr.size() && odd < negative.size()){
            arr.set(i, negative.get(odd));
            i++;
            odd++;
        }
    }
}