/*Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1*/


public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0; i<a.size(); i++){
            if(s.contains(a.get(i)))
                return a.get(i);
            s.add(a.get(i));
        }
        return -1;
    }
}
