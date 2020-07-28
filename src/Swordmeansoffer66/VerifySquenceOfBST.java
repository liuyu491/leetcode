package Swordmeansoffer66;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return isSquenceOfBST(sequence,0,sequence.length-1);
    }
    private boolean isSquenceOfBST(int[] sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int root = sequence[end];
        int index = start-1;

        for(int i=start;i<end;i++){
            if(root>=sequence[i]){
                index++;
            }
            if(root>sequence[i]&&i>index){
                return false;
            }
        }
        return isSquenceOfBST(sequence,start,index)&&isSquenceOfBST(sequence,index+1,end-1);
    }

    public static void main(String[] args) {
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        System.out.println(verifySquenceOfBST.VerifySquenceOfBST(new int[]{3, 8, 7, 10, 12, 11, 9}));
    }
}
