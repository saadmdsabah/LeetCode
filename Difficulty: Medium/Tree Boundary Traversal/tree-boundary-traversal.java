//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
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
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
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
*/

class Solution {
    
    public void leftSide(Node root, ArrayList<Integer> list){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        list.add(root.data);
        if(root.left != null){
            leftSide(root.left, list);
        } else {
            leftSide(root.right, list);
        }
    }
    
    public void rightSide(Node root, ArrayList<Integer> list){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        list.add(root.data);
        if(root.right != null){
            rightSide(root.right, list);
        } else {
            rightSide(root.left, list);
        }
    }
    
    public void leafCollection(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.data);
            return;
        }
        leafCollection(root.left, list);
        leafCollection(root.right, list);
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node.data);
        leftSide(node.left, result);
        leafCollection(node.left, result);
        leafCollection(node.right, result);
        ArrayList<Integer> rightSide = new ArrayList<>();
        rightSide(node.right, rightSide);
        for(int i=rightSide.size() - 1; i>=0; i--){
            result.add(rightSide.get(i));
        }
        return result;
    }
}
