public class BinaryTree {

    private Noad root;
    
    private class Noad {
        private int data;
        private Noad leftChild, rightChild;
        public Noad(int data) {
            this.data = data;
            this.leftChild = this.rightChild = null;
        }// end of constrcutor
        public boolean isLeaf() {
            return (this.leftChild == null) && (this.rightChild == null);
        }
    }// end of Noad class

    public void makeTreeEmpty() {
        this.root = null;
    }// empty the tree

    public boolean isEmpty() {
        return this.root == null;
    }// check if tree is empty

    public void getRoot() {
        if (this.isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println(this.root.data);
    }// get the value of the root

    public void getHeight() {
        if (this.isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println(getHeight(this.root));
    }
    private int getHeight(Noad node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
    }// getHeight()


    public void search(int find) {
        if (this.isEmpty()) {
            System.out.println("Tree is empty, no nodes to find");
            return;
        }
        Noad node = searchTree(this.root, find);
        if (node == null) {
            System.out.println("Sorry, node " + find + " was not found");
        } else {
            System.out.println("Node " + find + " was found!");
        }
    }
    private Noad searchTree(Noad node, int find) {
        if (node == null) {
            return null;
        }
        if (node.data == find) {
            return node;
        }
        if (node.data > find) {
            return searchTree(node.leftChild, find);
        }
        if (node.data < find) {
            return searchTree(node.rightChild, find);
        }
        return null;
    }// search(x)


    public void insert(int data) {
        this.root = insert(this.root, data);
    }
    private Noad insert(Noad node, int data) {
        if (node == null) {
            return new Noad(data);
        }
        if (data < node.data) {
            node.leftChild = insert(node.leftChild, data);
        } else {
            node.rightChild = insert(node.rightChild, data);
        }
        return node;
    }// end of insert(x)

    
    public void delete(int find) {
        deleteNode(this.root, find);
    }
    private Noad deleteNode(Noad node, int find) {
        if (node == null) {
            return null;
        }
        if (find < node.data) {
            node.leftChild = deleteNode(node.leftChild, find);
        }
        else if (find > node.data) {
            node.rightChild = deleteNode(node.rightChild, find);
        } else {
            if (node.isLeaf()) {
                node = null;
            }
            else if (node.rightChild == null) {
                node = node.leftChild;
            }
            else if (node.leftChild == null) {
                node = node.rightChild;
            } else {
                Noad temp = findMin(node.rightChild);
                node.data = temp.data;
                node.rightChild = deleteNode(node.rightChild, temp.data);
            }
        }
        return node;
    }// deleteNode(x)


    public void getMin() {
        if (isEmpty()) {
            System.out.println("Sorry, tree is empty");
            return;
        }
        System.out.println(findMin(this.root).data);
    }
    private Noad findMin(Noad node) {
        Noad current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }// getMin()

    public int recGetMin() {
        return recFindMin(this.root).data;
    }
    private Noad recFindMin(Noad node) {
        if (node == null) {
            return null;
        }
        if (node.leftChild == null) {
            return node;
        }
        return recFindMin(node.leftChild);
    }// recursive version of getMin()


    public void getMax() {
        if (isEmpty()) {
            System.out.println("Sorry, tree is empty");
            return;
        }
        System.out.println(findMax(this.root).data);
    }
    private Noad findMax(Noad node) {
        Noad current = node;
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }// getMax()

    public void recGetMax() {
        if (isEmpty()) {
            System.out.println("Sorry, tree is empty");
            return;
        }
        System.out.println(recFindMax(this.root).data);
    }
    private Noad recFindMax(Noad node) {
        if (node == null) {
            return null;
        }
        if (node.rightChild == null) {
            return node;
        }
        return recFindMax(node.rightChild);
    }// recursive getMax()


    public void getSuccessor(int find) {
        System.out.println(getSuccessor(this.root, find));
    }
    private int getSuccessor(Noad node, int find) {
        Noad current = searchTree(node, find);
        if (current == null) {
            return -1;
        }
        if (current.rightChild != null) {
            return findMin(current.rightChild).data;
        }
        Noad successor = null;
        Noad ancestor = node;
        while (ancestor != current) {
            if (current.data < ancestor.data) {
                successor = ancestor;
                ancestor = ancestor.leftChild;
            } else {
                ancestor = ancestor.rightChild;
            }
        }
        return successor.data;
    }// end of getSuccessor(x)


    private void visit(Noad node) {
        System.out.print(node.data + " ");
    }

    public void preOrder() {
        preorder(this.root);
        System.out.println("");
    }

    public void inOrder() {
        inorder(this.root);
        System.out.println("");
    }

    public void postOrder() {
        postorder(this.root);
        System.out.println("");
    }

    private void preorder(Noad node) {
        if (node != null) {
            visit(node);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }// end of preorder traversal

    private void postorder(Noad node) {
        if (node != null) {
            postorder(node.leftChild);
            postorder(node.rightChild);
            visit(node);
        }
    }// end of postorder traversal

    private void inorder(Noad node) {
        if (node != null) {
            inorder(node.leftChild);
            visit(node);
            inorder(node.rightChild);
        }
    }// end of inorder traversal


    public void printLeaves() {
        printLeaves(this.root);
    }
    private void printLeaves(Noad node) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            visit(node);
        }
        if (node.leftChild != null) {
            printLeaves(node.leftChild);
        }
        if (node.rightChild != null) {
            printLeaves(node.rightChild);
        }
    }//printLeaves()

}// end of Tree class