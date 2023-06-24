public class BuyAndSellStocks {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = -1;
        for(int i=0; i<prices.length; i++){
            if(minSoFar > prices[i]) minSoFar = prices[i];
            if(prices[i] - minSoFar > maxProfit) maxProfit = prices[i] - minSoFar;
        }
        return maxProfit;
    }
}
