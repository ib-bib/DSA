public class InfixPostFix {

    private static int getOperandPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static char charifyObject (Object o) {
        return o.toString().charAt(0);
    }

    private static int intifyObject (Object o) {
        return Integer.parseInt(o.toString());
    }

    public static String convert(String exp) {

        MuhStack st = new MuhStack(exp.length());
        String post = "";
        
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                post += c;
            }
            else if (c == '(') {
                st.push(c);
            }
            else if ( c == ')') {
                while(!st.isEmpty() &&
                charifyObject(st.peek()) != '(') {
                    post += st.pop();
                }
                st.pop();
            }
            else {
                while(!st.isEmpty() 
                && getOperandPrecedence(c) <= getOperandPrecedence(charifyObject(st.peek()))) {
                    post += st.pop();
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            if (charifyObject(st.peek()) == '(') {
                return "Invalid expression";
            }
            post += st.pop();
        }
        return post;
    }// end of convert method

    private static int operate(int x, int y, char o) {
        switch (o) {
            case '+':
                return y + x;
            case '-':
                return y - x;
            case '*':
                return y * x;
            case '/':
                return y / x;
            case '^':
                return (int) Math.pow(y, x);
        }
        return -1;
    }

    public static int calculate(String postExp) {

        MuhStack st = new MuhStack(postExp.length());
        
        for (int i = 0; i < postExp.length(); i++) {
            char current = postExp.charAt(i);
            if (Character.isDigit(current)) {
                int item = Character.getNumericValue(current);
                st.push(item);
            } else {
                if (!st.isEmpty()) {
                    int op1 = intifyObject(st.pop());
                    int op2 = intifyObject(st.pop());
                    st.push(operate(op1, op2, current));
                }
            }
        }
        return intifyObject(st.pop());
    }
} // end of class