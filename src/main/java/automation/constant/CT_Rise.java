package automation.constant;


import org.openqa.selenium.By;

public class CT_Rise {
    public static String EmailAdmin = "admin@demo.com";
    public static String Passtrue = "riseDemo";
    public static String webURLRise = "https://rise.fairsketch.com/";

    public static String Team2_Event = "Team2_EventsType";
    public static String Team2_ProjectStartdate = "Team2ProjectStartdateType";
    public static String Team2_ProjectDeadline = "Team2ProjectDeadlineType";
    public static String Team2_TasksStartdate = "Team2TasksTypeStartdate";
    public static String Team2_TaskDeadline = "Team2TaskDeadlineType";
    public static String Date = "25-11-2023";


    public static By Team2_EventsType = By.xpath("//td[@data-date='2023-11-25']//descendant::span[text()=' Team2_EventsType']");
    public static By Team2_LeaveType = By.xpath("//td[@data-date='2023-11-25']//descendant::span[text()=' John Doe']");
    public static By Team2_ProjectStartdateType = By.xpath("//td[@data-date='2023-11-25']//descendant::span[contains(text(),' Team2ProjectStartdateType')]");
    public static By Team2_ProjectDeadlineType = By.xpath("//td[@data-date='2023-11-25']//descendant::span[contains(text(),' Team2ProjectDeadlineType')]");
    public static By Team2_TasksStartdateType = By.xpath("//td[@data-date='2023-11-25']//descendant::span[contains(text(),' Team2TasksTypeStartdate')]");
    public static By Team2_TaskDeadlineType = By.xpath("//td[@data-date='2023-11-25']//descendant::span[contains(text(),' Team2TaskDeadlineType')]");



}
