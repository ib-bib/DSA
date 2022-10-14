
public class MuhStack {

    private int top;
    private int maxSize;
    private Object [] stackArr;

    public MuhStack(int size) {
        this.top = -1;
        this.maxSize = size;
        this.stackArr = new Object[size];
    }

    public boolean isFull() {
        return this.top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(Object ob) {
        if (!isFull()) {
            this.stackArr[++top] = ob; 
        } else {
            System.out.println("You cannot push further");
        }
    }

    public Object pop() {
        return !isEmpty() ? this.stackArr[top--] : null;
    }

    public Object peek() {
        return !isEmpty() ? this.stackArr[top] : null;
    }

    private Object hexAnalysis(int x) {
        switch (x) {
            case 10:
                return 'A';
            case 11:
                return 'B';
            case 12:
                return 'C';
            case 13:
                return 'D';
            case 14:
                return 'E';
            case 15:
                return 'F';
            default:
                return x;
        }
    }

    public MuhStack hexConvert(int x) {
        while (x > 0) {
            int val = x % 16;
            this.push(hexAnalysis(val));
            x /= 16;
        }
        return this;
    }

    public MuhStack octalConvert(int x) {
        while (x > 0) {
            int remainder = x % 8;
            this.push(remainder);
            x /= 8;
        }
        return this;
    }

    public MuhStack binaryConvert(int x) {
        while (x > 0) {
            int remainder = x % 2;
            this.push(remainder);
            x /= 2;
        }
        return this;
    }

    public MuhStack reverseString(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            this.push(str.charAt(i));
        }
        return this;
    }// end of reverseString(x)

    public void printStack() {
        if (!isEmpty()) {
            System.out.println(this.pop());
            printStack();
        }
    }

    public void reversePrintStack() {
        if (!isEmpty()) {
            Object popped = this.pop();
            reversePrintStack();
            System.out.println(popped);
            this.push(popped);
        }
    }

    public void assignStackTop(MuhStack st, Object e) { // retreive stack
        e = st.pop();
        st.push(e);
    }// I don't know what the point of this function is

    public void makeStackEmpty() {
        stackArr = null;
        top = -1;
    }

    public void addTopTwo() {
        if (!isEmpty()) {
            try {
            double x = Double.parseDouble(this.pop().toString());
            double y = Double.parseDouble(this.pop().toString());
            this.push(x + y);
            } catch (NumberFormatException eg) {
                System.out.println(eg.getCause());
            }
        }
    }

    public void deleteFromStack(Object e) {
        MuhStack st = new MuhStack(this.maxSize);
        while (!isEmpty()) {
            if (e == this.peek() || e.equals(this.peek())) {
                this.pop();
            } else {
                Object x = this.pop();
                st.push(x);
            }
        }// end of while loop
        this.top = st.top;
        this.stackArr = st.stackArr;
    }// end of deleteFromStack(x)

    public void recDel(MuhStack st, Object e) {
        
    }
    
} // end of class