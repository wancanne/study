package com.example.leetcodedemo.easy;

/**
 * @author wc
 * @date 2023/2/14 23:47
 * desc   Stay hungry, stay foolish
 **/

/**
 *  https://leetcode.cn/problems/palindrome-number/
 *
 *  给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class num2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

     /*   StringBuilder stringBuilder = new StringBuilder(-1233);
        String be=String.valueOf(stringBuilder);
        String af=String.valueOf(stringBuilder.reverse());

        System.out.println(stringBuilder.reverse());
        System.out.println(be.equals(af));*/
        int a=9;
        int b=9/10;
        int c =9%10;
        System.out.println(b);
        System.out.println(c);
        System.out.println(solution.isPalindrome(121));

    }

//    static class Solution {
//        public boolean isPalindrome(int x) {
//            boolean flag=false;
//            //暴力 转为string 进行翻转
//            StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
//            String be=String.valueOf(stringBuilder);
//            String af=String.valueOf(stringBuilder.reverse());
//            StringBuilder reverse = stringBuilder.reverse();
//            if (be.equals(af) && x>=0){
//                flag=true;
//            }
//            return flag;
//        }
//    }


    static class Solution {
        public boolean isPalindrome(int x) {
            //数学解法
            //可以考虑将数字取模, 大概思路就是
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int reNum = 0;
            while (x > reNum) {
                reNum = reNum * 10 + x % 10;
                x /= 10;
            }
            return x == reNum || x == reNum / 10;
        }
    }

}
