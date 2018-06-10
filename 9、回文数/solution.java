class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 ) return false;
        else if( x < 10) return true;
        String s = String.valueOf(x);
        char[] cArray = s.toCharArray();
        
        for(int i = 0,j = cArray.length-1; i<=j; i++,j--){
            if(cArray[i] != cArray[j]) return false;
            else  continue;
        }
        return true;
    }
}