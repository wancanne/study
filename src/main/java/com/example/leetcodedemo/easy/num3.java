package com.example.leetcodedemo.easy;

/**
 * @author wc
 * @date 2023/2/18 22:29
 * desc   Stay hungry, stay foolish
 **/

/**
 * https://leetcode.cn/problems/roman-to-integer/
 */

import javax.xml.soap.Node;
import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 IV  IX
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。  XL XC
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。  CD  MD
 * 给定一个罗马数字，将其转换成整数。
 */
public class num3 {
    static Solution getSolution(){
        return new Solution();
    }

    static Solution1 getSolution2(){
        Solution1 solution1;
        solution1 = new Solution1();
        return solution1;
    }

    static Solution1 getSolution1(){
        Class<?> aClass = null;
        try {
            aClass = Class.forName("Solution1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass.getName());
        return null;
    }



    public static void main(String[] args){
        //Solution solution1 = new Solution();
        Solution solution = getSolution();
        long millis = System.currentTimeMillis();
        System.out.println( solution.romanToInt("MCMXCIV"));
       Solution1 solution1 = new Solution1();
       System.out.println( new Solution1().romanToInt("MCMXCIV"));

        System.out.println(System.currentTimeMillis()-millis);
    }


    /**
     * 参考的 题解
     * 这题懂了就非常简单。首先建立一个HashMap来映射符号和值，
     * 然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；
     * 否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
     */
    static class Solution {

        public int romanToInt(String s) {
            //取模不就行了
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("I",1);
            hashMap.put("V",5);
            hashMap.put("X",10);
            hashMap.put("L",50);
            hashMap.put("C",100);
            hashMap.put("D",500);
            hashMap.put("M",1000);
            int num;
            int count = 0;
            String[] split = s.split("");
            for(int i=0;i<split.length;i++){
                int j=0;
                int k=0;
                if (i< split.length-1){
                     j=hashMap.get(split[i]);
                     k=hashMap.get(split[i+1]);
                }else {
                     j=hashMap.get(split[i]);
                     k=hashMap.get(split[i]);
                }

                if(j>=k) {num=j;}
                else  {num=k-j;i++;}
                count+=num;
            }
            return count;
        }
    }

    static  class Solution1 {
        public int romanToInt(String s) {
            int count=0;
            int num=getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int k=getValue(s.charAt(i));
                if (num>=k){
                    count+=num;
                }else {
                    count=count-num;
                }
                num=k;
            }
            count+=num;
            return count;
        }
    }
    static  private int getValue(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}
