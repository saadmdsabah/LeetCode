class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s);
        }
        if(sb.toString().charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}