class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> R2I = new HashMap<Character, Integer>() ;
        R2I.put('I', 1);
        R2I.put('V', 5);
        R2I.put('X', 10);
        R2I.put('L', 50);
        R2I.put('C', 100);
        R2I.put('D', 500);
        R2I.put('M', 1000);
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1) {
                
                int before = R2I.get(s.charAt(i));
                int after = R2I.get(s.charAt(i + 1));
                
                if (before < after) {
                    ret += (after - before);
                    i++;
                } else {
                    ret += before;
                }
            }else {
                ret += R2I.get(s.charAt(i));
            }
        }
        return ret;
    }
}