/*Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)*/


public class Solution {
    // DO NOT MODIFY THE LIST
    public int maximumGap(final List<Integer> a) {
        int[] left = new int[a.size()];
        int[] right = new int[a.size()];
        left[0] = a.get(0);
        for(int i=1; i<a.size(); i++){
            left[i] = Math.min(left[i-1], a.get(i));
        }
        right[a.size()-1] = a.get(a.size()-1);
        for(int i=a.size()-2; i>=0; i--){
            right[i] = Math.max(right[i+1], a.get(i));
        }

        int i=0, j=0;
        int max=-1;
        int n =a.size();
        while(i<n && j<n){
            if(left[i] <= right[j]){
                max = Math.max(max, j-i);
                j++;
            }else i++;
        }
        return max;
    }
}
