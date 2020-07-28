package Swordmeansoffer66;

import java.util.Arrays;

public class RectCover {
    public int rectCover(int target) {
        if (target==0)
            return 0;
        if(target==1)
            return 1;

        int res = 1;
        for(int i=1;i<=target/2;i++){
            int a = target-2*i;

//            System.out.println(b);
            res = res+ (a%2==0?(a+1):(a/2+1)*2);

        }
        return res;


    }

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        int res = rectCover.rectCover(4);
        System.out.println(res);
    }
}
