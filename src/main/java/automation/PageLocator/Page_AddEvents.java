package automation.PageLocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_AddEvents {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement passwork;
    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signinButton;

    @FindBy(xpath = "//span[text()='Events']//parent::a//parent::li")
    public  WebElement eventsButton;
    @FindBy(xpath = "//a[contains(text(),' Add event')]")
    private WebElement addEventButton;
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleText;
    @FindBy(xpath = "//button[text()=' Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[text()='Projects']//parent::a//parent::li")
    private WebElement projectsButton;
    @FindBy(xpath = "//a[contains(text(),' Add project')]")
    private WebElement addProjecttButton;

    @FindBy(xpath = "//span[text()='Tasks']//parent::a//parent::li")
    private WebElement tasksButton;
    @FindBy(xpath = "//a[contains(text(),' Add task')]")
    private WebElement addTaskButton;
    @FindBy(xpath = "//div[@id='s2id_project_id']")
    private WebElement selectProject;
    @FindBy(xpath = "(//div[text()='Team2ProjectStartdateType'])[1]")
    private WebElement optionProject;

    @FindBy(xpath = "//span[text()='Team']//parent::a//parent::li")
    private WebElement teamButton;
    @FindBy(xpath = "//span[text()='Leave']//parent::a//parent::li")
    private WebElement leaveButton;
    @FindBy(xpath = "//a[contains(text(),' Assign leave')]")
    private WebElement addAssignLeave;
    @FindBy(xpath = "//div[@id='s2id_applicant_id']")
    private WebElement selectTeammember;
    @FindBy(xpath = "//div[text()='John Doe ']")
    private WebElement optionJohnDoe;
    @FindBy(xpath = "//div[@id='s2id_leave_type_id']")
    private WebElement selectLeavetype;
    @FindBy(xpath = "//div[text()='Maternity Leave ']")
    private WebElement optionMaternityLeave;
    @FindBy(xpath = "//textarea[@id='reason']")
    private WebElement reasonText;
    @FindBy(xpath = "//button[text()=' Assign leave']")
    private WebElement saveAssignleave;








    public Page_AddEvents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void LoginRise(String email_, String passwork_) {
        email.clear();
        email.sendKeys(email_);
        passwork.clear();
        passwork.sendKeys(passwork_);
        signinButton.click();
    }

    public void AddEventsType(String Titlename,String Date) throws InterruptedException {
        eventsButton.click();
        addEventButton.click();
        Thread.sleep(5000);
        titleText.sendKeys(Titlename);
        WebElement dateBox = driver.findElement(
                By.xpath("//input[@id='start_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dateBox);
        dateBox.clear();
        dateBox.sendKeys(Date);
        dateBox.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        saveButton.click();
    }

    public void AddProjectStartDateType(String Titlename,String Date) throws InterruptedException {
        projectsButton.click();
        addProjecttButton.click();
        Thread.sleep(5000);
        titleText.sendKeys(Titlename);
        WebElement startDate = driver.findElement(
                By.xpath("//input[@id='start_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", startDate);
        startDate.clear();
        startDate.sendKeys(Date);
        startDate.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        saveButton.click();
    }
    public void AddProjectDeadlineType(String Titlename,String Date) throws InterruptedException {
        projectsButton.click();
        addProjecttButton.click();
        Thread.sleep(5000);
        titleText.sendKeys(Titlename);
        Thread.sleep(3000);
        WebElement endDate = driver.findElement(
                By.xpath("//input[@id='deadline']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", endDate);
        endDate.clear();
        endDate.sendKeys(Date);
        endDate.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        saveButton.click();
    }
    public void AddTaskStartDateType(String Titlename,String Date) throws InterruptedException {
        tasksButton.click();
        addTaskButton.click();
        Thread.sleep(2000);
        titleText.sendKeys(Titlename);
        Thread.sleep(2000);
        selectProject.click();
        optionProject.click();
        Thread.sleep(2000);
        WebElement startDate = driver.findElement(
                By.xpath("//input[@id='start_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", startDate);
        startDate.clear();
        startDate.sendKeys(Date);
        startDate.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        saveButton.click();
    }
    public void AddTaskDeadlineType(String Titlename,String Date) throws InterruptedException {
        tasksButton.click();
        addTaskButton.click();
        Thread.sleep(2000);
        titleText.sendKeys(Titlename);
        Thread.sleep(2000);
        selectProject.click();
        optionProject.click();
        Thread.sleep(2000);
        WebElement endDate = driver.findElement(
                By.xpath("//input[@id='deadline']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", endDate);
        endDate.clear();
        endDate.sendKeys(Date);
        endDate.sendKeys(Keys.TAB);
        Thread.sleep(2000);
        saveButton.click();
    }
    public void AddLeaveType(String Reason,String Date) throws InterruptedException {
        teamButton.click();
        Thread.sleep(2000);
        leaveButton.click();
        Thread.sleep(2000);
        addAssignLeave.click();
        Thread.sleep(3000);
        selectTeammember.click();
        Thread.sleep(2000);
        optionJohnDoe.click();
        Thread.sleep(2000);
        selectLeavetype.click();
        Thread.sleep(2000);
        optionMaternityLeave.click();
        Thread.sleep(5000);
        WebElement dateBox = driver.findElement(
                By.xpath("//input[@id='single_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dateBox);
        dateBox.clear();
        dateBox.sendKeys(Date);
        dateBox.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        reasonText.sendKeys(Reason);
        saveAssignleave.click();
    }
}
