public class LinguistProject {

    private BST [] alphabet = new BST [26];
    
    //The inner node class
    private class Noad {
        private int frequency;
        private char letter;
        private Noad left, right;
        public Noad(char c, int f) {
            this.letter = c;
            this.frequency = f;
            this.left = this.right = null;
        }// end of constructor
    }// end of inner class
    //

    public class BST {

        private Noad root;

        public BST() {
            root = null;
        }// end of constructor

        private Noad search(char c){
            if (this.root == null) {
                System.out.println("Empty tree");
                return null;
            }
            return search(this.root, c);
        }
        private Noad search(Noad node, char c) {
            if (node.letter == c) {
                return node;
            }
            if (node.left != null) {
                return search(node.left, c);
            }
            if (node.right != null) {
                return search(node.right, c);
            }
            return null;
        }// end of search(x)

        public void insert(char c, int f) {
            this.root = insert(this.root, c, f);
        }
        private Noad insert(Noad node, char c, int f) {
            if (node == null) {
                return new Noad(c, f);
            }
            if (node.left != null) {
                node.right = insert(node.right, c, f);
            } else {
                node.left = insert(node.left, c, f);
            }
            return node;
        }// end of insert(x)

        private void visit(Noad node) {
            int f = node.frequency;
            char c = node.letter;
            System.out.println(c + " : " + f);
        }
        private void inorder(Noad node) {
            if (node != null) {
                inorder(node.left);
                visit(node);
                inorder(node.right);
            }
        }

    }// end of inner class

    // The evaluation method that takes an input string, and distributes letters throughout the array of Binary Search Trees
    public void evaluate(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            char c = str.charAt(i + 1);
            if (Character.isLetter(ch) && Character.isLetter(c)) {
                int index = Character.getNumericValue(ch) - 10;
                BST tree = alphabet[index];
                if ((tree != null) && (tree.search(c) != null)) {
                    tree.search(c).frequency += 1;
                } else {
                    try {
                        alphabet[index].insert(c, 1);
                    } catch (NullPointerException ex) {
                        alphabet[index] = new BST();
                        alphabet[index].insert(c, 1);
                    }
                }
            }// end of (if ch NOT null)
        }// end of for
    }// end of evaluate(x)

    public void getFrequencies(char key) {
        int index = Character.getNumericValue(key) - 10;
        BST tree = alphabet[index];
        if (tree == null) {
            System.out.println("Sorry, no letters follow this character");
            return;
        }
        System.out.println("Letters following " + key + ":" );
        tree.inorder(tree.root);
    }
}// end of class