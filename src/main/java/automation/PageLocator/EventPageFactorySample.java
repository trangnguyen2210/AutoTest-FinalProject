package automation.PageLocator;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventPageFactorySample {
    // 1. Lấy tháng tiếp theo từ tháng hiện tại theo định dạng "October 2023"
    public String getNext1MonthFromCurrentMonth1()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        String currentMonth = df.format(calendar.getTime());
        System.out.println("current Month: "+currentMonth);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
        String nextMonth = df.format(calendar.getTime());
        System.out.println("NextMonth from curent month: "+nextMonth);
        return nextMonth;
    }

    //2. Lấy tháng hiện tại theo định dạng "September 2023"
    public String getCurrentMonth()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
        String currentMonth = df.format(calendar.getTime());
        System.out.println("currentMonthAsString: "+currentMonth);
        return currentMonth;
    }

    // 3. Lấy ngày tháng năm hiện tại
    public String getCurrentDateTime()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        //calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        String currentdateTime = df.format(calendar.getTime());
        System.out.println("Current day - month - year: "+currentdateTime);
        return currentdateTime;
    }

    // 4. Lấy 7 ngày tiếp theo từ ngày hiện tại
    public String getNext7DaysOfCurrentDateTime()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+7);
        String next7Days = df.format(calendar.getTime());
        System.out.println("Next 7 days from current day: "+next7Days);
        return next7Days;
    }
}
