package com.hanson.leetcode;

import java.util.Stack;

/**
 * 实现一个函数，输入是表达式四则运算表达式的字符串，输入其计算结果
 * 举例：输入"(1+2)*1.2-5/2"的输出结果是1.1
 *
 * @author hanson
 * @date 2024/3/26 15:12
 */
public class StringConvertExpression {

    public static void main(String[] args) {
        String expression = "(1+2)*1.2-5/2";
        float result = (float) evaluateExpression(expression);
        System.out.println(expression + " 计算结果是： " + result);
    }


    /**
     * @param expression 计算表达式
     * @return 计算结果
     */
    public static double evaluateExpression(String expression) {
        // 创建一个栈用于存放参与计算的数字
        Stack<Double> operands = new Stack<>();
        // 创建一个栈用于存放操作符号及括号
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                operands.push(Double.parseDouble(sb.toString()));
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    double result = applyOperator(operators.pop(), operands.pop(), operands.pop());
                    operands.push(result);
                }
                operators.pop();
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    double result = applyOperator(operators.pop(), operands.pop(), operands.pop());
                    operands.push(result);
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            double result = applyOperator(operators.pop(), operands.pop(), operands.pop());
            operands.push(result);
        }

        return operands.pop();
    }

    /**
     * @param ch 字符
     * @return 判断是否是操作符
     */
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * 返回运算符的优先级
     *
     * @param op 操作符号
     * @return 返回运算优先级
     */
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    /**
     * @param op 操作符
     * @param b 数字a
     * @param a 数字b
     * @return 计算结果
     */
    private static double applyOperator(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("被除数不能为0");
                return a / b;
            default:
                throw new IllegalArgumentException("无效操作：" + op);
        }
    }
}
