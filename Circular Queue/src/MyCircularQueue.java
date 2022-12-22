class MyCircularQueue {
     int[] n;
     int front;
     int rear;
    public MyCircularQueue(int k) {
      n=new int[k+1];
      front=0;
      rear=0;
    }
    
    public boolean enQueue(int value) {
       if((rear+1)%n.length!=front){
        n[rear]=value;
        rear=(rear+1)%n.length;
        return true;
    }
    return false;
    }
    
    public boolean deQueue() {
       if(front!=rear){
       int ret=n[front];
       front=(front+1)%n.length;
       return true;
       }
       return false;
    }
    
    public int Front() {
      return n[front];
    }
    
    public int Rear() {
      return n[rear];
    }
    
    public boolean isEmpty() {
      if(front==rear){
          return true;
      }
      return false;
    }
    
    public boolean isFull() {
       if(rear+1==front){
           return true;
       }
       return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */