package Swordmeansoffer66;

public class Match {
    public boolean match(char[] str, char[] pattern)
    {
        if(str.length==0&&pattern.length==0){
            return true;
        }

        if(pattern.length==0){
            return false;
        }
        return match(str,pattern,0,0);
    }


    /*使用递归
    函数的语义：判断str[0]到str[i]与pattern[0]到pattern[j]的字符串和模式串是否匹配
    递归关系：f(i,j) = f(i-1,j-1)&str[i]==pattern[j]或者pattern[j]=='.';

    对于匹配串中'*'的处理：


pattern下一个字符为‘*’或
    不为‘*’：
          1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
            匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
            “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
            当前字符为‘.’,同时str的当前字符不为‘\0’。
          2>pattern下一个字符为‘*’时，稍微复杂一些，因为‘*’可以代表0个或多个。
            这里把这些情况都考虑到：
               a>当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，
                跳过这个‘*’符号；
               b>当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符
                不变。（这里匹配1个或多个可以看成一种情况，因为：当匹配一个时，
                由于str移到了下一个字符，而pattern字符不变，就回到了上边的情况a；
                当匹配多于一个字符时，相当于从str的下一个字符继续开始匹配）
                （链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c?answerType=1&f=discussion
来源：牛客网）
    */
    private  boolean match(char[] str, char[] pattern,int i, int j){
        //递归终止条件
        if(i==str.length&&j==pattern.length){
            return true;
        }else if(j==pattern.length){
            return false;
        }
        //pattern[j+1]不是*
        if(j==pattern.length-1||(j+1<pattern.length&&pattern[j+1]!='*')){
            if(str[i]==pattern[j]||pattern[j]=='.'){
                return match(str,pattern,i+1,j+1);
            }else{
                return false;
            }
        }else if(j+1<pattern.length&&pattern[j+1]=='*'){
            //str[i]与pattern[j]不相等
            if(str.length==0||str[i]!=pattern[j]){
                return match(str,pattern,i,j+2);
            }else{
                return match(str,pattern,i+1,j);
            }

        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] str = {'a','a','a'};
        char[] pattern = {'a','b','*','a','c','*','a'};
        System.out.println(match.match(str, pattern));
    }
}
