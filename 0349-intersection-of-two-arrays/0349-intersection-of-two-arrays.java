class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int max = 0;
        for(int i=0; i<nums1.length; i++){
            max = Math.max(max, nums1[i]);
        }
        BitSet s1 = new BitSet(max + 1);
        for(int i=0; i<nums1.length; i++){
            s1.set(nums1[i]);
        }
        max = 0;
        for(int i=0; i<nums2.length; i++){
            max = Math.max(max, nums2[i]);
        }
        BitSet s2 = new BitSet(max + 1);
        for(int i=0; i<nums2.length; i++){
            s2.set(nums2[i]);
        }
        s1.and(s2);
        int[] result = s1.stream().toArray();
        return result;
    }
}