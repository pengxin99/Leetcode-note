class Solution {
    public int lengthOfLongestSubstring(String s) {
        int sum = 0;
        int temp_sum = 0;
        char[] array = s.toCharArray();
        HashMap<Character,Integer> temp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!temp.containsKey(array[i])){
                temp.put(array[i], i);
                temp_sum ++;
            }else {
                if (temp_sum>sum){
                    sum = temp_sum;
                }
				int index = temp.get(array[i]);
                temp_sum=0;
                temp.clear();
                i = index  ;    // 指向重复字符的前面一个，循环 i++ 后指向重复字符后一个
            }
        }
    return (temp_sum>sum)?temp_sum:sum;     // 防止最长字串一直到字符串s结尾，循环结束时，sum值没得到更新
    }
}