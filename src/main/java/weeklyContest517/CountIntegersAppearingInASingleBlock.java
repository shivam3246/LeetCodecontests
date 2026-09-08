package weeklyContest517;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/
public class CountIntegersAppearingInASingleBlock {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        map.put(nums[0],1);
        for(int i =1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        for(int val:map.values()){
            if(val==1)
                count++;
        }
        return count;
    }
    static void main() {
        int []nums = {3,3,1,2,2,1};
        CountIntegersAppearingInASingleBlock ca = new CountIntegersAppearingInASingleBlock();
        int ans = ca.countSpecialIntegers(nums);
        System.out.println(ans);

    }
}
