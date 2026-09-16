package sheet.recursion;

import java.util.Arrays;

public class NQueens {
    final int n = 4;
    int []queen = new int[20];
    boolean check(int row,int col){
        for(int i=0;i<row;i++){
            int pRow = i;
            int pCol = queen[i];
            if(col==pCol||Math.abs(pCol-col)==Math.abs(pRow-row))
                return false;

        }
        return true;
    }
    int rec(int level){
        if(level==n)
            return 1;
        int ans = 0;
        for(int col=0;col<n;col++){
            if(check(level,col)){
                queen[level] = col;
                ans+=rec(level+1);
                queen[level]=-1;
            }
        }
        return ans;
    }
    void printBoard(){
        for(int r = 0;r<n;r++){
            for(int c=0;c<n;c++){
                if(queen[r] ==c){
                    System.out.print("Q ");
                }
                else{
                    System.out.print(". ");
                }
                System.out.println();
            }
        }
    }
    static void main() {
        NQueens nq = new NQueens();
        Arrays.fill(nq.queen,-1);
        int ans = nq.rec(0);
        System.out.println(ans);
    }
}
