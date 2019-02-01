/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

/**
 * 数组实现队列，有界队列
 *
 * @author shaoxi.ycw
 * @version $Id: ArrayQueue.java, v 0.1 2019年02月01日 2:14 PM shaoxi.ycw Exp $
 */
public class ArrayQueue<E> implements IQueue<E> {

    /**
     * 队头
     */
    private int head;

    /**
     * 队尾
     */
    private int tail;

    /**
     * 元素
     */
    private E[] data;

    /**
     * 队列容量
     */
    private int capacity;

    /**
     * @param capacity 队列容量
     */
    public ArrayQueue(int capacity) {
        //多存一个元素，作为队尾哨兵
        this.data = (E[]) new Object[capacity + 1];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(E e) {
        int nextTail = next(tail);
        if (nextTail == head) {
            throw new QueueOverflowException();
        }
        data[tail] = e;
        tail = nextTail;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        E e = data[head];
        head = next(head);
        return e;
    }

    private int next(int index) {
        int newIndex = index - 1;
        return newIndex < 0 ? capacity + newIndex + 1 : newIndex;
    }
}