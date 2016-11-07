/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]*/


public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n =a.size();
        for(int i = 0; i<n/2; i++){
            for(int x = i; x<n-i-1; x++){
                int temp = a.get(x).get(i);
                a.get(x).set(i, a.get(n-i-1).get(x));
                a.get(n-i-1).set(x, a.get(n-x-1).get(n-i-1));
                a.get(n-x-1).set(n-i-1, a.get(i).get(n-x-1));
                a.get(i).set(n-x-1, temp);
            }
        }
    }
}
