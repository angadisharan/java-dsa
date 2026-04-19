package org.matools.java.dsa.stock;

public class BuySellStockAllInOne {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 0, 2};
        int fee = 2;

        System.out.println("Input: [7,1,5,3,6,4]");

        System.out.println("1. Single Transaction: " + maxProfitSingle(prices));
        System.out.println("2. Unlimited Transactions: " + maxProfitUnlimited(prices));
        System.out.println("3. At Most 2 Transactions: " + maxProfitTwo(prices));

        System.out.println("\nInput (Cooldown): [1,2,3,0,2]");
        System.out.println("4. With Cooldown: " + maxProfitCooldown(prices2));

        System.out.println("\nInput (Fee = 2): [7,1,5,3,6,4]");
        System.out.println("5. With Transaction Fee: " + maxProfitWithFee(prices, fee));
    }

    // 1. Single Transaction
    public static int maxProfitSingle(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

    // 2. Unlimited Transactions
    public static int maxProfitUnlimited(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // 3. At Most 2 Transactions
    public static int maxProfitTwo(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);

            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        return profit2;
    }

    // 4. With Cooldown
    public static int maxProfitCooldown(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int prevSell = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, prevSell - prices[i]);
            prevSell = temp;
        }
        return sell;
    }

    // 5. With Transaction Fee
    public static int maxProfitWithFee(int[] prices, int fee) {
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy + fee) {
                profit += prices[i] - buy - fee;
                buy = prices[i] - fee;
            }
        }
        return profit;
    }
}