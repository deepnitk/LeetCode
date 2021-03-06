//Solution using TreeMap (priority Queue)
//TC: O(2*N*log N)

class Solution {
    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        int height;
        boolean isStart;
        
        @Override
        public int compareTo(BuildingPoint o) {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if ( this.x != o.x ) {
                return this.x - o.x;
            }
            else {
                return (this.isStart ? -this.height: this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //for all start and end of building put them into List of BuildingPoint
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index  = 0;
        for(int[] building: buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];
            
            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        
        Arrays.sort(buildingPoints);
        
        //using TreeMap because it gives log time performance.
        //PriorityQueue in java does not support remove(object) operation in log time.
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0, 1);
        //queue1.add(0);
        int prevMaxHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        for( BuildingPoint buildingPoint : buildingPoints) {
            //if it is start of building then add the height to map. If height already exists then increment
            //the value
            if ( buildingPoint.isStart ) {
                queue.compute(buildingPoint.height, (key, value) -> {
                   if ( value != null) {
                       return value + 1;
                   }
                   return 1;
                });
            }
            else { //if it is end of building then decrement or remove the height from map.
                queue.compute(buildingPoint.height, (key, value) -> {
                   if ( value == 1) {
                       return null;
                   }
                   return value - 1;
                });
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue.lastKey();

            //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.
            if ( prevMaxHeight != currentMaxHeight ) {
                res.add(new ArrayList<>(List.of(buildingPoint.x, currentMaxHeight)));
                prevMaxHeight = currentMaxHeight;
            }
        }
        return res;
        
    }
}
