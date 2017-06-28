import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Apple Stock Question

        /*

        Question:

        Suppose we could access yesterday's stock prices as an array, where:
        - The values are the price in dollars of Apple stock.
        - A higher index indicates a later time.

        So if the stock cost $500 at 10:30am and $550 at 11:00am, then:

        stockPricesYesterday[60] = 500;

        Write an efficient function that takes stockPricesYesterday and returns the best profit
        I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

        For example:

        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

        getMaxProfit(stockPricesYesterday);
        // returns 6 (buying for $5 and selling for $11)


        */

        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

        int [] stock = null;


        System.out.println("Max Profit is " + getMaxProfit(stockPricesYesterday));
        System.out.println("Max Profit is " + getMaxProfit(stock));


    }

    public static int getMaxProfit(int [] stockPricesYesterday){

        // Null edge case
        if (stockPricesYesterday == null){
            return 0;
        }

        // Passing in a too short array edge case
        if (stockPricesYesterday.length == 0 || stockPricesYesterday.length == 1)
            return 0;

        // Initialize Max Profit (0 since you'd never sell on a loss)
        int max_profit = 0;

        // Start at first index (first price of the day)
        int current_min_index = 0;

        // Start at second price (index 1)
        for (int current_price = 1; current_price < stockPricesYesterday.length; current_price++){

            // If value less than previously seen min val, reset min
            if (stockPricesYesterday[current_price] < stockPricesYesterday[current_min_index])
                current_min_index = current_price;

            else if( (stockPricesYesterday[current_price] - stockPricesYesterday[current_min_index]) > max_profit)
                max_profit = stockPricesYesterday[current_price] - stockPricesYesterday[current_min_index];

        }

        return max_profit;

    }




}