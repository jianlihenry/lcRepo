class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 <= N2) return helper(nums1, nums2);
        else return helper(nums2, nums1);
    }
    
    public double helper(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int lo = 0, hi = N1*2;
        while (lo <= hi) {
            int C1 = (lo + hi) / 2;
            int C2 = N1 + N2 - C1;
            int L1 = (C1 - 1) / 2, R1 = C1 / 2;
            int L2 = (C2 - 1) / 2, R2 = C2 / 2;
            int nL1 = (C1==0?Integer.MIN_VALUE:nums1[L1]);
            int nL2 = (C2==0?Integer.MIN_VALUE:nums2[L2]);
            int nR1 = (C1==N1*2?Integer.MAX_VALUE:nums1[R1]);
            int nR2 = (C2==N2*2?Integer.MAX_VALUE:nums2[R2]);
            if (nL1 > nR2) {
                hi = C1 - 1;
            } else if (nL2 > nR1) {
                lo = C1 + 1;
            } else {
                return (double) (Math.max(nL1, nL2) + Math.min(nR1, nR2)) / 2;
            }
        }
        return 0;
    }
}
