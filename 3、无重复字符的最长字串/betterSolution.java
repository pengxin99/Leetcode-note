class Solution {
    public int lengthOfLongestSubstring(String s) {
        int index = 0;
        int max = 0;
        char[] array = s.toCharArray();
        for(int i = 0; i<array.length; i++){
            for(int j=index; j<i; j++){         // 每次都在找当前i之前的元素中，字串最长的字串长度：即从index到i的字串，复杂度 O(n2)
                if(array[j] == array[i]){
                    index = j+1;
                }
            }
            max = Math.max(max, i-index+1);
        }
        return max;
    }
}