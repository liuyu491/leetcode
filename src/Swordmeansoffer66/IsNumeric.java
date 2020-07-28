package Swordmeansoffer66;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumeric {
    public boolean isNumeric(String str) {
        String regexp0 = "[+-]{0,1}\\d+[Ee][+-]{0,1}[1-9]\\d*?";
        String regexp1 = "[+-]{0,1}\\d+";
        String regexp2 = "[+-]{0,1}\\d*?\\.\\d+";
        String regexp3 = "[+-]{0,1}\\d*?\\.\\d+?[Ee][+-]{0,1}[1-9]\\d*?";
        String[] regs = {regexp0,regexp1,regexp2,regexp3};
        boolean res = false;
        for (String reg: regs
             ) {
           if(Pattern.matches(reg,str)){
               return true;
           }

        }

        return  false;

    }

    public static void main(String[] args) {
        IsNumeric isNumeric = new IsNumeric();
        System.out.println(isNumeric.isNumeric("1.79769313486232E+308"));
    }
}
