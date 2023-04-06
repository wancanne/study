package com.example.dataStructure.sparsearray;

import java.util.Scanner;

/**
 * @author wc
 * @date 2023/2/21 13:49
 * desc   Stay hungry, stay foolish
 **/
public class CircleArrayQueue {

    public static void main(String[] args) {
        //测试
        System.out.println("测试数组模拟环形队列-----");
        //
        CircleArray queue = new CircleArray(4);//设置4 队列的有效数据是4-1
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g'://取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
            System.out.println("程序退出-----");
        }
    }

    //思路如下
    //1.front变量的含义做一个调整: front就指向队列的第一个元素,也就是说arrfront] 就是队列的第一个元素front的初始值=0
    // 2.rear变量的含义做一个调整:rear指向队列的最后一个元素的后一个位置因为希望空出一个空间做为约定rear的初始值=0
    //3.当队列满时，条件是(rear +1) %maxSize=front[满]
    //4.对队列为空的条件，rear== front空5.当我们这样分析，队列中有效的数据的个数 (rear+ maxSize-front)%maxSize //rear= 1front=06.
    // 我们就可以在原来的队列上修改得到，一个环形队列
   static class CircleArray {
        private int maxSize;//表示数组的最大容量
        private int front;//指向队列的第一个位置
        private int rear;//指向队列最后一个元素的下一个位置
        private int[] arr;//该数组用于存放数据 模拟队列

        //构造器
        public CircleArray(int arrMaxSize) {
            maxSize = arrMaxSize;
            arr = new int[maxSize];
            front = 0;//默认为0
            rear = 0;//默认为0
        }

        //判断队列是否满
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return rear == front;
        }

        //添加队列到数据
        public void addQueue(int n) {
            //判断队列是否满
            if (isFull()) {
                System.out.println("队列满了，不能加入数据");
                return;
            }
            //自己将数据加入就可以
            arr[rear] = n;
            rear = (rear + 1) % maxSize;//将rear后移 必须考虑取模
        }

        //获取队列的值 出队列
        public int getQueue() {
            //判断队列是否为空
            if (isEmpty()) {
                //抛出异常
                throw new RuntimeException("队列空,不能取数据");
            }
            //这里需要分析出front是指向队列的第一个元素
            //1.先把front的值保存到一个临时变量
            //2.将front后移
            //3.返回临时保存的变量
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        //显示队列的所有数据
        public void show() {
            //遍历
            if (isEmpty()) {
                System.out.println("队列为空 没有数据----");
            }
            //思路:从front开始遍历 遍历多少个元素
            for (int i = front; i < front + getSize(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        //求出当前数列有效数据的个数
        public int getSize() {
            return (rear + maxSize - front) % maxSize;
        }

        //显示队列的头数据 注意不是取数据
        public int headQueue() {
            if (isEmpty()) {
                System.out.println("队列为空 没有数据--");
                throw new RuntimeException("队列空,不能取数据");
            }
            return arr[front];
        }
    }
}
