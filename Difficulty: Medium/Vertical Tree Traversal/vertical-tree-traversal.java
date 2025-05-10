//{ Driver Code Starts
// Initial Template for Java

// Contributed by Sudarshan Sharma
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

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.verticalOrder(root);
            System.out.print("[ ");
            for (ArrayList<Integer> vec : res) {
                System.out.print("[ ");
                for (int val : vec) {
                    System.out.print(val + " ");
                }
                System.out.print("] ");
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

/*
class Node {
    int data;
    Node left, right;
    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    public static void dfs(TreeMap<Integer, ArrayList<Integer>> map, Node root, int v){
        if(root == null){
            return;
        }
        if(!map.containsKey(v)){
            map.put(v, new ArrayList<Integer>());
        }
        map.get(v).add(root.data);
        dfs(map, root.left, v-1);
        dfs(map, root.right, v+1);
    }
    
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(map, root, 0);
        for(ArrayList<Integer> curr : map.values()){
            result.add(new ArrayList<>(curr));
        }
        return result;
    }
}
