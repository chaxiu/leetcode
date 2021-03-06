package com.leetcode;

/**
 * Created by xiaoyuan on 28/02/2017.
 * 划分为子问题
 */
public class P60_PermutationSequence {

    int[] cnt = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        if (k > cnt[n]) {
            k = cnt[n];
        }
        if (n <= 1) {
            return "1";
        }

        int pos = 1;
        while (k > cnt[n - 1]) {
            k -= cnt[n - 1];
            pos ++;
        }

        String other = getPermutation(n - 1, k);

        String res = "" + pos;
        for (int i = 0; i < other.length(); i++) {
            int intValue = Integer.parseInt("" + other.charAt(i));
            if (intValue >= pos) {
                intValue ++;
            }
            res += "" + intValue;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P60_PermutationSequence().getPermutation(3, 1));
        System.out.println(new P60_PermutationSequence().getPermutation(3, 2));
        System.out.println(new P60_PermutationSequence().getPermutation(3, 3));
        System.out.println(new P60_PermutationSequence().getPermutation(3, 4));
        System.out.println(new P60_PermutationSequence().getPermutation(3, 5));
        System.out.println(new P60_PermutationSequence().getPermutation(3, 6));
    }

}
