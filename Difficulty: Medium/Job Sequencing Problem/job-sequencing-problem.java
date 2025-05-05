//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    
    class Pair {
        int deadline;
        int profit;
        public Pair(int d, int p){
            this.deadline = d;
            this.profit = p;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        Pair[] jobs = new Pair[deadline.length];
        int max = 0;
        for(int i = 0; i < deadline.length; i++){
            jobs[i] = new Pair(deadline[i], profit[i]);
            max = Math.max(max, deadline[i]);
        }
    
        // Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
    
        int[] schedule = new int[max + 1];
        Arrays.fill(schedule, -1);
    
        int profitResult = 0;
        int jobsResult = 0;
    
        for(Pair job : jobs){
            int d = job.deadline;
            int p = job.profit;
            int j = d;
            while(j > 0 && schedule[j] != -1){
                j--;
            }
            if(j > 0){
                schedule[j] = 1;
                jobsResult++;
                profitResult += p;
            }
        }
    
        return new ArrayList<>(Arrays.asList(jobsResult, profitResult));
    }

}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends