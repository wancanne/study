package com.example.leetcodedemo.easy;

/**
 * @author wc
 * @date 2023/2/14 0:46
 * desc   Stay hungry, stay foolish
 **/

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class num1 {



    //自己暴力求解
//    class Solution {
//        int reNum[];
//        public int[] twoSum(int[] nums, int target) {
//            //将目标减去数组里的值 然后和其他值匹配
//            //如果相等,就可以返回两个数组成的数组
//            for (int i = 0; i < nums.length; i++) {
//                int f=target-nums[i];
//                for (int j = 0; j < nums.length; j++) {
//                    if (nums[j]==f && j!=i)
//                        return  reNum= new int[]{i,j};
//                }
//            }
//            return reNum;
//        }
//    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(nums[i])){
                    return new int[]{hashMap.get(nums[i]),i};
                }
                hashMap.put(target-nums[i],i);
            }
            return null;
        }
    }




}
