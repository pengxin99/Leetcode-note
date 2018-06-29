class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        /// ********* 注意下面两句，多加了两句，如果target小于最小值，或者大于最大值，都不可以作为结束的依据！！！！
        // if(nums[0] >= target)   return nums[0]+nums[1]+nums[2]; 
        // else if(nums[len-1] <= target) return nums[len-1]+nums[len-2]+nums[len-3];   
            for(int i = 0; i < len; i++){         
                int begin = i+1;
                int end = len-1;    
                while(begin < end){
                    int sum = nums[i]+nums[begin]+nums[end];
                    int temp = target - sum;
                    diff = Math.abs(temp) < Math.abs(diff) ? temp : diff;           // 这里要加abs，判断绝对值
                    if(temp == 0)   return target;
                    else if(sum > target)  end --;
                    else begin ++;
            }
        }
        return target - diff;
    }
}