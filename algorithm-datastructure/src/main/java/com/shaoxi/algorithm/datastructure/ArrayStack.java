package com.shaoxi.algorithm.datastructure;

/**
 * 使用数组实现栈
 *
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class ArrayStack<T> implements IStack<T> {

    /**
     * 最小栈容量大小
     */
    private int MIN_CAPACITY = 16;

    /**
     * 最小扩展数量
     */
    private int MIN_CAPACITY_EXPANSION = 16;

    /**
     * 扩容比例
     */
    private double CAPACITY_EXPANSION_FACTOR = 0.25;

    /**
     * 减少容量阀值
     */
    private double CAPACITY_REDUCE_THRESHOLD = 0.5;

    /**
     * 是否固定容量
     */
    private boolean isFixCapacity;

    /**
     * 栈容量
     */
    private int capacity;

    /**
     * 栈
     */
    private int top;

    /**
     * 数据
     */
    private T[] data;

    /**
     * 栈容量默认16
     */
    public ArrayStack() {
        this.top = 0;
        this.capacity = MIN_CAPACITY;
        this.data = (T[]) new Object[capacity];
        this.isFixCapacity = false;
    }

    /**
     * @param capacity 容量，必须大于0
     */
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity illegal, capacity must be greater than 0");
        }
        this.top = 0;
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.isFixCapacity = false;
    }

    /**
     * @param capacity 容量，必须大于0
     * @param isFixCapacity 容量是否固定
     */
    public ArrayStack(int capacity, boolean isFixCapacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity illegal, capacity must be greater than 0");
        }
        this.top = 0;
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.isFixCapacity = isFixCapacity;
    }

    /**
     * 入栈
     *
     * @param element
     *
     * @throws StackOverflowException isFixCapacity=true 且 容量达超过上限
     */
    @Override
    public void push(T element){
        if(isFixCapacity){
            if(top==capacity){
                throw new StackOverflowException();
            }
        }else{
            ensureCapacity();
        }
        data[top] = element;
        top++;
    }

    /**
     * 出栈
     *
     * @return 出栈元素
     *
     * @throws StackUnderflowException if isEmpty()==true
     */
    @Override
    public T pop(){
        if(isEmpty()){
            throw new StackUnderflowException();
        }

        T e = data[--top];
        data[top] = null;

        if(!isFixCapacity){
            reduceCapacity();
        }

        return e;
    }


    /**
     * 栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 确保容量
     */
    private void ensureCapacity() {
        if (top == data.length - 1) {
            //扩展容量 = length * 0.25，并且确保每次扩展>=16
            int capacityExpansion = (int) ( data.length * CAPACITY_EXPANSION_FACTOR);
            capacityExpansion = capacityExpansion < MIN_CAPACITY_EXPANSION ? MIN_CAPACITY_EXPANSION : capacityExpansion;
            int newCapacity = capacity + capacityExpansion;
            T[] newData = (T[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, top);
            data = newData;
            capacity = newCapacity;
        }
    }

    /**
     * 缩减容量
     */
    private void reduceCapacity() {
        if (capacity>MIN_CAPACITY ) {
            if(top==0){
                //栈为空，则缩减容量至最小容量
                T[] newData = (T[]) new Object[MIN_CAPACITY];
                data = newData;
                capacity = MIN_CAPACITY;
            }else if((capacity - top)/top > CAPACITY_REDUCE_THRESHOLD){
                //超过空余容量缩减阀值，缩减容量为当然元素的1.25倍，同时确保不会小于最小容量
                int newCapacity = (int) (top * (1 + CAPACITY_EXPANSION_FACTOR));
                newCapacity = newCapacity < MIN_CAPACITY ? MIN_CAPACITY : newCapacity;
                T[] newData = (T[]) new Object[newCapacity];
                System.arraycopy(data, 0, newData, 0, top);
                data = newData;
                capacity = newCapacity;
            }
        }
    }

}
