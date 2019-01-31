package com.shaoxi.algorithm.datastructure;

/**
 * 栈下溢异常
 *
 * @author shaoxi.ycw
 * @since 2019-02-01
 */
public class StackUnderflowException extends RuntimeException {
    /**
     *
     */
    public StackUnderflowException(){
        super();
    }

    /**
     *
     * @param message
     */
    public StackUnderflowException(String message) {
        super(message);
    }
}
