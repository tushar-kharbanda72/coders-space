import java.util.ArrayList;
class MaxConsecutiveOnes {

    public ArrayList<Integer> findZeroes(int[] arr, int m) {
        int maxL = 0, maxWidth = 0;
        int windowL = 0, windowR = 0;
        int zeroesCount = 0;
        while(windowR < arr.length) {

            if(zeroesCount < m) {
                if(arr[windowR] == 0)
                    zeroesCount++;
                windowR++;
            }

            if(zeroesCount >= m) {
                if(arr[windowR] == 0){
                    if(arr[windowL] == 0) {
                        zeroesCount--;
                    }
                    windowL++;
                } else {
                    windowR++;
                }
            }
            if(windowR - windowL > maxWidth) {
                maxL = windowL;
                maxWidth = windowR - windowL;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = maxL; i < maxL + maxWidth; i++){
            if(arr[i] == 0){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        MaxConsecutiveOnes ob = new MaxConsecutiveOnes();
        ArrayList<Integer> res = ob.findZeroes(arr, 2);
        for(int n: res) {
            System.out.println(n);
        }
    }
}