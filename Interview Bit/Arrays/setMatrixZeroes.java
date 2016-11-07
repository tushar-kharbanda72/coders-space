/*Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1
Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.

See Expected Output
NotesAll Notes
*/

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(a.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }

            }
        }
        for(int i=0; i<m; i++){
            if(row[i] == 1){
                for(int j=0; j<n; j++)
                    a.get(i).set(j, 0);
            }
        }
        for(int i=0; i<n; i++){
            if(col[i] == 1){
                for(int j=0; j<m; j++)
                    a.get(j).set(i, 0);
            }
        }


    }
}
