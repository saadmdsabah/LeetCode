//{ Driver Code Starts
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

    static void deletetree(Node root) {
        if (root == null) return;
        deletetree(root.left);
        deletetree(root.right);
        root.left = null;
        root.right = null;
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

            Tree tr = new Tree();
            ArrayList<Integer> A = tr.serialize(root);
            deletetree(root);
            root = null;

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
class Tree {

    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.add(root.data);
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr.left == null){
                list.add(-1);
            }else{
                q.add(curr.left);
                list.add(curr.left.data);
            }
            if(curr.right == null){
                list.add(-1);
            }else{
                q.add(curr.right);
                list.add(curr.right.data);
            }
        }
        return list;
    }

    public Node deSerialize(ArrayList<Integer> list) {
        if(list.size() == 0){
            return null;
        }
        
        int i = 1;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(list.get(0));
        q.add(root);
        
        while(i < list.size()){
            Node curr = q.remove();
            
            if(list.get(i) == -1){
                curr.left = null;
            }else{
                Node leftNode = new Node(list.get(i));
                curr.left = leftNode;
                q.add(leftNode);
            }
            
            i++;
            if(i >= list.size()) break;
            
            if(list.get(i) == -1){
                curr.right = null;
            }else{
                Node rightNode = new Node(list.get(i));
                curr.right = rightNode;
                q.add(rightNode);
            }
            i++;
        }
        return root;
    }
};