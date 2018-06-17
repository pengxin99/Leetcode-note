# 典型的动态规划
重点在边界条件和最优子结构。
子结构如下：
```java

 if (cp[j] == '.' || cs[i] == cp[j])    result[i+1][j+1] = result[i][j];
 else if (cp[j] == '*'){
        if (cp[j-1] != cs[i] && cp[j-1]!='.')   result[i+1][j+1] = result[i+1][j-1];
        else result[i+1][j+1] = (result[i+1][j] || result[i][j+1] || result[i+1][j-1]);
        }
```