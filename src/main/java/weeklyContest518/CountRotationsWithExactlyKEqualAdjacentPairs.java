package weeklyContest518;

public class CountRotationsWithExactlyKEqualAdjacentPairs {
    public int countRotations(String s, int k) {
        int count = 0;
        int n = s.length();
        for(int r = 0;r<n;r++){
            String rotated= s.substring(r)+s.substring(0,r);
            int score=0;
            for(int i =0;i<n-1;i++){
                if(rotated.charAt(i)==rotated.charAt(i+1))
                    score++;

            }
            if(score==k)
                count++;
        }
        return count;
    }
    static void main() {
        String s = "aab";
        int  k = 1;
        CountRotationsWithExactlyKEqualAdjacentPairs ck = new CountRotationsWithExactlyKEqualAdjacentPairs();
        int ans = ck.countRotations(s,k);
        System.out.println(ans);
    }
}
