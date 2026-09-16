package sheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> permute(int []nums){
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,0,list);
        return list;
    }
    void helper(int []nums,int index,List<List<Integer>> list){
        if(index==nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) {
                perm.add(n);
            }
            list.add(perm);
        }
        for(int i = index;i<nums.length;i++){
            swap(nums,index,i);
            helper(nums,index+1,list);
            swap(nums,index,i);
        }
    }
    void swap(int []nums,int start,int end){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

    }

    static void main() {
        int []nums = {1,2,3};
        Permutations p = new Permutations();
        List<List<Integer>> answer = new ArrayList<>();
        answer=p.permute(nums);
        System.out.println(answer);
    }
}
