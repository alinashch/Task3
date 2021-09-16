package com.company;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> JavaQueue = new ArrayDeque<>();
        JavaQueue.add(1);
        JavaQueue.add(2);
        JavaQueue.add(3);
        JavaQueue.add(4);
        JavaQueue.add(5);
        for(int i: JavaQueue){
            System.out.print(i+" ");
        }
        System.out.println();
        Logic.SolutionForJavaQ(JavaQueue);
        for(int i: JavaQueue){
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println();
        SimpleQueue<Integer> LinkedQueue = new SimpleLinkedListQueue<>();
        LinkedQueue.add(1);
        LinkedQueue.add(2);
        LinkedQueue.add(3);
        LinkedQueue.add(4);
        LinkedQueue.add(5);
        for( int i=0; i<LinkedQueue.size(); i++){
            System.out.print(LinkedQueue.GetIndex(i)+" ");
        }
        System.out.println();
        Logic.SolutionForSimpleQ(LinkedQueue);
       for( int i=0; i<LinkedQueue.size(); i++){
           System.out.print(LinkedQueue.GetIndex(i)+" ");
       }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }

        });
    }
    }
