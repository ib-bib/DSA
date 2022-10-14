public class MuhCircularQueue {

    private int front;
    private int rear;
    private int [] data;
    private int counter;
    private int max;

    public MuhCircularQueue(int size) {
        this.data = new int[size];
        this.front = -1;
        this.rear = -1;
        this.counter = 0;
        this.max = size;
    }

    public void emptyQueue() {
        this.rear = -1;
        this.front = -1;
        this.counter = 0;
    }

    public boolean isEmpty() {
        return this.counter == 0;
    }

    public boolean isFull() {
        return this.counter == this.max;
    }

    public void enQueue(int item) {
        if (isFull()) {
            System.out.println("Sorry, queue is full. Cannot insert any item");
            return;
        }
        if (this.front == -1) {
            this.front = 0;
        }
        this.rear = (this.rear + 1) % this.max;
        this.data[this.rear] = item;
        this.counter++;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.print("Sorry, queue, is empty");
            return 0;
        }
        int item = this.data[this.front];
        this.front = (this.front + 1) % this.max;
        this.counter--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Sorry, the queue is empty");
            return 0;
        }
        return this.data[front];
    }

    public void popItem(int n) {
        MuhCircularQueue q = new MuhCircularQueue(this.max);
        while (!isEmpty()) {
            if (this.peek() == n) {
                deQueue();
            } else {
                q.enQueue(deQueue());
            }
        }
        this.front = q.front;
        this.rear = q.rear;
        this.counter = q.counter;
        this.max = q.max;
        this.data = q.data;
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.println(deQueue());
            printQueue();
        }
    }

    public void reversePrintQueue() {
        if (!isEmpty()) {
            int x = deQueue();
            reversePrintQueue();
            System.out.println(x);
        }
    }
    
}// end of class
