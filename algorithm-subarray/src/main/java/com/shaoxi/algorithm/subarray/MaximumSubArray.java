package com.shaoxi.algorithm.subarray;

import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * <pre>
 * 分治法实现
 * 最大子数组
 * 输入数组：a[0..n]
 * 输出：子数组 a[i..j] 使得a[i..j]的和sum(a[i..j]) 在所有子数组当中和最大。
 * </pre>
 *
 * @author shaoxi.ycw
 * @since 2019-01-20
 */
public class MaximumSubArray {

    /**
     * 分治法查找最大子数组
     *
     * @param a
     * @return
     */
    public static MaximumSubArrayResult divideFindMaximumSubArray(int[] a){
        if(ArraysTool.isEmpty(a)){
            return null;
        }
        return divideFindMaximumSubArray0(a, 0, a.length - 1);
    }

    /**
     * 线性查找最大子数组
     *
     * @param a
     * @return
     */
    public static MaximumSubArrayResult linearFindMaximumSubArray(int[] a){
        if(ArraysTool.isEmpty(a)){
            return null;
        }

        MaximumSubArrayResult maxSum = new MaximumSubArrayResult(0,0,0);
        MaximumSubArrayResult currentSum = new MaximumSubArrayResult(0,0,0);

        //看数组当中全部元素是否都小于等于0
        int maxValue = a[0];
        int maxIdx = 0;

        for(int i=0; i<a.length; i++){
            currentSum.sum += a[i];
            currentSum.high = i;
            if(currentSum.sum>maxSum.sum){
                maxSum.setValue(currentSum.low, currentSum.high, currentSum.sum);
            }else if(currentSum.sum<0){
                int newStart = i+1;
                currentSum.setValue(newStart, newStart, 0 );
            }
            if(maxValue < a[i]){
                maxValue = a[i];
                maxIdx = i;
            }
        }

        if(maxValue<=0){
            //如果元素都小于0，则数组最大和就是元素当中的最大值
            return new MaximumSubArrayResult(maxIdx, maxIdx, maxValue);
        }else{
            return maxSum;
        }
    }

    /**
     * <pre>
     *
     * 分治法，一个数组的最大子数组，把数组分两半后，最大子数组有2种情况:
     * 1、最大子数组在拆分之后的数组，对于这种情况，还是求解最大子数组，只是问题规模变小了。
     * 2、最大子数组跨越两个数组
     * </pre>
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static MaximumSubArrayResult divideFindMaximumSubArray0(int[] a, int low, int high){
        if(low<high){
            int r = (low + high)/2;

            MaximumSubArrayResult lowResult = divideFindMaximumSubArray0(a, low, r);
            MaximumSubArrayResult highResult = divideFindMaximumSubArray0(a, r+1, high);
            MaximumSubArrayResult crossResult = divideFindCrossMaximumSubArray(a, low, r, high);
            if(lowResult.sum>=highResult.sum && lowResult.sum>=crossResult.sum){
                return lowResult;
            }else if(crossResult.sum>=lowResult.sum && crossResult.sum>=highResult.sum){
                return crossResult;
            }else{
                return highResult;
            }

        }else{
            long sum = sum(a, low, high);
            return new MaximumSubArrayResult(low,high, sum);
        }
    }

    /**
     * 查找跨越指定位置的最大子数组
     *
     * @param a
     * @param low
     * @param r
     * @param high
     * @return
     */
    private static MaximumSubArrayResult divideFindCrossMaximumSubArray(int[] a, int low, int r, int high) {
        long sum = a[r];
        long total = sum;
        int l = r;
        int h = r;
        for(int i = r-1; i>=low; i--){
            total += a[i];
            if(total>sum){
                l = i;
                sum = total;
            }
        }

        total = sum;
        for(int i = r+1; i<=high; i++){
            total += a[i];
            if(total>sum){
                h = i;
                sum = total;
            }
        }

        return new MaximumSubArrayResult(l, h, sum);
    }

    /**
     * 求数组之和
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static long sum(int[] a, int low, int high){
        long sum = 0;
        for(int i=low; i<=high; i++){
            sum+=a[i];
        }
        return sum;
    }

    public static class MaximumSubArrayResult{
        //子数组下标开始
        public int low;
        //子数组下标结束
        public int high;
        //子数组之和
        public long sum;

        public MaximumSubArrayResult(int low, int high, long sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        public void setValue(int low, int high, long sum){
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("MaximumSubArrayResult{");
            sb.append("low=").append(low);
            sb.append(", high=").append(high);
            sb.append(", sum=").append(sum);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
