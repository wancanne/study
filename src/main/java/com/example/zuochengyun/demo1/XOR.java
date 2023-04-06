package com.example.zuochengyun.demo1;
//我提交了
/**
 * @author wc
 * @date 2023/4/6 13:15
 * desc   Stay hungry, stay foolish
 **/
public class XOR {
    public static void main(String[] args) {
        int i=6;//110
        int j=8;//111
         i=i^j;//异或运算
         j=i^j;//异或运算
         i=i^j;//异或运算
        //  110
        // ^111 =  不同为1 相同为0
        //  001 二进制 对应的数字c=1
        // 异或运算 : 相同为0 不同为1
        // 同或运算:  相同为1 不同为0
        // 标准记法为: 异或运算就记成 无进位相加!
        System.out.println(i);
        System.out.println(j);
    }
}
