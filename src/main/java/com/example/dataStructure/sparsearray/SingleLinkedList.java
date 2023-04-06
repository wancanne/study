package com.example.dataStructure.sparsearray;

/**
 * @author wc
 * @date 2023/2/21 15:23
 * desc   Stay hungry, stay foolish
 **/
public class SingleLinkedList {

    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode22 = new HeroNode(2, "小鹿", "火凤凰---");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //创建一个链表
        HeroNode.singleListedList singleLinkedList = new HeroNode.singleListedList();
        //加入
        singleLinkedList.addZetNode(heroNode3);
        singleLinkedList.addZetNode(heroNode1);
        singleLinkedList.addZetNode(heroNode4);
        singleLinkedList.addZetNode(heroNode4);
        singleLinkedList.addZetNode(heroNode2);

        System.out.println("个数为:"+getLength(singleLinkedList.getHead()));
        System.out.println("修改前----------");
        singleLinkedList.list();
//        singleLinkedList.update(heroNode22);
//        System.out.println("修改后----------");
//        singleLinkedList.list();
//        singleLinkedList.delete(heroNode2);
//        singleLinkedList.delete(heroNode1);
//        singleLinkedList.delete(heroNode4);
//        singleLinkedList.delete(heroNode3);
//        System.out.println("删除后----------");
//        singleLinkedList.list();

        //测试是否得到倒数第K个节点

        HeroNode res=findLastIndexNode(singleLinkedList.getHead(),5);

        System.out.println("res====="+res);
    }
    //方法:获取到单链表节点的个数(如果是带头节点的链表,需求不统计头节点)

    /**
     * @param head 链表的投节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {//空链表
            return 0;
        }
        int length = 0;
        //定义辅助变量
        HeroNode cur = head.next;
//        while (true) {
//            length++;
//            if (cur == null) {
//                break;
//            }
//            cur = cur.next;
//        }
        while (cur != null) {
            length++;
            cur=cur.next;
        }
        return length;
    }
    //查找单链表中的倒序第K个节点(新浪面试)
    //思路:找到链表长度 l l<k 返回null l>=k 返回第l-k+1个节点
    //还有个头节点怎么处理

    //编写方法 接收head节点 同时接收一个index
    //2.index 表示是倒数index个节点
    //3.先把链表从头到尾遍历 得到长度s 从第一个遍历 返回s-index个
    //4.得到size后 我们从链表的第一个开始遍历 s-index个
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        //第一次遍历
        int size=getLength(head);
        //第二次遍历
        if (size<index || index<=0){
            return null;
        }
        HeroNode current=head.next;
        for (int i=0;i<size-index;i++){
            current=current.next;
            if (current==null){
                return null;
            }
        }
    return current;
    }


    static class HeroNode {
        public int no;
        public String name;
        public String nickName;
        public HeroNode next;//指向下一个节点

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        //定义一个singlelist来管理我们的英雄
        static class singleListedList {
            //初始化一个头结点 头结点不要动 不存放具体的数据
            private HeroNode head = new HeroNode(0, "", "");
            //添加节点到单向链表
            //思路:当不考虑编号顺序时候
            //1.找到当前链表的最后节点
            //2.将最后这个节点的next 指向新的节点
            public HeroNode getHead(){
                return head;
            }
            public void addNode(HeroNode heroNode) {
                HeroNode temp = head;
                //遍历链表 找到最后
                while (true) {
                    //找到链表的最后
                    if (temp.next == null) {
                        break;
                    }
                    //如果没有找到最后 就将temp后移
                    temp = temp.next;
                }
                //当退出while循环时候,temp就指向了链表的最后
                //当最后这个节点的next 指向新的节点
                temp.next = heroNode;
            }

            public void addZetNode(HeroNode heroNode) {
                //因为头节点不能动 因此我们仍然通过一个辅助指针来帮助找到添加的位置
                //因为单链表 所以我们找的temp是位于添加节点位置前一个节点  否则插入不了
                HeroNode temp = head;
                boolean flag = false;//添加的编号是否存在 默认为false
                while (true) {
                    if (temp.next == null) {//说明temp已经在链表的最后
                        break;
                    }
                    if (temp.next.no > heroNode.no) {//位置找到了 就在temp的后面插入

                        break;
                    } else if (temp.next.no == heroNode.no) {
                        //说明编号已经存在
                        flag = true;
                        break;
                    }
                    temp = temp.next;//后移 遍历当前链表
                }
                if (flag) {
                    //不能添加 编号存在
                    System.out.printf("准备插入的英雄的编号已经 %d 存在,不能加入\n", heroNode.no);
                } else {
                    //插入到链表 temp的后面
                    heroNode.next = temp.next;
                    temp.next = heroNode;
                }
            }

            /**
             * 修改节点的信息 根据no编号来修改 即no编号不能改
             */
            //说明 1.根据newHeroNode的 no来修改即可
            public void update(HeroNode newHeroNode) {
                //判断是否为空
                if (head.next == null) {
                    System.out.println("链表为空--");
                    return;
                }
                //找到需要修改的节点 根据no编号
                //定义辅助变量
                HeroNode temp = head.next;
                boolean flag = false;//表示是否找到该节点
                while (true) {
                    if (temp == null) {
                        break;
                    }
                    if (temp.no == newHeroNode.no) {
                        //找到
                        flag = true;
                        break;
                    }
                    temp = temp.next;
                }
                if (flag) {
                    temp.name = newHeroNode.name;
                    temp.nickName = newHeroNode.nickName;
                } else {//没有找到
                    System.out.print("没有找到编号%d 的节点,不能修改\n" + newHeroNode.no);
                }
            }

            public void delete(HeroNode delHeroNode) {
                //判断是否为空
                if (head.next == null) {
                    System.out.println("链表为空--");
                    return;
                }
                HeroNode temp = head;
                boolean flag = false;
                while (true) {
                    if (temp.next == null) {
                        break;
                    }
                    if (temp.next.no == delHeroNode.no) {
                        //找到
                        flag = true;
                        break;
                    }
                    temp = temp.next;
                }
                if (flag) {
                    temp.next = temp.next.next;
                } else {//没有找到
                    System.out.print("没有找到编号%d 的节点,不能修改\n" + delHeroNode.no);
                }
            }

            //显示链表 遍历
            public void list() {
                //辅助变量
                //判断链表是否为空
                if (head.next == null) {
                    System.out.println("链表不能为空");
                    return;
                }
                //因为头节点 不能动 因此我们需要一个辅助变量来遍历
                HeroNode temp = head.next;
                while (true) {
                    //判断是否到链表最后
                    if (temp == null) {
                        break;
                    }
                    //输出节点的信息
                    System.out.println(temp);
                    //将temp后移 一定后移
                    temp = temp.next;
                }
            }

        }


        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }
}
