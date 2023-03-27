package com.tzuxin.datastructures.stack;

import sun.misc.Queue;

import java.util.Stack;

/**
 * 生成后缀表达式
 */
public class PolandNotation {

    Stack<Character> s1;
    Stack<Character> s2;
    String example = "";

    public PolandNotation(String example) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        this.example = example;
    }

    public Float getResult() {
        int index = 0;
        for (int i = 0; i < example.length(); i++) {
            char now = example.charAt(i);
            // 如果是最后一个
            if (i == example.length() - 1) {
                s2.push(now);
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
                break;
            }
            // 如果取到了符号
            if (isOper(now)) {
                // 1、如果s1是空或者栈顶是"("则直接把符号压入s1
                // 2、优先级大于栈顶，也压入栈
                while (true) {
                    if (s1.empty()) {
                        s1.push(now);
                        break;
                    }else {
                        Character pop = s1.pop();
                        s1.push(pop);
                        if (isLeft(pop) || priority(now) > priority(pop)){
                            s1.push(now);
                            break;
                        }else {
                            s2.push(s1.pop());
                        }
                    }
                }
            }else if(isLeft(now)){
                s1.push(now);
            } else if (isRight(now)) {
                while (!s1.empty()){
                    Character pop1 = this.s1.pop();
                    if (pop1 == '('){
                        break;
                    }
                    s2.push(pop1);
                }
            } else {
                s2.push(now);
            }
        }
        revertStack(s2);
        return null;
    }
    public void revertStack(Stack<Character> stack){
        Stack<Character> stackNew = new Stack<>();
        while (!stack.empty())
        {
            stackNew.push(stack.pop());
        }
        while (!stackNew.empty()){
            System.out.print(stackNew.pop() + " ");
        }
    }

    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char c) {
        return c == '*' || c == '/' || c == '+' || c == '-';
    }

    public boolean isLeft(char c) {
        return '(' == c;
    }

    public boolean isRight(char c) {
        return ')' == c;
    }

    public static void main(String[] args) {
        // 1+((2+3)x4)-5
        // 1 2 3 + 4 * + 5 -
        PolandNotation polandNotation = new PolandNotation("1+((2+3)*4)-5");
        polandNotation.getResult();
    }
}
