package com.tzuxin.datastructures.stack;

import java.util.Stack;

/**
 * 栈实现计算器
 */
public class Calculator {
    Stack<Float> numStack;
    Stack<Character> operStack;
    String example = "";

    /**
     * 构造函数
     * @param example 算式字符串
     */
    public Calculator(String example) {
        numStack = new Stack<>();
        operStack = new Stack<>();
        this.example = example;
    }

    /**
     * 执行计算的主要操作
     * @return 结果
     */
    public Float getResult() {
        int index = 0;
        for (int i = 0; i < example.length(); i++) {
            if (i == example.length()-1){
                float num = Float.parseFloat(example.substring(i));
                numStack.push(num);
                while (!operStack.empty()){
                    Float n2 = numStack.pop();
                    Float n1 = numStack.pop();
                    Character pop = operStack.pop();
                    Float res = cal(n1, n2, pop);
                    numStack.push(res);
                }
                System.out.println("结果是：");
                Float pop = numStack.pop();
                System.out.println(pop);
                return pop;
            }
            // 如果取到了符号
            if (isOper(example.charAt(i))) {
                Character nowOper = example.charAt(i);
                float num = Float.parseFloat(example.substring(index,i));
                numStack.push(num);
                index = i + 1;
                // 判断是否有符号且符号优先级比当前大
                if (!operStack.empty()) {
                    Character preOper = operStack.pop();
                    if (priority(preOper) >= priority(nowOper)) {
//                        如果是大于或等于，先进行一次计算
                        Float n2 = numStack.pop();
                        Float n1 = numStack.pop();
                        Float res = cal(n1, n2, preOper);
                        // 压回栈
                        numStack.push(res);
                    }
                    else{
                        operStack.push(preOper);
                    }
                }
                // 无论是否计算都会将新符号压入栈
                operStack.push(nowOper);
            }
        }
        return null;
    }

    /**
     * 判断优先级
     * @param oper 符号
     * @return 数字越大优先级越高
     */
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            throw new RuntimeException("符号错误");
        }
    }

    /**
     * 判断是不是符号
     * @param c
     * @return
     */
    public boolean isOper(char c) {
        return c == '*' || c == '/' || c == '+' || c == '-';
    }

    /**
     * 计算
     * @param n1
     * @param n2
     * @param oper
     * @return
     */
    public Float cal(float n1, float n2, char oper) {
        if (oper == '*') {
            return n1 * n2;
        } else if (oper == '/') {
            return n1 / n2;
        } else if (oper == '+') {
            return n1 + n2;
        } else if (oper == '-') {
            return n1 - n2;
        }
        return null;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator("1+2*3/6+3");
        calculator.getResult();
    }

}
