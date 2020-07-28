package Swordmeansoffer66;

public class LastRemainingSolution {
    boolean[] marked = null;

    public int LastRemaining_Solution(int n, int m) {
        marked = new boolean[n];
        int count = 0;
        int index = 0;
        int m_index = 0;

        while(count<n-1){
            m_index++;
            index = getNextIndex(marked,index);
            if(m_index==m-1){
                m_index = 0;
                count++;
                marked[index] = true;
                index = getNextIndex(marked,index);
            }



        }
        return index;
    }
    private int getNextIndex(boolean[] marked,int curIndex){
        int nextIndex  = curIndex+1;
        if(nextIndex==marked.length){
            nextIndex = 0;
        }

        while(marked[nextIndex]){
            nextIndex++;
            if(nextIndex==marked.length)
                nextIndex = 0;
        }
        return nextIndex;

    }

    public static void main(String[] args) {
        LastRemainingSolution lastRemainingSolution = new LastRemainingSolution();
        System.out.println(lastRemainingSolution.LastRemaining_Solution(5, 3));
    }
}
