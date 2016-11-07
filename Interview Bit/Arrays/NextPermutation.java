/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

*/

public class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        int n = a.size();
        for(int i = n-1; i > 0; i--){
            if(a.get(i) >a.get(i-1)){
                int index = findMinMax(a, i, n, a.get(i-1));
                swap(a,index, i-1);
                sort(a, i, n);
               // print(a, i, n);
                return;
            }
        }
        Collections.sort(a);
    }

    public int findMinMax(ArrayList<Integer> a, int start, int end, int value){
        int minMax = Integer.MAX_VALUE;
        int index=0;
        for(int i=start; i<end; i++){
            if(a.get(i) > value && a.get(i) < minMax){
                minMax = a.get(i);
                index = i;}
        }
        return index;
    }

    public void swap(ArrayList<Integer> a, int i, int j){
        int temp  = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public void sort(ArrayList<Integer> a, int pivot, int n){
         ArrayList<Integer> b  = new ArrayList<Integer>();
        for(int i=pivot; i<n; i++)
            b.add(a.get(i));
        Collections.sort(b);
        int j = 0 ;
        for(int i=pivot; i<a.size() && j < b.size(); i++, j++)
            a.set(i, b.get(j));
    }
}
