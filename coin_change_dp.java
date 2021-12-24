/*
Given an array of positive integers representing coin denominations and a single
non-negative integer n representing a target amount of money, write a function
that returns the smallest number of coins needed to make change for that target
amount using the given coin denominations.
Note that you have to access to an unlimited amount of coins. In other words,
if the denominations are[1,5,10], you have access to an unlimited amount of
1, 5, and 10.
If it's impossible to make change for the target amount, return -1.
I/P O/P
n=7 3
denoms= [1, 5, 10]
 */

class Scratch {
    //[0, 1 2 0 0 0 0 3]
    private static int minCoins(int target, int[] denom, int[] coins) {//7
        if (target == 0) {
            return 0;
        }

        if (coins[target] != 0) {
            return coins[target];
        }

        int minCount = Integer.MAX_VALUE;
        for (int coin : denom) { //10 //5
            if (target - coin >= 0) {
                int coinCount = minCoins(target - coin, denom, coins) + 1; //
                minCount = Math.min(coinCount, minCount);
            }
        }

        coins[target] = minCount;
        return minCount;
    }
    public static int minCoins(int target, int[] denom) {
        int[] coins = new int[target + 1];//dp storing
        int minCount = minCoins(target, denom, coins);

        if (minCount == Integer.MAX_VALUE) {
            return -1;
        }
        return minCount;
    }


    public static void main(String[] args) {
        System.out.println(minCoins(14, new int[]{1, 7, 10}));
    }
}
