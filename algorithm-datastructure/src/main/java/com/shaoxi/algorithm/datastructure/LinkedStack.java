/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

/**
 * 使用链表实现栈
 *
 * @author shaoxi.ycw
 * @version $Id: LinkedStack.java, v 0.1 2019年02月01日 11:26 AM shaoxi.ycw Exp $
 */
public class LinkedStack<E> implements IStack<E> {

    private Node<E> head;

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element, head);
        head = newNode;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new StackUnderflowException();
        }

        E data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    /**
     * 链表节点
     *
     * @param <T>
     */
    class Node<T>{
        public T    data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}