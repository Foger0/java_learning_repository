public class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode tail;

    public void display(){
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            throw new IndexWrongFulException("index位置不合法！");
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
       ListNode cur = findIndexListNode(index);
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    private ListNode findIndexListNode(int index) {
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void remove(int key){
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }else {
                        tail = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.tail = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }
    public void removeAllKey(int key){
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }else {
                        tail = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    }else {
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public void clear(){
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        tail = null;
    }
}