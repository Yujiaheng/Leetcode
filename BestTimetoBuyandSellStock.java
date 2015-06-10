/**
 * Created by JiahengYu on 10/06/15.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
            return 0;
        int maxProfit=0;
        int min=prices[0];
        for (int p:prices){
            min=Math.min(min,p);
            maxProfit=Math.max(maxProfit,p-min);
        }
        return maxProfit;
    }
}
