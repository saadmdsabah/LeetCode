//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            int target = Integer.parseInt(br.readLine());
            Node root = buildTree(s);

            Solution g = new Solution();
            System.out.println(g.minTime(root, target));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minTime(Node root, int target) {
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

        int count = 0;
        while(!q.isEmpty()){
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
            count++;
        }
        return count - 1;
    }
}