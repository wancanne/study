package com.example.zuochengyun.demo1;

/**
 * @author wc
 * @date 2023/4/4 13:45
 * desc   Stay hungry, stay foolish
 **/

/**
 * * 判断数 是否存在 在有序数组里
 */
public class Code04_BSExist {
    public static void main(String[] args) {

    }
    //判断num 一个数 在不在有序数组sortArray里
    public static boolean exist(int[] sortArray, int num) {
        if (sortArray == null || sortArray.length == 0) return false;
        int L = 0;
        int R = sortArray.length - 1;
        int mid = 0;
        while (L < R) {
            // L+ (R-L)/2    一个数A/2 可以写成 A>>1
            mid = L + ((R - L) >> 1);// 这个写法等于 mid=(L+R)/2
            if (sortArray[mid] == num) {
                return true;
            } else if (sortArray[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortArray[L] == num;
    }


    public static int test(int[] arr,int values){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=values){
                return i;
            }
        }
        return -1;

    }
}
