package com.example.leetcodedemo.easy;

/**
 * @author wc
 * @date 2023/2/20 10:49
 * desc   Stay hungry, stay foolish
 **/

/**
 *编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * https://leetcode.cn/problems/longest-common-prefix/
 */
public class num14 {
    public static void main(String[] args) {
     String[]   strs = {"flower","flow","flight","floa"};
        String s = new Solution().longestCommonPrefix(strs);
        System.out.println(s);
    }
//    static class Solution {
//        public String longestCommonPrefix(String[] strs) {
//           String minLength="";
//            for (int i = 0; i < strs.length-1; i++) {
//                if (strs[i].length()>strs[i+1].length()){
//                    minLength=strs[i+1];
//                }
//                //System.out.println(minLength);
//            }
//            return minLength;
//        }
//    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            ////公共前缀比所有字符串都短，随便选一个先
            String s=strs[0];
            for (String str : strs) {
                while (!str.startsWith(s)){
                    if (s.length()==0)return "";
                    //公共前缀不匹配就让它变短！
                    s=s.substring(0,s.length()-1);
                }
            }
            return s;
        }
    }
}
