class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>(); // (node, node's parent)
        map.put(root, null);
        int max = 0;

        TreeNode targetNode = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int range = q.size();
            for(int i=0; i<range; i++){
                TreeNode curr = q.remove();
                max = Math.max(max, curr.val);
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
        q.add(target);
        visited[target.val] = true;

        while(!q.isEmpty() && k>0){
            int size = q.size();
            for(int j=0; j<size; j++){
                TreeNode curr = q.remove();
                if(curr.left != null && !visited[curr.left.val]){
                    q.add(curr.left);
                    visited[curr.left.val] = true;
                }
                if(curr.right != null && !visited[curr.right.val]){
                    q.add(curr.right);
                    visited[curr.right.val] = true;
                }
                if(map.get(curr) != null && !visited[map.get(curr).val]){
                    q.add(map.get(curr));
                    visited[map.get(curr).val] = true;
                }
            }
            k--;
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.remove().val);
        }
        return list;
    }
}