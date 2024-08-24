class Solution {
    public int fibbo(int index){
        int a = 0;
        int b = 1;
        int c = 0;
        if(index == 0) return 0;
        else if(index == 1) return 1; 
        for(int i=0;i<index;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return a;
    }
    public int fib(int n) {
        return fibbo(n);
    }
}