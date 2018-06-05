class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sizeA = nums1.length, sizeB = nums2.length;
        if (sizeA <= 0 && sizeB <= 0) {
            return 0;
        }

        int total = sizeA + sizeB;
        // 两个有序数组总数是奇数
        if (total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        }
        // 两个有序数组总数是偶数
        else {
            return (findKth(nums1, 0, nums2, 0, total / 2) + findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
        }
    }

    /**
     * 找到两个有序数组的第k个
     * @param nums1 第一个有序组
     * @param i 从第i个元素开始
     * @param nums2 第二个有序组
     * @param j 从第j个元素开始
     * @param k
     * @return
     */
    public double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 首先需要让数组1的长度小于或等于数组2的长度
        if (nums1.length - i > nums2.length - j) {
            return findKth(nums2, j, nums1, i, k);
        }
        // 判断小的数组是否为空，为空的话，直接在另一个数组找第K个即可; 这里使用 i、j ，而不是0
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }
        // 两个都不为空的情况。
        // 当K = 1时，表示我们要找第一个元素，只要比较两个数组的第一个元素，返回较小的那个即可
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        // pa、pb 记录的是当前需要比较多两个元素位置
        // 刚开始找的是两个有序组 各自的第 k/2 个元素
        int pa = Math.min(i + k / 2, nums1.length);
        int pb = j + k - pa + i;

        // 如果nums1的当前元素小，则从pa，j位置开始，找到两有序组的第（k-（pa-i））个元素
        if (nums1[pa - 1] < nums2[pb - 1]) {
            return findKth(nums1, pa, nums2, j, k - (pa - i));
        }
        // 如果nums2的点给钱元素小，则从i，pb位置开始，找到两有序组的第（k-（pb-j））个元素
        else if (nums1[pa - 1] > nums2[pb - 1]) {
            return findKth(nums1, i, nums2, pb, k - (pb - j));
        }
        // 如果相等，则返回其中之一即可
        else {
            return nums1[pa - 1];
        }
    }
}