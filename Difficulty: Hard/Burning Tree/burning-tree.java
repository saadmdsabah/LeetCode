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

class Solution {
    
    static class Pair{
        Node node;
        int t;
        public Pair(Node node, int t){
            this.node = node;
            this.t = t;
        }
    }
    
    public static int minTime(Node root, int target) {
        HashMap<Node, Node> map = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        Node source = null;
        int max = 0;
        while(!q.isEmpty()){
            Node currNode = q.remove();
            max = Math.max(max, currNode.data);
            
            if(currNode.data == target){
                source = currNode;
            }
            if(currNode.left != null){
                map.put(currNode.left, currNode);
                q.add(currNode.left);
            }
            if(currNode.right != null){
                map.put(currNode.right, currNode);
                q.add(currNode.right);
            }
        }
        
        boolean[] visited = new boolean[max + 1];
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, 0));
        visited[target] = true;
        
        int result = 0;
        while(!queue.isEmpty()){
            Pair currPair = queue.remove();
            Node currNode = currPair.node;
            int time = currPair.t;
            result = Math.max(result, time);
            
            if(map.containsKey(currNode) && !visited[map.get(currNode).data]){
                queue.add(new Pair(map.get(currNode), time + 1));
                visited[map.get(currNode).data] = true;
            }
            if(currNode.left != null && !visited[currNode.left.data]){
                queue.add(new Pair(currNode.left, time + 1));
                visited[currNode.left.data] = true;
            }
            if(currNode.right != null && !visited[currNode.right.data]){
                queue.add(new Pair(currNode.right, time + 1));
                visited[currNode.right.data] = true;
            }
        }
        
        return result;
        
        
        
        
        
    }
}