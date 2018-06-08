class Solution {
    public String convert(String s, int numRows) {
        // 如果只有一行的话，直接返回输入的字符串
        if (numRows == 1){
            return s;
        }
        char[] array = s.toCharArray();                     // 定义输入字符数组
        char[][] zArray = new char[numRows][array.length];  // 转换为z型数组
        String res = "";        // 结果
        int count = 0;          // 程序一次遍历输入字符串，每2*（numRows-1）为一组
        int loop = 0;           // 当前处于第几组
        int col = 0;            // 当前组的当前列
        int row = 0;            // 当前组的当前行
        // 初始化zArray，初始结果可用于最后筛选zArray数组所存的字符
        for (int i = 0; i < zArray.length; i++) {
            for (int j = 0; j < zArray[0].length; j++) {
                zArray[i][j] = '*';
            }
        }
        
        for (int i = 0; i < array.length; i++) {        // 一次遍历字符串
            if(count < numRows){                        // 每一组 输入处于Z型垂直那一列列的字符，共 numRows 个字符
                count ++ ;
                zArray[row ++][col] = array[i];
            }else if (count < 2 * numRows - 2){         // 每一组 输入处于Z型斜的一列字符，共 numRows-2 个字符
                if (row == numRows){
                    row -- ;
                }
                count ++;
                zArray[ -- row][ ++ col] = array[i];
            }else {                                     // 一组输入完成，进行下一组输入的参数初始化
                loop ++;
                col = loop * (numRows-1) ;
                row = 0;
                count = 0;
                i--;
            }
        }

        int index = 0;
        for (int i = 0; i < zArray.length; i++) {
            for (int j = 0; j < zArray[0].length; j++) {
                if (zArray[i][j] != '*'){
                    res += zArray[i][j];
                }
            }
        }
        
        return res;
    }
    
}