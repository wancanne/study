package com.example.zuochengyun.demo1;

/**
 * @author wc
 * @date 2023/4/4 17:17
 * desc   Stay hungry, stay foolish
 **/
// 局部最小值

/**
 * * 题目描述：
 * * 给定一个无序arr数组 相邻位置数不相等
 * *找到局部最小值 任意一个局部最小值就行了
 * * 局部最小： 最左边下标 0位置数比1位置数小 0位置数就是局部最小
 * *           最右边数n比 n-1 小 那么n也是局部最小
 * *  i-1 i i+1  i<i-1 i<i+1 那么i就是局部最小值
 */
public class code06 {
    public static void main(String[] args) {
        int lessIndex = getLessIndex(new int[]{17, 16, 10, 9, 8, 7, 6, 11, 5, 13});
        System.out.println(lessIndex);
    }

    public static int getLessIndex(int[] arr){
        if (arr==null || arr.length==0){
            return -1;

        }

        if (arr.length==1||arr[0]<arr[1]){
            return 0;
        }
        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int left=1;
        int right=arr.length-2;
        int mid=0;
        while (left<right){
            mid=(left+right)/2;
            if (arr[mid]>arr[mid-1]){
                right=mid-1;
            }else if (arr[mid]>arr[mid+1]){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
