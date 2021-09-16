package com.company;
import java.util.ArrayDeque;

public class Logic {
    public  static ArrayDeque<Integer> SolutionForJavaQ(ArrayDeque<Integer> JavaQueue){
        int size =JavaQueue.size();
        while(size>1){
            int num1=JavaQueue.getFirst();
            JavaQueue.removeFirst();
            size--;
            int num2=JavaQueue.getFirst();
            JavaQueue.removeFirst();
            size--;
            int x=num1;
            num1=num2;
            num2=x;
            JavaQueue.add(num1);
            JavaQueue.add(num2);
            if(size==1){
                int k=JavaQueue.getFirst();
                JavaQueue.removeFirst();
                JavaQueue.add(k);
            }
        }
        return  JavaQueue;
    }
    public static SimpleQueue<Integer> SolutionForSimpleQ(SimpleQueue<Integer> LinkedQueue) throws Exception {
        int size=LinkedQueue.size();
        while(size>1) {
            int num1 = LinkedQueue.element();
            LinkedQueue.remove();
            size--;
            int num2 = LinkedQueue.element();
            LinkedQueue.remove();
            size--;
            int x = num1;
            num1 = num2;
            num2 = x;
            LinkedQueue.add(num1);
            LinkedQueue.add(num2);
            if(size==1){
                int k=LinkedQueue.element();
                LinkedQueue.remove();
                LinkedQueue.add(k);
            }
        }
        return LinkedQueue;
    }
    }
