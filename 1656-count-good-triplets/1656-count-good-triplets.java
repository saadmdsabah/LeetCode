class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        ArrayList<ArrayList<Integer>> values = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(Math.abs(arr[i] - arr[j]) <= a){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    values.add(new ArrayList<>(temp));
                }
            }
        }
        
        for(int t=0; t<values.size(); t++){
            int i = values.get(t).get(0);
            int j = values.get(t).get(1);
            int k = j+1;

            for(; k<arr.length; k++){
                if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                    count++;
                }
            }
        }
        return count;
    }
}