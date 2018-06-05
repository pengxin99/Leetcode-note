## Solution
   该方法时间复杂度为O(n2)，但是采用里HaspMap来记录目前取出来的字符，有无重复需要用hashmap中的元素进行比较。应该是在hashmap的containskey()和get()上面浪费了时间。
## betterSolution
   时间复杂度为O(n2)，巧妙利用字符数组避开了查找相同字符时使用的HashMap。
