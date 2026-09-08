package weeklyContest517;

import java.util.*;

public class MinimumOperationsFromSubSetI {
//    public int minOperations(int []nums,int sum){
//         final int INF=1_000_000_007;
//         int []dp = new int[sum+1];
//         Arrays.fill(dp,INF);
//         dp[0] =0;
//
//         for(int x:nums){
//             Map<Integer,Integer> states = new HashMap<>();
//             if(x<=sum)
//            states.put(x,0);
//             int curr = x;
//             int ops = 0;
//             while(curr>0){
//                 curr/=2;
//                 ops++;
//                 if(curr>0&&curr<=sum){
//                     states.put(curr,Math.min(states.getOrDefault(curr,INF),ops));
//                 }
//             }
//             long mul = x;
//             ops=0;
//             while(mul*2<=sum){
//                 mul*=2;
//                 ops++;
//                 states.put((int)mul,Math.min(states.getOrDefault((int)mul,INF),ops));
//             }
//             int []nextDp = dp.clone();
//             for(Map.Entry<Integer,Integer> entry:states.entrySet()){
//                 int v = entry.getKey();
//                 int cost = entry.getValue();
//                 for(int s = sum;s>=v;s--){
//                     if(dp[s-v]!=INF){
//                         nextDp[s] =Math.min(nextDp[s],dp[s-v]+cost);
//                     }
//                 }
//             }
//             dp=nextDp;
//         }
//         return dp[sum] >=INF?-1:dp[sum];
//    }
private final int INF = 1_000_000_000;
        private int[][] memo;
        private List<List<int[]>> allStates;

        public int minOperations(int[] nums, int sum) {
            int n = nums.length;
            memo = new int[n][sum + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }

            // Har index ke liye {value, cost} pairs precompute karo
            allStates = new ArrayList<>();
            for (int x : nums) {
                Map<Integer, Integer> map = new HashMap<>();

                // 0 operations
                if (x <= sum) map.put(x, 0);

                // Divisions
                int cur = x, ops = 0;
                while (cur > 0) {
                    cur /= 2;
                    ops++;
                    if (cur > 0 && cur <= sum) {
                        map.put(cur, Math.min(map.getOrDefault(cur, INF), ops));
                    }
                }

                // Multiplications
                long mul = x;
                ops = 0;
                while (mul * 2 <= sum) {
                    mul *= 2;
                    ops++;
                    map.put((int) mul, Math.min(map.getOrDefault((int) mul, INF), ops));
                }

                List<int[]> currentElementStates = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    currentElementStates.add(new int[]{entry.getKey(), entry.getValue()});
                }
                allStates.add(currentElementStates);
            }

            int ans = solve(0, sum);
            return ans >= INF ? -1 : ans;
        }

        private int solve(int idx, int remSum) {
            // Base case: target sum ban chuka hai
            if (remSum == 0) return 0;

            // Base case: saare elements khatam ho gaye lekin sum nahi bana
            if (idx == allStates.size()) return INF;

            // Already computed state
            if (memo[idx][remSum] != -1) return memo[idx][remSum];

            // Option 1: Current element ko skip karna (0 cost)
            int minCost = solve(idx + 1, remSum);

            // Option 2: Current element ki kisi ek state ko select karna
            for (int[] state : allStates.get(idx)) {
                int val = state[0];
                int cost = state[1];

                if (remSum >= val) {
                    minCost = Math.min(minCost, cost + solve(idx + 1, remSum - val));
                }
            }

            return memo[idx][remSum] = minCost;
        }
    static void main() {
        int []nums = {5,6,10};
        int sum = 4;
        MinimumOperationsFromSubSetI ms = new MinimumOperationsFromSubSetI();
        int ans = ms.minOperations(nums,sum);
        System.out.println(ans  );
    }
}
