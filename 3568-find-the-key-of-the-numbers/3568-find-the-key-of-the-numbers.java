class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String nums1 = ""+num1;
        String nums2 = ""+num2;
        String nums3 = ""+num3;
        while(nums1.length() != 4){
            nums1 = "0" + nums1;
        }
        while(nums2.length() != 4){
            nums2 = "0" + nums2;
        }
        while(nums3.length() != 4){
            nums3 = "0" + nums3;
        }
        System.out.println(nums1 + " " + nums2 + " " +nums3);
        String result = "";
        for(int i=0; i<4; i++){
            int n1 = nums1.charAt(i) - '0';
            int n2 = nums2.charAt(i) - '0';
            int n3 = nums3.charAt(i) - '0';
            result += Math.min(n1, Math.min(n2, n3));
        }
        return Integer.parseInt(result);
    }
}