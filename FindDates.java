public class FindDates {

    enum Months {
        JAN(0),
        FEB(1),
        MAR(2),
        APR(3),
        MAY(4),
        JUN(5),
        JUL(6),
        AUG(7),
        SEP(8),
        OCT(9),
        NOV(10),
        DEC(11);
        final int code;

        Months(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

    }

    public static void main(String[] args) {
        String PO = "XYZ";
        String date1 = "SEP-2017";
        String date2 = "DEC-2024";

        String monthsArray[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG",
        "SEP","OCT","NOV","DEC"};

        // find number of months in two year (date1 - date2 - 1) * 12
        int difference_yy = 12 * ((getYear(date2) - getYear(date1)) - 1);
        //Get Year from date

        int yysDate = getYear(date1);
        int yyeDate = getYear(date2);

        //Get starting month and ending month from the given date (Ex: NOV-2018 To SEP-2020 gives NOV  and SEP as output.
        String sDate = getMonths(date1);
        String eDate = getMonths(date2);

        //Get numerical value corresponding to month and counting remaining months in year
        int starting_numerical_months = 12- Months.valueOf(sDate.trim()).getCode();
        int ending_numerical_months = Months.valueOf(eDate.trim()).getCode();

        //Get numerical value of months from enum
        int eStart = Months.valueOf(sDate.trim()).getCode();


        //Number of months left from starting and ending dates.
        long difference_months = starting_numerical_months + ending_numerical_months;

        //Total Number of months left between starting and ending dates.
        long cycle = difference_months + difference_yy;

        int flag = 0;

        //
        System.out.println("Start Date\tEnd Date\tPurchase Order");

        System.out.println(date1+"\t"+date2+"\tXYZ");

        System.out.println("");


        //
        System.out.println("Start Date\tPurchase Order");

        if(yysDate == yyeDate){
            for (int i = 0; i <= ending_numerical_months; i++) {
                System.out.println(monthsArray[i] + "-" + yyeDate + "\t" + PO);
            }
        }else {

            // Display starting dates from starting date
            for (int i = 0; i < starting_numerical_months; i++) {
                System.out.println(elementAtPosition(monthsArray, eStart + flag) + "-" + yysDate + "\t" + PO);
                flag++;
            }

            // Display PO in period between Start date and End Date
            for (int i = yysDate + 1; i <= yyeDate - 1; i++) {
                printPO(i);
                // printPO(yysDate,yyeDate);
            }


            // Display PO Number for end months
            for (int i = 0; i <= ending_numerical_months; i++) {
                System.out.println(monthsArray[i] + "-" + yyeDate + "\t" + PO);
            }
        }

    }


    public static void printPO(int yearsBW){
        String monthsArray[] = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG",
                "SEP","OCT","NOV","DEC"};


        for (String elements:monthsArray
             ) {
            System.out.println(elements+"-"+yearsBW+"\tXYZ");
        }
    }

    public static String elementAtPosition(String[] container, int position){

        for (int i = 0; i < container.length; i++) {
                return container[position];
        }

        return null;
    }

    public static int getYear(String date) {
        int hypen = date.indexOf("-");
        char buf[] = new char[4];
        date.getChars(hypen + 1, date.length(), buf, 0);
        String buffer = new String(buf);
        Integer yy = Integer.parseInt(buffer);
        return yy;
    }

    public static String getMonths(String date) {
        int hypen = date.indexOf("-");
        char buf[] = new char[4];
        date.getChars(0, hypen, buf, 0);
        String buffer = new String(buf);
        return buffer;
    }


}
