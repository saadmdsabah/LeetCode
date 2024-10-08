/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public void post(Node root, List<Integer> list){
        if(root.children.size() == 0){
            list.add(root.val);
            return;
        }
        for(int i=0; i<root.children.size(); i++){
            post(root.children.get(i), list);
        }
        list.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }
        post(root, list);
        System.out.println(list);
        return list;
    }
}