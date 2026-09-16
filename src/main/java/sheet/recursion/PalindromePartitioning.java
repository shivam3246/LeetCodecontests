package sheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s){
        List<List<String>> list = new ArrayList<>();
        helper(s,new ArrayList<>(),0,list);
        return list;
    }
    void helper(String s, List<String> temp,int index,List<List<String>> list){
        if(index==s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index;i<s.length();i++){
            if(isPal(s,index,i)){
                temp.add(s.substring(index,i+1));
                helper(s,temp,i+1,list);
                temp.remove(temp.size()-1);
            }
        }

    }
    boolean isPal(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
    static void main() {
        String s ="aab";
        PalindromePartitioning p = new PalindromePartitioning();
        List<List<String>> answer = new ArrayList<>();
        answer = p.partition(s);
        System.out.println(answer);
    }
}
