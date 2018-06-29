class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        String [] numtostring = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        // 采用递归思想
        if(digits.isEmpty()){
            return ret;
        }else if(digits.length() == 1){
            char[] temp = numtostring[digits.charAt(0) - '0'].toCharArray();
            for(char c : temp){
                ret.add(c+"");
            }
            return ret;
        }else{
            // 
            int len = digits.length();
            String sub = digits.substring(0, len-1);
            List<String> ret_temp = new ArrayList<String>();
            List<String> ret_sub = new ArrayList<String>();
            ret_sub = letterCombinations(sub);
            char[] temp = numtostring[digits.charAt(len-1) - '0'].toCharArray();
            for(char c:temp){
                for(String s : ret_sub){
                    ret_temp.add(s+c+"");
                }
            }
            return ret_temp;
        }
    }
       
}