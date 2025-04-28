class Solution {
    class Window {
        int start;
        int end;
        Window(int s, int e) {
            start = s;
            end = e;
        }
    }
    public long countSubarrays(int[] numss, long k) {
        if (numss.length == 0) {
            return 0;
        }
        long[] nums = new long[numss.length];
        for (int i = 0 ; i < nums.length; i++) {
            nums[i] = (long)(numss[i]);
        }

        int s = 0;
        while (s < nums.length && nums[s] >= k) {
            s++;
        }
        if (s >= nums.length) {
            return 0;
        }
        int e = s + 1;
        long currSum = nums[s];
        List<Window> windows = new ArrayList<>();
        while (true) {
            if (e >= nums.length) {
                if (currSum < k && s < nums.length) {
                    windows.add(new Window(s, e));
                }
                break;
            }
            currSum = (currSum / (long)(e - s) + nums[e]) * (long)(e - s + 1);
            e++;
            if (currSum >= k) {
                windows.add(new Window(s, e - 1));
                while (currSum >= k) {
                    currSum = (currSum / (long)(e - s) - nums[s]) * (long)(e - s - 1);
                    s++;
                    if (s == e) {
                        while (s < nums.length && nums[s] >= k) {
                            s++;
                        }
                        e = s + 1;
                        if (s < nums.length) {
                            currSum = nums[s];
                        }
                        break;
                    }
                }
            }
        }

        long ret = 0l;
        for (int i = 0; i < windows.size(); i++) {
            Window w = windows.get(i);
            //System.out.printf("%d %d\n", w.start, w.end);
            long len = (long)(w.end - w.start);
            ret += (1l + len) * len / 2l;
            if (i > 0) {
                Window prevW = windows.get(i - 1);
                if (prevW.end > w.start) {
                    long foobar = prevW.end - w.start;
                    ret -= (1l + foobar) * foobar / 2l;
                }
            }
        }

        return ret;
    }
}