package com.shaoxi.algorithm.subarray;

/**
 * <pre>
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
     * 查找最大子数组
     *
     * @param a
     * @return
     */
    public static MaximumSubArrayResult findMaximumSubArray(int[] a){
        return findMaximumSubArray0(a, 0, a.length - 1);
    }

    private static MaximumSubArrayResult findMaximumSubArray0(int[] a, int low, int high){
        //TODO 分治法实现
        return new MaximumSubArrayResult(0,0,0);
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
