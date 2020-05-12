package chuxiao.datastructure.linear.stack;

import chuxiao.datastructure.linear.list.v2.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    public static void main(String[] args) {
        Stack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }

        System.out.println(linkedListStack.peek());
        System.out.println(linkedListStack);

        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack);
    }

    @Override
    public void push(E e) {
        stack.addFirst(e);
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public E peek() {
        return stack.getFirst();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack ").append("top");
        res.append(stack);
        return res.toString();
    }
}
