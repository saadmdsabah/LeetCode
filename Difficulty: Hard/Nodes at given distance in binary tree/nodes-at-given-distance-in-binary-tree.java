//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}


// } Driver Code Ends

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;
// }

class Solution {
    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        HashMap<Node, Node> map = new HashMap<>(); // (node, node's parent)
        map.put(root, null);
        int max = 0;

        Node targetNode = root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int range = q.size();
            for(int i=0; i<range; i++){
                Node curr = q.remove();
                if(curr.data == target){
                    targetNode = curr;
                }
                max = Math.max(max, curr.data);
                if(curr.left != null){
                    q.add(curr.left);
                    map.put(curr.left, curr);
                }
                if(curr.right != null){
                    q.add(curr.right);
                    map.put(curr.right, curr);
                }
            }
        }

        boolean[] visited = new boolean[max + 1];
        q.add(targetNode);
        visited[targetNode.data] = true;

        while(!q.isEmpty() && k>0){
            int size = q.size();
            for(int j=0; j<size; j++){
                Node curr = q.remove();
                if(curr.left != null && !visited[curr.left.data]){
                    q.add(curr.left);
                    visited[curr.left.data] = true;
                }
                if(curr.right != null && !visited[curr.right.data]){
                    q.add(curr.right);
                    visited[curr.right.data] = true;
                }
                if(map.get(curr) != null && !visited[map.get(curr).data]){
                    q.add(map.get(curr));
                    visited[map.get(curr).data] = true;
                }
            }
            k--;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.remove().data);
        }
        Collections.sort(list);
        return list;
    }
};


//{ Driver Code Starts.
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
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root, target, k);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends