class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        HashSet<String> set = new HashSet<>();
        for(int i[] : obstacles){
            set.add(i[0] + "_" + i[1]);
        }
        int x = 0;
        int y = 0;
        int direction = 0;
        int max = 0;

        for(int i=0; i<commands.length; i++){
            if(commands[i] == -1){
                direction = (direction + 1)%4;
            }else if(commands[i] == -2){
                if(direction == 0){
                    direction = 3;
                }else{
                    direction -= 1;
                }
            }else{
                for(int j=1; j<=commands[i]; j++){
                    int x_prev = x;
                    int y_prev = y;
                    if(direction == 0){
                        y++;
                    }else if(direction == 1){
                        x++;
                    }else if(direction == 2){
                        y--;
                    }else if(direction == 3){
                        x--;
                    }
                    if(set.contains(x + "_" + y)){
                        x = x_prev;
                        y = y_prev;
                        break;
                    }
                    max = Math.max(max, x*x + y*y);
                }
            }
        }
        return max;
    }
}