package weeklyContest515;

public class NearestAvailableDrone {
    public int nearestDrone(int [][]drones,int []target){
        int min = Integer.MAX_VALUE;
        int near = -1;
        for(int i = 0;i<drones.length;i++){
            int sum = Math.abs(drones[i][0]-target[0])+Math.abs(drones[i][1]-target[1]);
            if(sum<=drones[i][2]&sum<min){
                min=sum;
                near = i;
            }
        }
        return  near;
    }
    static void main() {
        int [][]drones = {{0,0,8},{2,2,9}};
        int []target = {3,4};
        NearestAvailableDrone nd = new NearestAvailableDrone();
        int ans = nd.nearestDrone(drones,target);
        System.out.println(ans);

    }
}
