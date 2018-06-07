class Solution {
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int maxLen = 0;
        int startIndex = 0, endIndex = 0;
        // 暴力枚举，以每个元素为中心进行，分回文长度奇、偶两种情况
        // 长度为奇数
        for (int i = 0; i < array.length; i++) {
            int thisLen = 0;
            int start=i, end=i;
            while (start>=0 && end<array.length){
                if (array[start] == array[end]){
                    if (start == end){
                        thisLen++;
                    }else {
                        thisLen += 2;
                    }
                    start--;
                    end++;
                }else {
                    break;
                }
            }
            if (thisLen>maxLen){
                maxLen = thisLen;
                startIndex = ++ start ;
                endIndex = -- end  ;
            }
        }

        // 长度为偶数
        for (int i = 0; i < array.length; i++) {
            int thisLen = 0;
            int start = i, end = i+1;
            while (start>=0 && end<array.length){
                if (array[start] == array[end]){
                    thisLen += 2;
                    start --;
                    end ++;
                }else {
                    break;
                }
            }
            if (thisLen>maxLen){
                maxLen = thisLen;
                startIndex = ++ start ;
                endIndex = -- end ;
            }
        }

    return s.substring(startIndex,endIndex+1);
    }   
    
}