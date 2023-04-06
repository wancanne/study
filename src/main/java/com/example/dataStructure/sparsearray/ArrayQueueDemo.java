package com.example.dataStructure.sparsearray;

import java.util.Scanner;

/**
 * @author wc
 * @date 2023/2/20 11:36
 * desc   Stay hungry, stay foolish
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //
        ArrayQueue queue = new ArrayQueue(3);
        char key=' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop =true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key=scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case  'g'://取出数据
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头
                    try{
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                default:
                    break;
            }
            System.out.println("程序退出-----");
        }
    }

    //使用数组模拟队列 -编写一个ArrayQueue 类
    static class ArrayQueue {
        //表示数组的最大容量
        private int maxSize;
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;//该数组用于存放数据 模拟队列

        //创建队列的构造器
        public ArrayQueue(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = -1;//执向队列头部 指向队列头的前一个位置
            rear = -1;//指向队列尾部 指向队列尾的数据(就是队列的最后一个数据)
        }

        //判断队列是否满
        public boolean isFull() {
            return rear == maxSize - 1;
        }
        //判断队列是否为空
        public boolean isEmpty(){
            return rear==front;
        }

        //添加队列到数据
        public void addQueue(int n){
            //判断队列是否满
            if (isFull()){
                System.out.println("队列满了，不能加入数据");
                return;
            }
            rear++;//让rear后移动
            arr[rear]=n;
        }
        //获取队列的值 出队列
        public int getQueue(){
            //判断队列是否为空
            if (isEmpty()){
                //抛出异常
                throw new RuntimeException("队列空,不能取数据");
            }
            front++;//让front 后移
            return arr[front];
        }
        //显示队列的所有数据
        public void show(){
            //遍历
            if (isEmpty()){
                System.out.println("队列为空 没有数据----");
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        //显示队列的头数据 注意不是取数据
        public int headQueue(){
            if (isEmpty()){
                System.out.println("队列为空 没有数据--");
                throw new RuntimeException("队列空,不能取数据");
            }
            return arr[front+1];
        }
    }
}
