public class Main {

    public static void main(String[] args) {

        /*

            Writing programming interview questions hasn't made me rich. Maybe trading Apple stocks will.
            Suppose we could access yesterday's stock prices as an array, where:

            The indices are the time in minutes past trade opening time, which was 9:30am local time.
            The values are the price in dollars of Apple stock at that time.
            So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

            Write an efficient function that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

            For example:

              int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};

            getMaxProfit(stockPricesYesterday);
            // returns 6 (buying for $5 and selling for $11)

            No "shorting"—you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).

         */

        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};

        int num = getMaxProfit(stockPricesYesterday);

        int[] arr = null;
        System.out.println(num);
        System.out.println(getMaxProfit(arr));

    }

    public static int getMaxProfit(int [] stockPricesYesterday){

        if (stockPricesYesterday == null){
            System.out.println("Can't pass in a null array");
            return -1;
        }

        if(stockPricesYesterday.length < 2){
            System.out.println("Not enough stock prices");
            return -1;
        }

        int globalMax = 0;
        int currentMax = 0;
        int min = stockPricesYesterday[0];


        for (int i = 0; i < stockPricesYesterday.length;i++){

            // Check if minIndex
            if(stockPricesYesterday[i] < min){
                min = stockPricesYesterday[i];
                currentMax = 0;
            }
            else {
                currentMax = stockPricesYesterday[i] - min;
            }

            if(currentMax > globalMax){
                globalMax = currentMax;
            }

        }

        return globalMax;

    }



}



