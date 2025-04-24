class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int unique = set.size();
        set.clear();
        
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int j=0; j<nums.length; j++){
            if(map.containsKey(nums[j])){
                map.put(nums[j], map.get(nums[j]) + 1);
            }else{
                map.put(nums[j], 1);
            }
            HashMap<Integer, Integer> temp = new HashMap<>(map);
            for(int i=0; i<=j; i++){
                if(temp.size() == unique){
                    count += 1;
                }
                if(temp.get(nums[i]) - 1 == 0){
                    temp.remove(nums[i]);
                }else{
                    temp.put(nums[i], temp.get(nums[i]) - 1);
                }
            }
        }
        return count;
    }
}