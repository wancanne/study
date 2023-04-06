package com.example.zuochengyun.demo1;

/**
 * @author wc
 * @date 2023/4/6 15:58
 * desc   Stay hungry, stay foolish
 **/


public class code07 {
    public static void main(String[] args) {
//        System.out.println(printOddTimeNum1(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 3, 2, 56}));
//
//        System.out.println("*****************************打印最右侧的1");
//        //
//        System.out.println(getFaRRightOne(6));
        int[] ints = printOddTimeNum2(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 3, 2, -56,39,39,39});
        System.out.println(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

       // System.out.println(printOddTimeNum2(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 3, 2, 56,39}));
    }


    /**
     * * 题目2
     * * 一个数组中有一种数出现了奇数次 其他数都出现了偶数次 怎么找到并打印这种数
     */
    public static int printOddTimeNum1(int[] array) {
        if (array == null || array.length == 0) return -1;
        int eor = 0;
        for (int i = 0; i < array.length; i++) {
            eor ^= array[i];
        }
        return eor;
    }
    /**t
    /**
     * * 题目3
     * * 一个数组中有两种数出现了奇数次 其他数都出现了偶数次 怎么找到并打印这两种数
     */
    public static int[]  printOddTimeNum2(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        int eor = 0;
        for (int i = 0; i < array.length; i++) {
            eor ^= array[i];
        }

        int onlyOne = 0;
        int b;
        //这里的 eor = a^b !=0  并且a!=b
        // 说明 a 和 b 一定有一个位数上为 1  假设为第8位数上 a为1 那么b 就为0
        // 所以 eor ^ 左右边的 1得 到 a 或者 b

        int rightOne = eor & ((~eor) + 1);
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & rightOne) != 0) {
                onlyOne ^= array[i];
            }
        }
        b = eor ^ onlyOne;
        System.out.println(onlyOne  + "   "+ b );
        return new int[]{onlyOne, b};
    }


    /**
     * 提取一个整型数的 最右侧的 1
     * *
     * * 思想：
     * * N & ((-N)+1)
     * *
     * * int N =N
     * * 二进制表现形式为：
     * * 0000 1000 0100 1000 0001 1110 1110 0010
     * * 这里就是提取出
     * * 0000 0000 0000 0000 0000 0000 0000 0010
     * */
    public static int  getFaRRightOne(int n){
        int m=n & ((~n)+1);
        //System.out.println(m);
        return m;
    }


    //写出二进制上为1的个数
    public static int bitCount(int N){
        int count = 0;
        while (N!=0){
            int rightOne=N & ((~N)+1);
            count++;
            N ^=rightOne;
        }
        return count;
    }
}
