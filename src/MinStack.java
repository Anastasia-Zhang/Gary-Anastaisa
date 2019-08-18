import java.util.ArrayList;
/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素
 *
 */
public class MinStack {
    /** initialize your data structure here. */
    private ArrayList<Integer> a;
    public MinStack() {
        a = new ArrayList<>();
    }

    public void push(int x) {
        a.add(x);
    }

    public void pop() {
        a.remove(a.size() - 1);
    }

    public int top() {
        return (int)a.get(a.size() - 1);
    }

    public int getMin() {
        int min = 0;
        for(int i = 1; i < a.size();i ++){
            if(a.get(i - 1) < a.get(i)){
                min = a.get(i - 1);
            }
        }
        return min;
    }
}
