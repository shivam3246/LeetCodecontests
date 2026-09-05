package weeklyContest516;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array-ii/description/
public class FindAllNumbersDisappearedInArrayII {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int curr = lower;
        for(int num:nums){
            if(num<lower||num>upper)
                continue;
            if(curr<num)
                ans.add(Arrays.asList(curr,num-1));
            curr = Math.max(curr,num+1);
            if(curr>upper)
                break;

        }
        if(curr<=upper)
            ans.add(Arrays.asList(curr,upper));
        return ans;
    }
    static void main() {
        int []nums = {3,9,7};
        int lower = 1;
        int upper = 12;
        FindAllNumbersDisappearedInArrayII fd = new FindAllNumbersDisappearedInArrayII();
        List<List<Integer>> ans = new ArrayList<>();
        ans = fd.findDisappearedNumbers(nums,lower,upper);
        System.out.println(ans);
    }

}
/* This was a completely simple question
sort the array
compare the num with bounds
move the point
add to result
Boom it's done
 */