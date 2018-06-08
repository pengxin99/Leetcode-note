## Solution
按照题意做出z型变换之后的二维数组，再转回字符串输出，时间复杂度O(n2)，空间复杂度O(n2).
注意：1、边界情况，即输入为空、输入字符串长度为1、numRows大于输入字符串长度。
      2、字符数组输出时 'System.out.print(char+'\t');' 会转为字符对应的ASCII码输出，应使用'System.out.print(""+char+'\t')'
## betterSolution
根据输入输出字符串对应规则，算出字符串对应位置，遍历一遍输入字符串即可。时间复杂度O(n)，空间复杂度O(n).