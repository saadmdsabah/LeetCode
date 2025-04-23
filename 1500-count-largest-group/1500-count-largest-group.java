class Solution {

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int countLargestGroup(int n) {
        int[] count = new int[37];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            count[sum]++;
        }
        for(int sum=1; sum<37; sum++){
            max = Math.max(max, count[sum]);
        }
        int result = 0;
        for (int c : count) {
            if (c == max) result++;
        }
        return result;
    }
}
