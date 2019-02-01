package com.shaoxi.algorithm.datastructure;

/**
 * 溢出异常
 *
 * @author shaoxi.ycw
 * @since 2019-02-01
 */
public class QueueOverflowException extends RuntimeException {
    /**
     *
     */
    public QueueOverflowException(){
        super();
    }

    /**
     *
     * @param message
     */
    public QueueOverflowException(String message) {
        super(message);
    }
}
