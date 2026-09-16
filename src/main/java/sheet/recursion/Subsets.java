package sheet.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Subsets{
    List<List<Integer>> subsets(int []nums){
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),list);
        return list;
    }
    void helper(int []nums,int index,List<Integer> temp,List<List<Integer>> list){
        list.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            helper(nums,i+1,temp,list);
            temp.remove(temp.size()-1);
        }
    }
    static void main() {
        int []nums ={1,2,3};
        Subsets s = new Subsets();
        List<List<Integer>> list = new ArrayList<>();
        list = s.subsets(nums);
        System.out.println(list);

    }
}
