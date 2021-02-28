package examples;

import java.util.EmptyStackException;

public class ImplementStack<T> {
    static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        if (top == null) {
            throw new EmptyStackException();
        }
        StackNode<T> newItem = new StackNode<>(item);
        newItem.next = top;
        top =  newItem;
    }

    public T peek(){
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;

    }

}
