package DP;

class PRO_연속펄스_부분_수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;
        long[] dp1 = new long[500001];
        long[] dp2 = new long[500001];

        long bit1 = 1;
        long bit2 = -1;
        dp1[0] = sequence[0] * -1;
        dp2[0] = sequence[0];
        for(int i = 1; i < sequence.length; i++) {
            long num1 = (long) sequence[i] * bit1;
            dp1[i] = Math.max(num1, dp1[i-1] + num1);
            bit1 *= -1;
            answer = Math.max(answer, dp1[i]);

            long num2 = (long) sequence[i] * bit2;
            dp2[i] = Math.max(num2, dp2[i-1] + num2);
            bit2 *= -1;
            answer = Math.max(answer, dp2[i]);
        }

        return answer;
    }
}

/*
틀림, 다시 풀어야됨
 */
