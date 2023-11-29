package automation.testsuite;

import automation.PageLocator.Page_AddEvents;
import automation.common.CommonBase;
import automation.constant.CT_Rise;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProjectEvents_AddEvent_Team2 extends CommonBase {
    @BeforeTest
    public void OpenBrowser() {
        driver = setupDriver("chrome");
        driver.get(CT_Rise.webURLRise);
        Page_AddEvents rise = new Page_AddEvents(driver);
        rise.LoginRise(CT_Rise.EmailAdmin,CT_Rise.Passtrue);
    }
    @Test
    public void AddEventsType() throws InterruptedException {
        Page_AddEvents event = new Page_AddEvents(driver);
        pause(2000);
        event.AddEventsType(CT_Rise.Team2_Event,CT_Rise.Date);
        pause(3000);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_EventsType).isDisplayed());

    }
    @Test
    public void AddLeaveType() throws InterruptedException {
        Page_AddEvents event = new Page_AddEvents(driver);
        pause(2000);
        event.AddLeaveType("Hello",CT_Rise.Date);
        pause(3000);

    }
    @Test
    public void AddProjectStartDateType() throws InterruptedException {
        Page_AddEvents event = new Page_AddEvents(driver);
        pause(2000);
        event.AddProjectStartDateType(CT_Rise.Team2_ProjectStartdate,CT_Rise.Date);
        pause(3000);

    }
    @Test
    public void AddProjectDeadlineType() throws InterruptedException {
        Page_AddEvents event = new Page_AddEvents(driver);
        pause(2000);
        event.AddProjectDeadlineType(CT_Rise.Team2_ProjectDeadline,CT_Rise.Date);
        pause(3000);

    }
    @Test
    public void AddTaskStartDateType() throws InterruptedException {
        Page_AddEvents event = new Page_AddEvents(driver);
        pause(2000);
        event.AddTaskStartDateType(CT_Rise.Team2_TasksStartdate,CT_Rise.Date);
        pause(3000);

    }
    @Test
    public void AddTaskDeadlineType() throws InterruptedException {
        Page_AddEvents event = new Page_AddEvents(driver);
        pause(2000);
        event.AddTaskDeadlineType(CT_Rise.Team2_TaskDeadline,CT_Rise.Date);
        pause(3000);

    }
    @AfterTest
    public void CloseBrowser(){
        driver.close();
    }
}
