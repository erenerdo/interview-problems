/*
 * Complete the function below.
 */

    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {

        // Initialze different date counters 
        int yearsApart= 0;
        int monthsApart = 0;
        int daysApart= 0;
        
        // Check different conditons for possible date differences
        if (month2 >= month1 && day2 >= day1){
            
            yearsApart = year2-year1;
            monthsApart = month2-month1;
            daysApart = day2 - day1;
        }
        else if (month2 < month1 && day2 >= day1) {
            
            yearsApart = year2-year1 -1;
            monthsApart = 12-month1 + month2;
            daysApart = day2-day1;
        }
        else if(month2 >= month1 && day2 < day1){
            yearsApart = year2-year1;
            monthsApart = month2-month1-1;
            daysApart = 31-day1 + day2;
        }
        else if (month2 < month1 && day2 < day1){
            
            yearsApart = year2-year1-1;
            monthsApart= 12-month1 + month2;
            daysApart = 31-day1 + day2;
        }
        
        int totalDays = 0;
        
        totalDays = (yearsApart*365) + (monthsApart*31) + daysApart;
        
        // Take into account leap years
        for(int i = year1 ; i < year2; i++){
            
            // Multiple of 4s
            if (i%4 == 0)
                totalDays +=1;
        }
        
        // Correct days for different months
        for (int i = month1; i < month2; i++){
            
            // 28 days in feb
            if(i == 2)
                totalDays -=3;
            
            // 30 day months
            else if( i == 4 || i == 6 || i == 9 || i == 11)
                totalDays -=1;
            
        }
        
        // return total days
        return totalDays;

    }

    // Do not edit below this line. It is only shown so you can see the function signature.
    // The implementation of the function is hidden.
    static int DaysInMonth(int month, int year) throws Exception {