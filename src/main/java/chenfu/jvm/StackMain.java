package chenfu.jvm;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 12:12
 */
public class StackMain {

    @Test
    public void run1(){
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        stack.push(555);
        stack.push(123);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
