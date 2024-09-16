class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<timePoints.size()-1; i++){
            int biggerNumber = Integer.parseInt(timePoints.get(i+1).substring(0, 2))*60 + Integer.parseInt(timePoints.get(i+1).substring(3, 5));
            int smallerNumber = Integer.parseInt(timePoints.get(i).substring(0, 2))*60 + Integer.parseInt(timePoints.get(i).substring(3, 5));
            min = Math.min(min, Math.min(biggerNumber - smallerNumber, (1440 - biggerNumber) + smallerNumber));
        }
        int biggerNumber = Integer.parseInt(timePoints.get(timePoints.size() - 1).substring(0, 2))*60 + Integer.parseInt(timePoints.get(timePoints.size() - 1).substring(3, 5));
        int smallerNumber = Integer.parseInt(timePoints.get(0).substring(0, 2))*60 + Integer.parseInt(timePoints.get(0).substring(3, 5));
        min = Math.min(min, Math.min(biggerNumber - smallerNumber, (1440 - biggerNumber) + smallerNumber));
        return min;
    }
}