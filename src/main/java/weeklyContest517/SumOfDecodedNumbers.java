package weeklyContest517;
//https://leetcode.com/problems/sum-of-decoded-numbers/description/
public class SumOfDecodedNumbers {
    private static final int MOD = 1_000_000_007;
    public int sumDecoded(long []nums){
        long totalSum=0;
        for(long num:nums){
            totalSum=(totalSum+decode(num))%MOD;
        }
        return (int)totalSum;
    }
    long decode(long number){
        long width = number%10;
        long d = number/10;
        String dString = String.valueOf(d);
        String xString = dString.substring(0,(int)width);
        Long x = Long.parseLong(xString);
        String yString = dString.substring((int)width);
        long y = Long.parseLong(yString);
        return modPow(x,y,MOD);
    }
    long modPow(long base,long exp,int mod){
        long result = 1;
        base = base%mod;
        while(exp>0){
            if((exp&1)==1){
                result = (result*base)%mod;
            }
            exp= exp>>1;
            base = (base*base)%mod;

        }
        return result;
    }
    static void main() {
        long []nums = {2522,2101};
        SumOfDecodedNumbers sm = new SumOfDecodedNumbers();
        int ans = sm.sumDecoded(nums);
        System.out.println(ans);
    }
}
