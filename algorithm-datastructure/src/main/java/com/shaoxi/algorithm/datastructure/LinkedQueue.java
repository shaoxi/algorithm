/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

/**
 * 链表实现队列，无界队列
 *
 * @author shaoxi.ycw
 * @version $Id: LinkedQueue.java, v 0.1 2019年02月01日 3:54 PM shaoxi.ycw Exp $
 */
public class LinkedQueue<E> implements IQueue<E> {
    /**
     * 队头
     */
    private Node<E> head;

    /**
     * 队尾
     */
    private Node<E> tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        E e = head.data;
        head = head.next;
        return e;
    }

    /**
     * 节点
     *
     * @param <E> 元素
     */
    class Node<E> {
        /**
         * 数据
         */
        E data;

        /**
         * 下一个节点
         */
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}