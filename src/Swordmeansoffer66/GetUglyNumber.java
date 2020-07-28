package Swordmeansoffer66;

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int ind = 1;
        int num = 1;
        boolean flag1 = false;
        boolean flag2 = true;
        while(ind<index){
            num++;
            flag1 = false;
            flag2 = true;
            if(isprimeNumber(num)){
                if(num<=5){
                    if(num==2||num==3||num==5){
                        ind++;
                        continue;
                    }
                }else{
                    continue;
                }
            }
            for(int i = 2;i<=num/2;i++){
                if(num%i==0&&isprimeNumber(i)){
                    if(i<=5){
                        if(i==2||i==3||i==5){
                            flag1 = true;
                        }
                    }else{
                        flag2 = false;
                        break;
                    }

                }
            }
            if(flag1&&flag2){
                ind++;
            }
        }
        return num;
    }


    private boolean isprimeNumber(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GetUglyNumber getUglyNumber = new GetUglyNumber();
        System.out.println(getUglyNumber.GetUglyNumber_Solution(300));
    }
}
