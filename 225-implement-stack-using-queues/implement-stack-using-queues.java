import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        // Rotate queue so that new element is at the front
        for (int i = 1; i < q.size(); i++) {
            q.add(q.remove());
        }
    }
    
    // Removes the element on top of the stack and returns it.
    public int pop() {
        return q.remove();
    }
    
    // Get the top element.
    public int top() {
        return q.peek();
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
