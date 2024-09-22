class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            list.add(String.valueOf(i));
        }
        Collections.sort(list);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            result.add(Integer.parseInt(list.get(i)));
        }
        return result;
    }
}