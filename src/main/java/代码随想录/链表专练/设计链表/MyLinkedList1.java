package 代码随想录.链表专练.设计链表;

public class MyLinkedList1 {
    private MyLinkedList1 next;
    private int val;

    public static void main(String[] args) {
        MyLinkedList1 list = new MyLinkedList1();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        int i = list.get(4);
        System.out.println(i);

    }
    public MyLinkedList1() {

    }
    //5,4,6,0,1,7,4
    public int get(int index) {
        if(index<0)
            return -1;
        MyLinkedList1 node=this;
        while(node!=null&&index!=0){
            node=node.next;
            index--;
        }
        if(index!=0)
            return -1;
        return node.val;
    }

    public void addAtHead(int val) {
        //找到要插入节点的前驱
        MyLinkedList1 pred = this;
        /*for (int i = 0; i < 0; i++) {
            pred = pred.next;
        }*/
        MyLinkedList1 toAdd = new MyLinkedList1();
        toAdd.val=val;
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void addAtTail(int val) {
        MyLinkedList1 node=this;
        while(node.next!=null){
            node=node.next;
        }
        MyLinkedList1 list = new MyLinkedList1();
        list.val=val;
        node.next=list;
    }

    public void addAtIndex(int index, int val) {
        MyLinkedList1 list = new MyLinkedList1();
        list.val=val;
        MyLinkedList1 node=this;
        if(index<=0){
            //在首部添加
            this.val=val;
            this.next=node;
        }
        while(node.next!=null&&index!=1){
            node=node.next;
            index--;
        }
        if(index!=1){
            //在尾部添加
            node.next=list;
        }else{
            //在中间添加
            MyLinkedList1 node2=node.next;
            node.next=list;
            list.next=node2;
        }
    }

    public void deleteAtIndex(int index) {
        MyLinkedList1 node=this;
        if(index==0){
            if(node.next==null){

            }else{
                this.val=node.next.val;
                this.next=node.next.next;
            }

        }
        if(index>0){
            while(node.next!=null&&index!=1){
                node=node.next;
                index--;
            }
            if(index!=1){
                //无效
            }else{
                if(node.next!=null) {
                    node.next = node.next.next;
                }
            }
        }
    }
}
