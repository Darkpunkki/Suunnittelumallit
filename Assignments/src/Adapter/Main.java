package Adapter;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        NewDateInterface date = new CalendarToNewDateAdapter(calendar);

        date.setDay(1);
        date.setMonth(11);
        date.setYear(2024);

        System.out.println("Date is: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
        date.advanceDays(5);
        System.out.println("Date is: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
        date.advanceDays(200);
        System.out.println("Date is: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
    }
}
