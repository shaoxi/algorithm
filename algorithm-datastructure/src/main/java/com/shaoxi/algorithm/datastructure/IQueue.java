/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

/**
 * 队列
 *
 * @author shaoxi.ycw
 * @version $Id: IQueue.java, v 0.1 2019年02月01日 1:47 PM shaoxi.ycw Exp $
 */
public interface IQueue<E> {

    /**
     * 是否队列为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param e
     * @throws QueueOverflowException 有界队列超过队列最大容量
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return e 队头元素
     * @throws QueueUnderflowException 队列为空
     */
    E dequeue();
}