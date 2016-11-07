/*You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.

See Expected Output
NotesAll Notes
*/

public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> a) {

        int start = 0, end = 0;
        int n = a.size();
        int i;
        for(i = 0; i<n-1; i++){
            if(a.get(i) > a.get(i+1))
                {start = i;break;}
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(i == n-1){
            al.add(-1);
            return al;
        }

        for(i=n-1; i>0; i--){
            if(a.get(i) < a.get(i-1)){
                end = i;break;}
        }
        int si = start, ei = end;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(i=start; i<=end; i++){
            if(a.get(i) > max)
                max = a.get(i);
            if(a.get(i) < min)
                min = a.get(i);
        }
        for(i=0; i<start; i++){
            if(a.get(i) > min){
                si = i;
                break;
            }
        }
        for(i = n-1; i>end; i--){
            if(a.get(i) < max){
                ei = i;
                break;
            }
        }

        al.add(si);
        al.add(ei);
        return al;
    }
}
