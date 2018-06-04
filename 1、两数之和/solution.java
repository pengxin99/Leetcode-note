class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        Map<Integer, Integer> SumMap= new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(SumMap.containsKey(target - nums[i])){
                temp[0] = SumMap.get(target-nums[i]);
                temp[1] = i;
                break;
            }
            SumMap.put(nums[i], i);
        }
        return temp;
    }
}