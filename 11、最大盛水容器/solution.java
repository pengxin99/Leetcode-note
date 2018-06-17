class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left != right){
            if (height[left] < height[right]){
                int temp = height[left] * (right-left);
                max = temp > max ? temp : max;
                left ++;
            }else {
                int temp = height[right] * (right-left);
                max = temp > max ? temp : max;
                right --;
            }
        }
        return max;
    }
}