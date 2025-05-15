//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends
class Solution {
    
    static class Pair {
        int largest;
        int smallest;
        int count;
    
        public Pair(int l, int s, int c) {
            this.largest = l;
            this.smallest = s;
            this.count = c;
        }
    }
    
    public static Pair findMax(Node root) {
        if (root == null) {
            // For null nodes: smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
    
        Pair leftPair = findMax(root.left);
        Pair rightPair = findMax(root.right);
    
        // Check if current tree is BST
        if (leftPair.largest < root.data && root.data < rightPair.smallest) {
            int smallest = Math.min(leftPair.smallest, root.data);
            int largest = Math.max(rightPair.largest, root.data);
            int count = leftPair.count + rightPair.count + 1;
            return new Pair(largest, smallest, count);
        } else {
            // Return values that will never satisfy BST condition in parent
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(leftPair.count, rightPair.count));
        }
    }
    
    static int largestBst(Node root) {
        Pair result = findMax(root);
        return result.count;
    }

}