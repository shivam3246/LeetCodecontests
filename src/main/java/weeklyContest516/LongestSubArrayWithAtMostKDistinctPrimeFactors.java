package weeklyContest516;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubArrayWithAtMostKDistinctPrimeFactors {
    int []smallestPrimefactor;
    public void sieve(int maxNum) {
        smallestPrimefactor = new int[maxNum+1];
        for(int i = 0;i<=maxNum;i++){
            smallestPrimefactor[i]=i;
        }
        smallestPrimefactor[0] = 0;
        smallestPrimefactor[1] = 1;
        for(int i = 2;i*i<=maxNum;i++){
            if(smallestPrimefactor[i]==i){
                for(int j = i*i;j<=maxNum;j+=i){
                    if(smallestPrimefactor[j]==j){
                        smallestPrimefactor[j]=i;
                    }
                }
            }
        }
    }
    private Set<Integer> getPrimeFactors(int num){
        Set<Integer> factors = new HashSet<>();
        while(num>1){
            int spf = smallestPrimefactor[num];
            factors.add(spf);
            while(num%spf==0){
                num/=spf;
            }
        }
        return factors;
    }
    public int longestSubarray(int[] nums, int k) {
        sieve(100000);
        int n = nums.length;
        int maxLength = 0;
        int left = 0;
        Map<Integer,Integer> primeCount = new HashMap<>();//this will store the prime and it's total occurances
        for(int right = 0;right<n;right++){
            Set<Integer> rightPrimes = getPrimeFactors(nums[right]);
            for(int prime:rightPrimes){
                primeCount.put(prime,primeCount.getOrDefault(prime,0)+1);
            }
            while (primeCount.size()>k){
                Set<Integer> leftPrimes = getPrimeFactors(nums[left]);
                for(int prime:leftPrimes){
                    primeCount.put(prime,primeCount.get(prime)-1);
                    if(primeCount.get(prime)==0){
                        primeCount.remove(prime);
                    }
                }
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;

    }
    static void main() {
        int []nums = {7,6,10,12,11};
        int k = 3;
        LongestSubArrayWithAtMostKDistinctPrimeFactors lf = new LongestSubArrayWithAtMostKDistinctPrimeFactors();
        int ans = lf.longestSubarray(nums,k);
        System.out.println(ans);
    }
}
//I think there will be three concepts
/*
1.Sieve Sabhi primes ko precompute karo for fast lookup
2.getPrimeFacts => for every range get primes
3.Sliding window lgake longest valid subarray dhundo
 */