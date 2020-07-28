package Swordmeansoffer66;

public class Power {
    /*
   快速幂法，求幂
   原理：
   x^n = x^(n/2)*x(n/2)

   注意n为负数和n为奇数的情况
   */
    public static double power(double base, int exponent) {
        if(base==0)
            return 0;

        if(exponent<0){
            base = 1/base;
        }

        return powerHelper(base,exponent);

    }
    private static double powerHelper(double base, int exponent){
        if(exponent==0){
            return 1;
        }

        if(exponent==1){
            return base;
        }

        //如果exponent是奇数
        if((exponent&1)==1){
            base = base*powerHelper(base,(exponent-1)/2)*powerHelper(base,(exponent-1)/2);
        }else{
            base = powerHelper(base,(exponent)/2)*powerHelper(base,(exponent)/2);
        }
        return base;
    }

    public static void main(String[] args) {
        System.out.println(power(2, -6));
    }
}
