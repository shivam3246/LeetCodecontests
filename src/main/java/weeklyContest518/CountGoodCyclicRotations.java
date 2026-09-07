package weeklyContest518;

public class CountGoodCyclicRotations {

    public int countGoodRotations(int []nums){
        int count = 0;
        long totalSum=0;
        long firstSum=0;
        int n = nums.length;
        int half = n/2;
        for(int i = 0;i<n;i++){
            totalSum+=nums[i];
            if(i<half){
                firstSum+=nums[i];
            }
        }
        for(int rotations = 0;rotations<n;rotations++){
            long secondSum = totalSum-firstSum;
            if(firstSum>secondSum)
                count++;
            firstSum-=nums[rotations];
            firstSum+=nums[(rotations+half)%n];
        }
        return count;
    }
    static void main() {
        int []nums = {1,2,3,4,5,6};
        CountGoodCyclicRotations cc = new CountGoodCyclicRotations();
        int ans = cc.countGoodRotations(nums);
        System.out.println(ans);
    }
}
