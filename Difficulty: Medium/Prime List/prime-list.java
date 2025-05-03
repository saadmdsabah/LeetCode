//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    
    public int primeNumbers(int n, int curr){
        if(curr == 0 || curr == 1){
            return 2;
        }
        boolean[] visited = new boolean[n+1];
        for(int i=2; i*i<=n; i++){
            if(!visited[i]){
                for(int j=i*i; j<=n; j+=i){
                    visited[j] = true;
                }
            }
        }
        int nextP = -1;
        int prevP = -1;
        for(int i=curr; i<=n; i++){
            if(!visited[i]){
                nextP = i;
                break;
            }
        }
        for(int i=curr; i>=2; i--){
            if(!visited[i]){
                prevP = i;
                break;
            }
        }
        
        if(Math.abs(curr - nextP) == Math.abs(curr-prevP)){
            return prevP;
        }else{
            if(Math.abs(curr - nextP) < Math.abs(curr-prevP)){
                return nextP;
            }else{
                return prevP;
            }
        }
    }
    
    Node primeList(Node head) {
        Node temp = head;
        while(head != null){
            int p = primeNumbers(head.val + 100, head.val);
            head.val = p;
            head = head.next;
        }
        return temp;
    }
}