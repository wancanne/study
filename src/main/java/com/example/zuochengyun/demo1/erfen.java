package com.example.zuochengyun.demo1;

/**
 * @author wc
 * @date 2023/4/4 13:39
 * desc   Stay hungry, stay foolish
 **/
public class erfen {
    public static void main(String[] args) {
        getRightOne(10);

    }
    //找出一个数最后边的1
    public static void getRightOne(int num){
        int rightOne=num & ((-num)+1);
        System.out.println(rightOne);

    }
}
