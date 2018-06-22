class Solution {
    public int romanToInt(String s) {
        int num = strs.length;
        if(num == 0)    return "";                      // 边界条件
        // int[] memberLength = new int[num];
        int minLength = Integer.MAX_VALUE;
        String ret = "";
        // 统计所有字符串里面长度最短的
        for(int i = 0; i<num; i++){
            // memberLength[i] = strs[i].length();
            if(strs[i].length() == 0)   return ret;         // 边界条件，如果有一个字符串为空，则返回空
            minLength = ( minLength < strs[i].length() )? minLength : strs[i].length() ;
        }
        // 以最短长度为上界，进行循环，依次核对每个字符串里面对应位置是否含有相同字符
        for(int i = 0; i<minLength; i++){
            char thisChar = strs[0].charAt(i);
            for(int j = 0; j < num; j++){
                if(strs[j].charAt(i) != thisChar){
                    return ret;
                }
            }
            ret += thisChar;
        }
        return ret;
    }
}