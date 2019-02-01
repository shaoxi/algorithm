/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

/**
 *
 * 栈接口，后进先出 last in,first out LIFO
 *
 * @author shaoxi.ycw
 * @version $Id: IStack.java, v 0.1 2019年02月01日 10:03 AM shaoxi.ycw Exp $
 */
public interface IStack<T> {
    /**
     * 入栈
     * @param element
     */
    void push(T element);

    /**
     * 出栈
     *
     * @return 栈顶元素
     * @throws StackUnderflowException isEmpty==true，出栈异常
     */
    T pop();

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();
}