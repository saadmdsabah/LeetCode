class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        HashSet<Double> set = new HashSet<>();
        
        int max = 0;
        for(int i : arr){
            set.add((double) i);
            max = Math.max(max, i);
        }
        
        int[] numbers = new int[max + 1];
        
        for(int i=0; i<arr.length; i++) numbers[arr[i]] = 1;
        
        for(int i=1; i<numbers.length; i++){
            if(numbers[i] != 0){
                for(int j=1; j<numbers.length; j++){
                    if(numbers[j] == 0) continue;
                    if(i != j){
                        double c = Math.sqrt(i*i + j*j);
                        if(set.contains(c)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        
    }
}