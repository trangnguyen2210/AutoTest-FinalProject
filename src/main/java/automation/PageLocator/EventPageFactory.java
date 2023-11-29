package automation.PageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

public class EventPageFactory {
    private WebDriver webDriver;

    public EventPageFactory(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h2[@class='fc-toolbar-title']")
    public WebElement txtTitle;
    @FindBy(xpath = "//div[@class='fc-button-group']//button[text()='month']")
    public WebElement btnMonth;
    @FindBy(xpath = "//div[@class='fc-button-group']//button[text()='week']")
    public WebElement btnWeek;
    @FindBy(xpath = "//div[@class='fc-button-group']//button[text()='day']")
    public WebElement btnDay;
    @FindBy(xpath = "//div[@class='fc-button-group']//button[text()='list']")
    public WebElement btnList;
    @FindBy(xpath = "//div[@class='fc-button-group']//button[@aria-label='prev']")
    public WebElement btnPrev;
    @FindBy(xpath = "//div[@class='fc-button-group']//button[@aria-label='next']")
    public WebElement btnNext;
    @FindBy(xpath = "//button[text()='today']")
    public WebElement btnToday;
    @FindBy(xpath = "(//td[@class='fc-timegrid-slot fc-timegrid-slot-lane fc-timegrid-slot-minor'])[1]")
    public WebElement emptyBox;

    @FindBy(id="title")
    public WebElement inputTitle;

    @FindBy(xpath = "//button[@class='btn btn-primary' and text()=' Save']")
    public WebElement btnSave;

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
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat df = new SimpleDateFormat("MMMMMMMMM d, yyyy");
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

    public String getCurrentWeek() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d");
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        TemporalField fieldISO = WeekFields.of(Locale.US).dayOfWeek();
        String formattedStartDate = now.with(fieldISO, 1).format(dateTimeFormatter);
        String formattedEndDate = now.with(fieldISO, 7).format(dateTimeFormatter);
        String dateRangeThisWeek = formattedStartDate + " – " + formattedEndDate + ", " + currentYear;
        return dateRangeThisWeek;
    }

    public void chooseDateTime(String dateTime) {
        WebElement selectStartDate = webDriver.findElement(By.xpath("//input[@name='start_date']"));
        System.out.println(selectStartDate);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].removeAttribute('readonly','readonly')", selectStartDate);
        selectStartDate.clear();
        selectStartDate.sendKeys(dateTime);
        selectStartDate.sendKeys(Keys.TAB);
    }
}
