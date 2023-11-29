package automation.testsuite;

import automation.PageLocator.PageLocator_Rise;
import automation.common.CommonBase;
import automation.constant.CT_Rise;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProjectEvents_EventType_Team2 extends CommonBase {
    @BeforeMethod
    public void OpenBrowser() {
        driver = setupDriver("chrome");
        driver.get(CT_Rise.webURLRise);
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.EventsPage(CT_Rise.EmailAdmin, CT_Rise.Passtrue);
    }

    @Test
    public void EventType02_KiemtrahienthiButtonEventType() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        Assert.assertTrue(rise.eventTypeButton.isDisplayed());
    }

    @Test
    public void EventType03_KiemTraMacDinhDropdownEventType() throws InterruptedException {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraTrangThaiMacDinhDropdownEventType();
        Assert.assertTrue(rise.eventsActive.isDisplayed());
        Assert.assertTrue(rise.dropdownMenu.isDisplayed());
    }

    @Test
    public void EventType04_KiemTraGiaTriMacDinh_EventCalendar() throws InterruptedException {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraTrangThaiMacDinhDropdownEventType();
        Thread.sleep(3000);
        Assert.assertTrue(rise.eventsActive.isDisplayed());
        Assert.assertTrue(rise.dropdownMenu.isDisplayed());
        pause(3000);
        // kiểm tra chỉ hiển thị event
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_EventsType).isDisplayed());
        isElementPresent(CT_Rise.Team2_LeaveType);
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);

    }

    @Test
    public void EventType05_KiemTraHienThiKhiKhongChonGiaTriTrongDropdown() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemtrahienthikhikhongchongiatritrongDropdownList();
        pause(3000);
        // kiểm tra chỉ hiển thị event
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_EventsType).isDisplayed());
        isElementPresent(CT_Rise.Team2_LeaveType);
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);

    }
    @Test
    public void EventType06_KiemTraTongSoCacGiaTriDropdownList() throws InterruptedException {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraTrangThaiMacDinhDropdownEventType();
        Assert.assertEquals(6,driver.findElements(rise.valueOption).size());
    }
    @Test
    public void EventType07_KiemTraLeaveType() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangGiaTriLeave();
        Assert.assertTrue(rise.leaveActive.isDisplayed());
        pause(3000);
        // kiểm tra chỉ hiển thị leave
        isElementPresent(CT_Rise.Team2_EventsType);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_LeaveType).isDisplayed());
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);
    }
    @Test
    public void EventType08_KiemTraTaskstartdateType() throws InterruptedException {
        Thread.sleep(3000);
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangGiaTriTaskstartdate();
        Assert.assertTrue(rise.taskstartdateActive.isDisplayed());
        pause(3000);
        // kiểm tra chỉ hiển thị Task start date
        isElementPresent(CT_Rise.Team2_EventsType);
        isElementPresent(CT_Rise.Team2_LeaveType);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_TasksStartdateType).isDisplayed());
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);
    }
    @Test
    public void EventType09_KiemTraTaskdeadlineType() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangGiaTriTaskdeadline();
        Assert.assertTrue(rise.taskdeadlineActive.isDisplayed());
        pause(3000);
        // kiểm tra chỉ hiển thị Taskdead line
        isElementPresent(CT_Rise.Team2_EventsType);
        isElementPresent(CT_Rise.Team2_LeaveType);
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_TaskDeadlineType).isDisplayed());
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);

    }
    @Test
    public void EventType10_KiemTraProjectstartdateType() throws InterruptedException {
        Thread.sleep(3000);
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangGiaTriProjectstartdate();
        Assert.assertTrue(rise.projectstartdateActive.isDisplayed());
        pause(3000);
        // kiểm tra chỉ hiển thị Project start date
        isElementPresent(CT_Rise.Team2_EventsType);
        isElementPresent(CT_Rise.Team2_LeaveType);
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_ProjectStartdateType).isDisplayed());
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);


    }
    @Test
    public void EventType11_KiemTraProjectdeadlineType() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangGiaTriProjectdeadline();
        Assert.assertTrue(rise.projectdeadlineActive.isDisplayed());
        pause(3000);
        // kiểm tra chỉ hiển thị Project deadline
        isElementPresent(CT_Rise.Team2_EventsType);
        isElementPresent(CT_Rise.Team2_LeaveType);
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_ProjectDeadlineType).isDisplayed());


    }
    @Test
    public void EventType12_KiemTraKhiChonTatCaGiaTriTrongDropdownList() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangKhiChonTatCaGiaTriTrongDropdownlist();
        pause(3000);
        // Kiểm tra đã chọn tất cả giá trị trong Event Type
        Assert.assertTrue(rise.eventsActive.isDisplayed());
        Assert.assertTrue(rise.leaveActive.isDisplayed());
        Assert.assertTrue(rise.taskstartdateActive.isDisplayed());
        Assert.assertTrue(rise.taskdeadlineActive.isDisplayed());
        Assert.assertTrue(rise.projectstartdateActive.isDisplayed());
        Assert.assertTrue(rise.projectdeadlineActive.isDisplayed());
        // kiểm tra 6 Event
        pause(3000);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_EventsType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_LeaveType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_TasksStartdateType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_TaskDeadlineType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_ProjectStartdateType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_ProjectDeadlineType).isDisplayed());


    }
    @Test
    public void EventType13_KiemTraKhiHuyChonTatCaGiaTriTrongDropdownList() {
        PageLocator_Rise rise = new PageLocator_Rise(driver);
        rise.KiemTraChucNangKhiChonTatCaGiaTriTrongDropdownlist();
        pause(3000);
        // kiểm tra 6 giá trị eventtype đã được  chọn
        Assert.assertTrue(rise.eventsActive.isDisplayed());
        Assert.assertTrue(rise.leaveActive.isDisplayed());
        Assert.assertTrue(rise.taskstartdateActive.isDisplayed());
        Assert.assertTrue(rise.taskdeadlineActive.isDisplayed());
        Assert.assertTrue(rise.projectstartdateActive.isDisplayed());
        Assert.assertTrue(rise.projectdeadlineActive.isDisplayed());
        // kiểm tra 6 sự kiện trên bảng Event Canlendar đã hiển thị
        pause(3000);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_EventsType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_LeaveType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_TasksStartdateType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_TaskDeadlineType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_ProjectStartdateType).isDisplayed());
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_ProjectDeadlineType).isDisplayed());
        rise.KiemTraChucNangKhiHuyChonTatCaGiaTriTrongDropdownlist();
        // kiểm tra chỉ còn lại sự kiện mặc định trên bảng Event Canlendar được hiển thị
        pause(3000);
        Assert.assertTrue(driver.findElement(CT_Rise.Team2_EventsType).isDisplayed());
        isElementPresent(CT_Rise.Team2_LeaveType);
        isElementPresent(CT_Rise.Team2_TasksStartdateType);
        isElementPresent(CT_Rise.Team2_TaskDeadlineType);
        isElementPresent(CT_Rise.Team2_ProjectStartdateType);
        isElementPresent(CT_Rise.Team2_ProjectDeadlineType);

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.close();
    }
}
