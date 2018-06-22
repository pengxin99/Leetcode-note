class Solution {
    public String intToRoman(int num) {
        int M = num / 1000;
        num = num % 1000;
        int C = num / 100;
        num = num % 100;
        int X = num / 10;
        int I = num % 10;

        return iTR(M,"M","&","@") + iTR(C, "C","D","M") +
                iTR(X , "X","L","C") + iTR(I, "I","V", "X");

    }
    public String iTR(int num, String one, String five, String ten){
        if (num == 0)   return "";
        else if (num == 5)  return five;
        else if (num == 4)  return one + five;
        else if (num == 9)  return one + ten;
        else if (num < 5) {
            String ret = "";
            while(num != 0){
                ret += one;
                num -- ;
            }
            return ret;
        }else {
            String ret = "";
            while(num != 5){
                ret += one;
                num --;
            }
            return five + ret;
        }
    }
}