public class MuhQueue {

    private int [] data;
    private int front;
    private int rear;
    private int capacity;

    public MuhQueue(int size){
        capacity = size;
        data = new int[capacity];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (rear == -1 && front == -1) || (rear < front);
    }
    
    public boolean isFull() {
        return rear == data.length - 1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Sorry, queue is empty");
            return 0;
        }
        return data[front];
    }

    public void enQueue(int item) {
        if (front == -1) {
            front = 0;
        }
        if (rear == capacity) {
            System.out.println("Queue is full");
            return;
        } else {
            rear+=1;
            data[rear] = item;
            return;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
        }
        int item = data[front];
        front += 1;
        if (front > rear) {
            front = rear = -1;
        }
        return item;
    }

    public void popItem(int n) {
        MuhQueue q = new MuhQueue(this.capacity);
        while(!isEmpty()) {
            if (n == this.peek()) {
                this.deQueue();
            } else {
                q.enQueue(this.deQueue());
            }
        }
        this.front = q.front;
        this.rear = q.rear;
        this.data = q.data;
    }

    public void emptyQueue() {
        front = -1;
        rear = -1;
    }

    public void appendQueue(MuhQueue mq) {
        while(!this.isFull() && !mq.isEmpty()) {
            this.enQueue(mq.deQueue());
        }
        if (!mq.isEmpty()) {
            System.out.printf("\nQueue is full\n");
            return;
        }
    }

    public void recursiveAppendQueue(MuhQueue mq) {
        if (!mq.isEmpty()) {
            if (mq.isFull()) {
                System.out.printf("\nQueue is full\n");
                return;
            }
            else {
                int item = mq.deQueue();
                this.enQueue(item);
                this.recursiveAppendQueue(mq);
            }
        }
    }

    public int sumQueue() {
        int sum = 0;
        MuhQueue queue = new MuhQueue(this.capacity);
        while(!this.isEmpty()) {
            int x = this.deQueue();
            sum += x;
            queue.enQueue(x);
        }
        this.rear = queue.rear;
        this.front = queue.front;
        this.data = queue.data;
        return sum;
    }

    public int addFrontToRear() {
        int sum = data[rear] + data[front];
        return sum;
    }

    public void printQueue() {
        if(!this.isEmpty()) {
            System.out.println(this.deQueue());
            printQueue();
        }
    }

    public void reversePrintQueue() {
        if(!this.isEmpty()) {
            int x = this.deQueue();
            reversePrintQueue();
            System.out.println(x);
        }
    }

    public int howManyInQueue() {
        return howManyInQueueCounter(1);
    }

    private int howManyInQueueCounter(int x) {
        if (this.isEmpty()) {
           return 0;
        }
        if (rear != front) {  
            rear--;
            x++;
            return howManyInQueueCounter(x);
        }
        return x;
    }
    
} // end of class
