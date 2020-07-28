package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RestoreIPAddresses_93 {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        findCombination(s,0,0,new StringBuilder());
        return res;
    }

    private void findCombination(String s, int index, int index_all, StringBuilder sb){
        if(index>=s.length()){
            return;
        }
        if(index_all==3){
            String sub = s.substring(index,s.length());
            int num = -1;
            try{
                num = Integer.parseInt(sub);
            }catch (NumberFormatException e){

            }

            if(num>=0&&num<=255&&String.valueOf(num).length()==sub.length()){
                sb.append(sub);
                res.add(sb.toString());
                sb.delete(index+index_all,sb.length());
            }

            return;

        }
        for(int i=1;i<=3;i++){
            String sub = null;
            if(index+i<s.length())
                sub = s.substring(index,index+i);
            else
                sub = s.substring(index,s.length());

            int num = -1;
            try{
                num = Integer.parseInt(sub);
            }catch (NumberFormatException e){

            }
            if(num>=0&&num<=255&&String.valueOf(num).length()==sub.length()){
                sub = sub+".";
                findCombination(s,index+i,index_all+1,sb.append(sub));
                if(index_all!=3)
                    sb.delete(index+index_all,index+index_all+i+1);

            }
            else {
                break;
            }


        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses_93 restoreip = new RestoreIPAddresses_93();
        restoreip.restoreIpAddresses("010010");
        System.out.println(restoreip.res);
    }
}
