package com.shaoxi.algorithm.datastructure;

/**
 * 栈溢异常
 *
 * @author shaoxi.ycw
 * @since 2019-02-01
 */
public class QueueUnderflowException extends RuntimeException {
    /**
     *
     */
    public QueueUnderflowException(){
        super();
    }

    /**
     *
     * @param message
     */
    public QueueUnderflowException(String message) {
        super(message);
    }
}
