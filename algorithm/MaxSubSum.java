package algorithm;

/**
 * 连续子序最大和问题 O(N^3)
 * Created by han on 16-4-26.
 */
public class MaxSubSum {
    public static void main(String[] args) {
        int[] a = {-2,11,-4,13,-5,2};   //20
        System.out.println(maxSubsequenceSun(a));
    }
    public static int maxSubsequenceSun(int[] a){
        int maxSum = 0;
        int seqStart;
        int seqEnd;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j <a.length ; j++) {
                int thisSum = 0;

                for (int k = i; k <= j ; k++) {
                    thisSum+=a[k];

                    if (thisSum > maxSum){
                        maxSum = thisSum;
                        seqStart = i;
                        seqEnd = j;
                    }

                }

            }

        }
        return maxSum;
    }
}
