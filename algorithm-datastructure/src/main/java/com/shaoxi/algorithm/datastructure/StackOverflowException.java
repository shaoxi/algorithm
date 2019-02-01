package com.shaoxi.algorithm.datastructure;

/**
 * 溢出异常
 *
 * @author shaoxi.ycw
 * @since 2019-02-01
 */
public class StackOverflowException extends RuntimeException {
    /**
     *
     */
    public StackOverflowException(){
        super();
    }

    /**
     *
     * @param message
     */
    public StackOverflowException(String message) {
        super(message);
    }
}
