package sheet.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses,int [][]prerequisites){
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i =0;i<prerequisites.length;i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int []inDegree = new int[numCourses+1];
        for(int i =0;i<numCourses;i++){
            for(int nei:list.get(i)){
                inDegree[nei]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int current = q.poll();
            topo.add(current);
            for(int nei:list.get(current)){
                inDegree[nei]--;
                if(inDegree[nei]==0){
                    q.offer(nei);
                }
            }
        }
        return  topo.size()==numCourses?true:false;
    }
    static void main() {
        int [][]prerequisites = {{1,0}};
        int numCourses = 2;
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(numCourses,prerequisites));
    }
}
