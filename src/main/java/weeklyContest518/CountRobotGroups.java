package weeklyContest518;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/count-robot-groups/description/
public class CountRobotGroups {
    public int countGroup(int []position,int []speed,int distance){
        List<Integer> groupSpeeds =  new ArrayList<>();
        int n = position.length;
        for(int i = 0;i<n;i++){
            if(i==n-1||position[i+1]-position[i]>distance)
                groupSpeeds.add(speed[i]);
        }
        int answer = 0;
        int minSpeed = Integer.MAX_VALUE;
        for(int i = groupSpeeds.size()-1;i>=0;i--){
            int s = groupSpeeds.get(i);
            if(s<=minSpeed){
                answer++;
                minSpeed=s;
            }
        }
        return answer;
    }
    static void main() {
        int []positon ={1,5,6,20};
        int []speed = {4,3,2,3};
        int distance = 1;
        CountRobotGroups cr = new CountRobotGroups();
        int result = cr.countGroup(positon,speed,distance);
        System.out.println(result);
    }
}
