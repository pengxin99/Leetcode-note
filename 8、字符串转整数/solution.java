class Solution {
    public int reverse(int x) {
              int result = 0;  
        while(x != 0)  
        {  
            int num = x%10;  
            int res = result*10 + num;  
            if((res-num)/10 != result)  
                return 0;  
            result = res;  
            x = x/10;  
        }  
        return result;  
    }
}