/*Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:


Input:

1 2 3
4 5 6
7 8 9

Return the following :

[
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input :
1 2
3 4

Return the following  :

[
  [1],
  [2, 3],
  [4]
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        boolean flag1 = true, flag = true;
        int i = 0, j = 0;
        int n = a.size();
        if(a.size() <= 1)
            return a;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        while(flag){
            ArrayList<Integer> midRes = new ArrayList<Integer>();
            if(flag1){
                int jn = j;
                for(i = 0; i <= j && jn >= 0; i++, jn--)
                    midRes.add(a.get(i).get(jn));
                if(j == n-1){
                    flag1 = false;
                    i=1;
                }
                else j++;
            }
            else{
                int in = i;
                for(j = n-1; j >= i && in < n; in++, j--)
                    midRes.add(a.get(in).get(j));
                if(i == n-1) flag = false;
                else i++;
            }
            res.add(midRes);
        }
        return res;
    }
}
