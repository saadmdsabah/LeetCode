class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        
        // Initialize the matrix with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        int rowstart = 0;
        int rowend = m - 1;
        int colstart = 0;
        int colend = n - 1;

        while (colstart <= colend && rowstart <= rowend) {
            // Fill top row
            for (int j = colstart; j <= colend; j++) {
                if (head != null) {
                    matrix[rowstart][j] = head.val;
                    head = head.next;
                }
            }
            rowstart += 1;
            
            // Fill right column
            for (int j = rowstart; j <= rowend; j++) {
                if (head != null) {
                    matrix[j][colend] = head.val;
                    head = head.next;
                }
            }
            colend -= 1;
            
            // Fill bottom row
            if (rowstart <= rowend) {
                for (int j = colend; j >= colstart; j--) {
                    if (head != null) {
                        matrix[rowend][j] = head.val;
                        head = head.next;
                    }
                }
                rowend -= 1;
            }
            
            // Fill left column
            if (colstart <= colend) {
                for (int j = rowend; j >= rowstart; j--) {
                    if (head != null) {
                        matrix[j][colstart] = head.val;
                        head = head.next;
                    }
                }
                colstart += 1;
            }
        }
        
        return matrix;
    }
}