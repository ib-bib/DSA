public class MuhLinkedList {
    
    private Noad head, tail;
    private long size;
    
    private class Noad {
        private int info;
        private Noad next;

        public Noad(int data) {
            info = data;
            next = null;// notice how this makes this node a tail node
        }// node constructor

    }// end of custom node class

    public void addLast(int item) {
        if (isEmpty()) {
            head = tail = new Noad(item);
        } else {
            tail.next = new Noad(item);
            tail = tail.next;
        }
        size++;
    }// end of addLast method

    public void addFirst(int item){
        if (isEmpty()) {
            head = tail = new Noad(item);
        } else {
            Noad temp = new Noad(item);
            temp.next = head;
            head = temp;
        }
        size++;
    }// end of addFirst method

    public void addBefore(int find, int item) {
        Noad current = head;
        Noad previous = null;
        int cur = current.info;
        while (cur != find && current.next != null) {
            previous = current;
            current = current.next;
            cur = current.info;
        }
        if (previous == null) {
            addFirst(item);
        } else {
            Noad node = new Noad(item);
            node.next = current;
            previous.next = node;
        }
    }// end of addBefore method

    public void addAfter(int find, int item){
        Noad current = head;
        Noad next = current.next;
        int cur = current.info;
        while (cur != find && next != null) {
            current = current.next;
            next = current.next;
            cur = current.info;
        }
        if (current == head) {
            addFirst(item);
        } else {
            Noad node = new Noad(item);
            node.next = next;
            current.next = node;
        }
    }// end of addAfterElement method

    public Noad deleteFirst() {
        Noad temp = new Noad(head.info);
        head = head.next;
        return temp;
    }// end of deleteFirst method

    public Noad deleteLast() {
        Noad current = head;
        Noad previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            current = deleteFirst();
        } else {
            previous.next = null;
        }
        return current;
    }// end of deleteLast method

    public String deleteBefore(int find) {
        Noad current = head;
        Noad previous = null;
        int pointer = current.next.info;
        while (pointer != find && current != tail) {
            previous = current;
            current = current.next;
            pointer = current.next.info;
        }
        if (current.next == tail && pointer != find) {
            return "Value not found";
        } else {
            previous.next = current.next;
            current.next = null;
        }
        return "Removed value was: "+ String.valueOf(current.info);
    }// end of deleteBefore method

    public String deleteAfter(int find) {
        if (isEmpty()) {
            return "List is empty";
        }
        Noad cur = head;
        Noad prev = null;
        while (cur.next != null && cur.info != find) {
            prev = cur;
            cur = cur.next;
        }
        if (cur.next == null && cur.info != find) {
            return "Value not found, nothing was removed";
        }
        prev = cur;
        cur = cur.next;
        prev.next = cur.next;
        cur.next = null;
        return "Removed value was: " + cur.info;
    }// end of deleteAdfter

    public String removeNode(int find) {
        if (isEmpty()) {
            return "List is empty";
        }
        Noad cur = head;
        Noad prev = null;
        while (cur.next != null && cur.info != find) {
            prev = cur;
            cur = cur.next;
        }
        if (cur.next == null && cur.info != find) {
            return "Value not found, nothing was removed";
        } else if (cur.info == find) {
            prev.next = cur.next;
            return "Value " + cur.info + " was found, and removed";
        } else {
            prev.next = cur.next;
            cur.next = null;
        }
        return "Value " + cur.info + " was found, and removed";
    }

    public void insertAtMiddle(int info) {

    }

    public void makeListEmpty() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0) || (head == null);
    }

    public boolean isFull() {
        return this.size == Long.MAX_VALUE;
    }

    public int getHead() {
        return head.info;
    }

    public int getTail() {
        return tail.info;
    }

    public long getNodeCount() {
        return size;
    }

    public String getListData() {
        String deets = "";
        while(head != null) {
            int x = deleteFirst().info;
            deets += x + " ";
        }
        return deets;
    }// end of getList method

    public String getListDataReversed() {
        String deets = "";
        while (head != null) {
            int x = deleteLast().info;
            deets += String.valueOf(x) + " ";
        }
        return deets;
    }// end of getList reversed

    public String recursiveGetListData() {
        String deets = "";
        if (head != null) {
            int x = deleteFirst().info;
            deets += String.valueOf(x) + " ";
            return deets += recursiveGetListData();
        }
        return deets;
    }// end of recursive getList

    public String recursiveReverseGetListData() {
        String deets = "";
        if (head != null) {
            int x = deleteLast().info;
            deets += String.valueOf(x) + " ";
            return deets += recursiveReverseGetListData();
        }
        return deets;
    }// end of recursive getList reversed


    //The below section is for the first project submission


    private String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i > -1; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }// custom string reverse method

    private String fillWithZeros(String str, int margin) {
        int start = str.length() - 1;
        int end = start + margin;
        for (int i = start; i < end; i++) {
            str += "0";
        }
        return str;
    }// end of fillWithZeros method

    public MuhLinkedList addTwoGiants(String x, String y) {
        String xLong = reverseString(x);
        String yLong = reverseString(y);
        int len = xLong.length();
        int carry = 0;

        if (len > yLong.length()) {
            int diff = len - yLong.length();
            yLong = fillWithZeros(yLong, diff);
        }

        for (int i = 0; i < len; i++) {
            char c1 = xLong.charAt(i);
            int num1 = Character.getNumericValue(c1);
            char c2 = yLong.charAt(i);
            int num2 = Character.getNumericValue(c2);
            int sum = num1 + num2 + carry;

            this.addFirst(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            this.addFirst(carry);
        }

        return this;
    }// end of addTwoGiants method
}// end of class
