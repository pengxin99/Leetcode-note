class Solution {
    public boolean isMatch(String s, String p) {
        char [] cs = s.toCharArray();
        char [] cp = p.toCharArray();
        boolean [][] result = new boolean[s.length()+1][p.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                result[i][j] = false;
            }
        }
        // 考虑边界条件
        result [0][0] = true;                       // the index represent the length of the string and pattern
        for (int i = 1; i <= s.length(); i++) {      // string is not empty, but the pattern is empty
            result[i][0] = false;
        }

        for (int j = 1; j < p.length(); j++) {      // string is empty，but the pattern is match use '*'
            if (cp[j]=='*' && result[0][j-1]) {
                result[0][j+1] = true;
            }
        }
        // dp
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cp.length; j++) {
                if (cp[j] == '.' || cs[i] == cp[j]){
                    result[i+1][j+1] = result[i][j];
                }else if (cp[j] == '*'){
                    if (cp[j-1] != cs[i] && cp[j-1]!='.')   result[i+1][j+1] = result[i+1][j-1];
                    else result[i+1][j+1] = (result[i+1][j] || result[i][j+1] || result[i+1][j-1]);
                }
            }
        }
        return result[s.length()][p.length()];
    }
}