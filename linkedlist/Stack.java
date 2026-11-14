package linkedlist;
import java.io.*;

public class Stack {
    private int size, top;
    private int[] nums;

    public Stack(int initialSize) {
        this.size = 0;
        this.nums = new int[initialSize];
        this.top = -1;
    }

    public void push(int data) {
        if(isFull()){
            return; 
        }
        nums[++top] = data;
        size++;
    }

    public boolean isFull() {
        return size == nums.length;
    }

    public void show() {
        int index = 0;

        for(index = 0; index < size; index++){

            System.out.printf("Stack %d: Data: %d\n", index+1, nums[index]);
        }
    }

    public int pop() {
        System.out.println("\n======POP======");
        int removedData = peek();
        top--;
        size--;
        return removedData;
    }

    public int peek() {
        return nums[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(20);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.show();
        stack.pop();
        stack.show();




    }
}
