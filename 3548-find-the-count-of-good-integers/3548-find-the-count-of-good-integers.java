class Solution {

    HashSet<String> set = new HashSet<>();
    long result = 0;
    int[] fac = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 };

    public String printPalindrome(String curr, boolean even) {
        if (even) {
            for (int i = curr.length() - 1; i >= 0; i--) {
                curr = curr + curr.charAt(i);
            }
        } else {
            for (int i = curr.length() - 2; i >= 0; i--) {
                curr = curr + curr.charAt(i);
            }
        }
        return curr;
    }

    public String sortPalindrome(String palindrome) {
        int[] arr = new int[palindrome.length()];
        for (int i = 0; i < palindrome.length(); i++) {
            arr[i] = (int) palindrome.charAt(i);
        }
        Arrays.sort(arr);
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += (char) arr[i];
        }
        return result;
    }

    public int permutation(String palindrome) {
        int[] map = new int[10];
        boolean zeroFlag = false;
        for (int i = 0; i < palindrome.length(); i++) {
            int val = (int) (palindrome.charAt(i) - '0');
            if (val == 0) {
                zeroFlag = true;
            }
            map[val]++;
        }
        int totalFactorial = fac[palindrome.length()];
        int denominator = 1;
        for (int i = 0; i < 10; i++) {
            if (map[i] > 1) {
                denominator *= fac[map[i]];
            }
        }
        int total = totalFactorial / denominator;
        if (zeroFlag) {
            int zeroTotalFactorial = fac[palindrome.length() - 1];
            int zeroDenominator = 1;
            for (int i = 0; i < 10; i++) {
                if (map[i] > 1) {
                if (i == 0) {
                    zeroDenominator *= fac[map[i] - 1];
                } else {
                    zeroDenominator *= fac[map[i]];
                }
                }
            }
            int zeroTotal = zeroTotalFactorial / zeroDenominator;
            return total - zeroTotal;
        }
        return total;
    }

    public void genPalindrome(int index,int n,String curr,int start,boolean even,int end,int k) {
        if (index > end) {
            String palindrome = printPalindrome(curr, even);
            long palindromeLong = Long.parseLong(palindrome);
            String sortedPalindrome = sortPalindrome(palindrome);

            if (palindromeLong % k == 0) {
                if (!set.contains(sortedPalindrome)) {
                set.add(sortedPalindrome);
                result += (long) permutation(palindrome);
                }
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            genPalindrome(index + 1, n, curr + "" + i, 0, even, end, k);
        }
    }

    public long countGoodIntegers(int n, int k) {
        if (n % 2 == 0) {
            genPalindrome(0, n, "", 1, true, n / 2 - 1, k);
        } else {
            genPalindrome(0, n, "", 1, false, n / 2, k);
        }
        return result;
    }
}