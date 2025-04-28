class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int i = nums1.length - 1; 
        int last = m - 1;         
        int j = n - 1;         
        
        while (last >= 0 && j >= 0) {
            if (nums2[j] >= nums1[last]) {
                nums1[i] = nums2[j];
                j--;
            } else {
                nums1[i] = nums1[last];
                last--;
            }
            i--;
        }
        
        while (j >= 0) {
            nums1[i] = nums2[j];
            i--;
            j--;
        }
    }
}
