package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {
	static Map<String, Integer> dp=new HashMap<>();
	public static void main(String[] args) {
		int target = 1000000000;
		int startFuel = 145267354;
		int[][] stations = {{5510987,84329695},{10682248,76273791},{56227783,136858069},{91710087,18854476},{111148380,127134059},{165982642,122930004},{184216180,124802819},{217578071,7123113},{233719001,95862544},{339631786,7676497},{349762649,136128214},{403119403,21487501},{423890164,61095325},{424072629,50415446},{572994480,13561367},{609623597,69207102},{662818314,84432133},{678679727,20403175},{682325369,14288077},{702137485,6426204},{716318901,47662322},{738137702,129579140},{761962118,23765733},{820353983,70497719},{895811889,75533360}};
		System.out.println(minRefuelStops(target, startFuel, stations));
	}
	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
//		int[][] a = {{10,60},{20,30},{30,30},{60,40}};
		int disTo = startFuel; int ps = 0;
		PriorityQueue<int[]> queue = new PriorityQueue<>((s1, s2) -> {
			return Integer.compare(s2[1], s1[1]);
		});
		int i=0;
		int len = stations.length;
		int stops=0;
		while(target>disTo) {
			while(i<len && disTo>=(stations[i][0]-ps)) {
				queue.add(stations[i]);
				i++;
			}
			if(queue.isEmpty()) return -1;
			int[] station = queue.poll();
			disTo = disTo-(station[0]-ps)+station[1];
			target = target - (station[0]-ps);
			ps = station[0];
			stops++;
		}
		return stops;
	}
	public static int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int res = helper(target, 0, startFuel, stations, 0);
         return (res>=10000000) ? -1 : res;
        
    }
    public static int helper(int target, int fuelStart, int fuelLeft, int[][] stations, int idx) {
    	if(target<=fuelLeft) return 0;
        if(idx>=stations.length) 
        	return 10000000;
        int[] station = stations[idx];
        int fuelEnd = fuelStart+fuelLeft;
        if(fuelStart>station[0] || fuelEnd<station[0]) return 10000000;
        String key=fuelStart+""+fuelEnd+""+target;
        if(dp.get(key)!=null) {
            return dp.get(key);
        }
        dp.put(key, Math.min(1+helper(target-(station[0]-fuelStart), station[0], ((fuelLeft-(station[0]-fuelStart))+station[1]), stations, idx+1), 
                          helper(target, fuelStart, fuelLeft, stations, idx+1)));
        return dp.get(key);
    }
}
