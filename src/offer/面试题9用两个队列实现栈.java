package offer;

import java.util.Stack;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/23 21:48
 */
public class 面试题9用两个队列实现栈 {
    class CQueue {

        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            // 栈2不为空，直接将栈2的最顶元素取出来
            if (!stack2.isEmpty()){
                return stack2.pop();
            } else if (stack1.isEmpty()){ // 栈1为空代表没有元素
                return -1;
            } else {
                // 栈1不为空，栈2为空的时候，依次把栈1的元素弹出压入栈2这个时候两个栈的元素顺序相反
                while (!stack1.isEmpty()){
                    int value = stack1.pop();
                    stack2.push(value);
                }
                return stack2.pop();
            }
        }
    }
}
