class Solution {
    public void solution(int index, int target, int[] arr, List<Integer> list,List<List<Integer>> ans,int n,int sum){
        if(index == n+1){
            if(sum == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(sum<=target){
            list.add(arr[index]);
            solution(index,target,arr,list,ans,n,sum + arr[index]);
            list.remove(list.size() - 1);
        }
        solution(index+1,target,arr,list,ans,n,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solution(0,target,candidates,list,ans,candidates.length-1,0);
        return ans;
    }
}