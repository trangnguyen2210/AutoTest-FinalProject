package automation.testsuite;

import automation.PageLocator.EventPageFactory;
import automation.PageLocator.Page_AddEvents;
import automation.common.CommonBase;
import automation.constant.CT_Rise;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectEvents_DisplayByMonthWeekDay_Team2 extends CommonBase {
    @BeforeMethod
    public void OpenBrowser() {
        driver = setupDriver("chrome");
        driver.get(CT_Rise.webURLRise);
        Page_AddEvents rise = new Page_AddEvents(driver);
        rise.LoginRise(CT_Rise.EmailAdmin,CT_Rise.Passtrue);
        rise.eventsButton.click();
    }

    @Test(priority = 1)
    public void Testcase_Event_1() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        Assert.assertEquals(eventPage.txtTitle.getText(), eventPage.getCurrentMonth());
    }

    @Test(priority = 2)
    public void Testcase_Event_2() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnWeek.click();
        Assert.assertEquals(eventPage.txtTitle.getText(), eventPage.getCurrentWeek());
    }

    @Test(priority = 3)
    public void Testcase_Event_3() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnDay.click();
        Assert.assertEquals(eventPage.txtTitle.getText(), eventPage.getCurrentDateTime());
    }

    @Test(priority = 4)
    public void Testcase_Event_4() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnList.click();
        String currentMonth = eventPage.getCurrentMonth();
        Assert.assertEquals(eventPage.txtTitle.getText(), currentMonth);
    }

    @Test(priority = 5)
    public void Testcase_Event_5() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnMonth.click();
        eventPage.btnNext.click();
        eventPage.btnNext.click();
        eventPage.btnToday.click();
        String currentMonth = eventPage.getCurrentMonth();
        Assert.assertEquals(eventPage.txtTitle.getText(), currentMonth);
    }

    @Test(priority = 6)
    public void Testcase_Event_6() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnWeek.click();
        eventPage.btnNext.click();
        eventPage.btnNext.click();
        eventPage.btnToday.click();
        Assert.assertEquals(eventPage.txtTitle.getText(), eventPage.getCurrentWeek());
    }

    @Test(priority = 7)
    public void Testcase_Event_7() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnMonth.click();
        eventPage.btnNext.click();
        eventPage.btnNext.click();
        eventPage.btnToday.click();
        Assert.assertEquals(eventPage.txtTitle.getText(), eventPage.getCurrentMonth());
    }

    @Test(priority = 8)
    public void Testcase_Event_8() {
        EventPageFactory eventPage = new EventPageFactory(driver);
        eventPage.btnDay.click();
        eventPage.btnNext.click();
        eventPage.btnNext.click();
        eventPage.btnToday.click();
        Assert.assertEquals(eventPage.txtTitle.getText(), eventPage.getCurrentDateTime());
    }

    @AfterMethod
    public void closeChrome() {
        quitDriver(driver);
    }
}
