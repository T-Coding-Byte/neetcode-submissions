
class Solution {


    static double distanceCalc(int x, int y){
        return Math.sqrt(x * x + y * y);
        }

    public int[][] kClosest(int[][] points, int k) {
    //iterate through row 0, calculate euclidian distance
    //put distance into min heap
    //use some sort of hash to obtain coordinates from distance 
    int[][] result = new int[k][2];
                //arraylist instead of add
    ArrayList<Integer> coords = new ArrayList<>();
    HashMap<Double,ArrayList<Integer>> map = new HashMap<>(); //distance coord map

    PriorityQueue<Double> distances = new PriorityQueue<>();
    
    for(int i = 0; i < points.length; i++){
        int x = points[i][0];
        int y = points[i][1];
        double distance = distanceCalc(x,y);
        distances.offer(distance);
        //if distance already in hashmap then make arraylist add
        //else make new entry
        ArrayList<Integer> coordSet = new ArrayList<>();
        coordSet.add(x);
        coordSet.add(y);
        if(map.containsKey(distance)){
            map.get(distance).addAll(coordSet);
        }
        else{
            map.put(distance, coordSet);
        }
    }
/*
    for(int i = 0; i < k; i++){
        double minDist = distances.poll();
        System.out.println(minDist);
        for(int j = 0; j < map.get(minDist).size(); j += 2){
            
            result[i] = map.get(minDist).subList(j,j+2).stream()
               .mapToInt(Integer::intValue)
               .toArray();
            i++;
        }
        i--;
    }

    int i = 0;
    while(i<k){
        double minDist = distances.poll();
        System.out.println(minDist);
        for(int j = 0; j < map.get(minDist).size(); j += 2){
            
            result[i] = map.get(minDist).subList(j,j+2).stream()
               .mapToInt(Integer::intValue)
               .toArray();
            i++;
            if(i >= k) break;
        }
    }
    return result;
    }
*/
    int i = 0;

    while (i < k && !distances.isEmpty()) {
    double minDist = distances.poll();

    ArrayList<Integer> list = map.remove(minDist);

    if (list == null) {
        continue;
    }

    for (int j = 0; j < list.size() && i < k; j += 2) {
        result[i] = new int[] {
            list.get(j),
            list.get(j + 1)
        };
        i++;
    }
    }
    return result;
}
}
