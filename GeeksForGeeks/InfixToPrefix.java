import java.util.*;
class InfixToPrefix {
    public String infixToPrefix(String exp) {
        Stack<Character> st = new Stack<Character>();
        StringBuffer res = new StringBuffer("");
        for(char c: exp.toCharArray()) {
            //check for delimiter
            if(c == ' ' || c == ',')
                continue;

            if(isOperator(c)) {
                while(!st.isEmpty() && st.peek() != '(' && hasLowerPrecedence(c, st.peek()) ) {
                    res.append(st.pop());
                }
                st.push(c);
            } else if(isOperand(c)) {
                res.append(c);
            } else if(c == '(') {
                st.push(c);
            } else if(c == ')') {
                while(!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            }
        }

        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }

    private boolean isOperand(char c) {
        if(c >= 'a' && c <= 'z') return true;
        if(c >= 'A' && c <= 'Z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
    private boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/' ) {
            return true;
        }
        return false;
    }

    private boolean hasLowerPrecedence(char a, char b) {
        int aP = getPrecedence(a);
        int bP = getPrecedence(b);
        return aP <= bP;
    }

    private int getPrecedence(char a) {
        switch(a) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        InfixToPrefix ob = new InfixToPrefix();
        String infixExp = "a+b+c*d";
        String postfixExp = ob.infixToPrefix(infixExp);
        System.out.println(infixExp);
        System.out.println(postfixExp);
    }
}