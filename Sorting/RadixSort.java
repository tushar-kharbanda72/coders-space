import java.util.*;
import java.lang.*;
import java.io.*;

class RadixSort{

    private int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }

    private void sort(int[] arr, int digit){
        LinkedList[] q = new LinkedList[10];
        for(int i=0; i<10; i++)
            q[i] = new LinkedList();
        for(int i=0; i<arr.length; i++){
            q[(arr[i]/digit)%10].add(arr[i]);
        }
        int index = 0;
        for(int i=0; i<10; i++){
            while(q[i].size()>0){
                arr[index++] = (int)q[i].getFirst();
                q[i].removeFirst();
            }
        }
    }
    public void rSort(int[] arr){
        int maxx = max(arr);

        for(int i=1; maxx/i > 0; i *= 10)
            sort(arr, i);
    }

    public static void main(String[] args){
        RadixSort r = new RadixSort();
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        r.rSort(arr);

        for(int i: arr){
            System.out.println(i);
        }
    }
}