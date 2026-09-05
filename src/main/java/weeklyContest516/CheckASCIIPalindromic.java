package weeklyContest516;

import java.util.Scanner;

//https://leetcode.com/problems/check-ascii-palindromic/description/
public class CheckASCIIPalindromic {
    public boolean isPalindromic(String s){
        int n = s.length();
        for(int i = 0;i<=n/2;i++){
            int leftSideOfString = s.charAt(i);
            int rightSideOfString = s.charAt(n-i-1);
            for(int j = 0;j<=8;j++){
                int leftBinary = (leftSideOfString>>j)&1;
                int rightBinary =(rightSideOfString>>(7-j))&1;
                if(leftBinary!=rightBinary)
                    return false;
            }
        }
        return true;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        CheckASCIIPalindromic cp = new CheckASCIIPalindromic();
        System.out.println(cp.isPalindromic(s));
    }
}
/**
 * Convert every character into its 8-bit ASCII representation.
 * Build the complete binary string.
 * Check whether that binary string is a palindrome.
 */
