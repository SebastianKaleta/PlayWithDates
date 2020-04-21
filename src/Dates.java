import java.io.*;
/*Problem Statement
Given the date, month and year, find the day.

Input Specification
The first line consists of an integer t, the number of test cases. Then for each test case there are three integers the date, month and year.

Output Specification
For each test case print the day in words in a separate line(The first character should be caps followed by small letters).

Input Constraints
1<=t<=100

Date/month/year >= 11/1/2012

Date/month/year<=31/12/3000

The given date will always be a valid date

Example
Sample Input:

3

11 1 2012

12 1 2012

13 1 2012

Sample Output:

Wednesday

Thursday

Friday
Restrictions
Use the template below
Put your code inside the Main class
Do not use any additional imports except java.io.*;
*/

public class Dates {
    public static void main(String[] args) throws java.lang.Exception {
        java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(System.in));
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/mm/yyyy");
        java.util.ArrayList<java.util.Date> list = new java.util.ArrayList<>();
       // java.util.Scanner scaner = new java.util.Scanner(System.in);

        try {
            System.out.println("Ile podasz dat?");

            int input = 0;
            boolean inputInt = false;
            while (inputInt == false) {
                try {
                    input = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {

                }
                if (input >= 1 && input <= 100) {
                    inputInt = true;
                } else {
                    System.out.println("Ups, coś nie tak, podaj ponownie.");

                }

            }

            int dayInt = 0;
            int monthInt = 0;
            int yearInt = 0;
            for (int i = 0; i < input; ) {
                System.out.println("Podaj datę: ");

                try {
                    dayInt = Integer.parseInt(reader.readLine());
                    monthInt = Integer.parseInt(reader.readLine());
                    yearInt = Integer.parseInt(reader.readLine());
//                    dayInt = Integer.parseInt(scaner.next());
//                    monthInt = Integer.parseInt(scaner.next());
//                    yearInt = Integer.parseInt(scaner.next());

                } catch (Exception e) {

                }

                //Date/month/year >= 11/1/2012
                // Date/month/year<=31/12/3000
                if ((dayInt >= 11 && monthInt >= 1 && yearInt >= 2012) && (dayInt <= 31 && monthInt <= 12 && yearInt <= 3000)) {
                    String str = dayInt + "/" + monthInt + "/" + yearInt;
                    java.util.Date date = simpleDateFormat.parse(str);
                    list.add(date);
                    i++;
                } else {
                    System.out.println("Ups, coś nie tak, spróbuj ponownie.");
                    i--;
                }
            }

            System.out.println("Dni tygodnia podanych dat:");
            simpleDateFormat = new java.text.SimpleDateFormat("EEEE");


            for (java.util.Date s : list) {
                String day = simpleDateFormat.format(s);
                String dayName = day.substring(0, 1).toUpperCase() + day.substring(1);

                System.out.println(dayName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
