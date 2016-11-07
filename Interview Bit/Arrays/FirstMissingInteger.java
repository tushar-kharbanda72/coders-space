
/*Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.*/



public class Solution {
    public int firstMissingPositive(ArrayList<Integer> a) {
        int n = a.size();
        for(int i=0; i<n; i++){
            if(a.get(i) != i+1 && a.get(i)<=n && a.get(i) > 0 && a.get(a.get(i)-1) != a.get(i)){
                int t = a.get(a.get(i)-1);
                a.set(a.get(i)-1, a.get(i));
                a.set(i, t);
                i--;
            }
        }
        for(int i=0; i<n; i++){
            if(i+1 != a.get(i))
                return i+1;
        }
        return n+1;
    }
}
