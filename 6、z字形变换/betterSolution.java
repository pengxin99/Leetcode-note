class Solution {
    public String convert(String s, int numRows) {
	   	if (numRows == 1 || s.length() == 1 || numRows > s.length()) return s;
	    
        char[] cs = s.toCharArray();
        char[] res = new char[cs.length];
        int cycle = (numRows - 1) <<1;
        int index = 0;
        
        for(int i = 0; i < numRows; i++){
            int j = i;
            while(j < cs.length){
                if(i == 0 || i == numRows - 1){
                    res[index++] = cs[j];
                    j += cycle;
                } else {
                    res[index++] = cs[j];
                    
                    int k = j + ((numRows - i - 1) << 1);
                    if(k < cs.length)
                        res[index++] = cs[k];
                    
                    j += cycle;
                }
            }
        }
        return String.valueOf(res);
	}
}