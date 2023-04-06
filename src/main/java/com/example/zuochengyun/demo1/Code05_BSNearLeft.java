package com.example.zuochengyun.demo1;

/**
 * @author wc
 * @date 2023/4/4 17:03
 * desc   Stay hungry, stay foolish
 **/
public class Code05_BSNearLeft {
    //在arr上 找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    //for test
    public static int test(int[] arr,int value){
        return -1;
    }


}
