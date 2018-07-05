class Solution {
    public boolean isValid(String s) {
        // 边界条件
        if (s.length() == 0)    return true;
        // 注意这个条件
        if (s.length() % 2 != 0)    return false;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}' || s.length()==1 ) return false;
        ArrayList<Character> c = new ArrayList<>();
        char[] s2c = s.toCharArray();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s2c[i] == '(' || s2c[i] == '[' || s2c[i] == '{'){
                c.add(s2c[i]);
                index ++;
            }else {
                // 这里注意一下判断当前存放字符的堆里面是否还有字符
                if (c.size() == 0)    return false;
                char temp = c.remove(--index);
                if (s2c[i] == ')' && temp == '('
                        || s2c[i] == ']' && temp == '['
                        || s2c[i] == '}' && temp == '{')
                    continue;
                else return false;

            }
        }
        if(c.size() != 0)   return false;
        else    return true;
    }
}