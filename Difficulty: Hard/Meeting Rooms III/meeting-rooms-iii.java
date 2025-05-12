//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] roomCount = new int[n];
        long[] roomLastEndTime = new long[n];
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0], b[0]));

        for(int i=0; i<meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            long minEndTime = Long.MAX_VALUE;
            int minRoomNumber = 0;
            boolean available = false;

            for(int room=0; room<n; room++){
                if(roomLastEndTime[room] <= start){
                    roomLastEndTime[room] = end;
                    roomCount[room]++;
                    available = true;
                    break;
                }

                if(minEndTime > roomLastEndTime[room]){
                    minEndTime = roomLastEndTime[room];
                    minRoomNumber = room;
                }
            }

            if(!available){
                roomLastEndTime[minRoomNumber] = minEndTime + end - start;
                roomCount[minRoomNumber]++;
            }
        }

        int roomNumber = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            if(roomCount[i] > max){
                max = roomCount[i];
                roomNumber = i;
            }
        }
        return roomNumber;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends