class Solution {
    public String longestPalindrome(String s) {
        
        char[] array = s.toCharArray();
        int length = array.length;
        int maxLen = 0;
        int startIndex = 0;
        int endIndex = 0;
        boolean[][] isPalindromic = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i==j){
                    isPalindromic[i][j] = true;
                }else {
                    isPalindromic[i][j] = false;
                }
            }
        }
        // DP算法，重点是找转移方程
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j+1){
                    isPalindromic[j][i] = (array[i]==array[j]);
                }else {
                    isPalindromic[j][i] = (array[i]==array[j] && isPalindromic[j+1][i-1]);
                }
                if ((i-j+1 > maxLen) && (isPalindromic[j][i])){
                    maxLen = i-j+1;
                    startIndex = j;
                    endIndex = i;
                }
            }
        }
        return s.substring(startIndex, endIndex+1);
    }   
    
}