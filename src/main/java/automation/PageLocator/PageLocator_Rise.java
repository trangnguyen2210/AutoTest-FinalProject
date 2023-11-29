package automation.PageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLocator_Rise {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement passwork;
    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signinButton;
    @FindBy(xpath = "//span[text()='Events']//parent::a//parent::li")
    private WebElement eventsButton;


    @FindBy(xpath = "//button[text()='Event type ']//parent::span")
    public WebElement eventTypeButton;
    @FindBy(xpath = "//div[@class='dropdown-menu show']")
    public WebElement dropdownMenu;
    public By valueOption = By.xpath("//li[@data-name='undefined']");
    @FindBy(xpath = "//li[text()='Events']")
    private WebElement eventsValue;
    @FindBy(xpath = "//li[text()='Events' and @class='list-group-item clickable  active']")
    public WebElement eventsActive;
    @FindBy(xpath = "//li[text()='Leave']")
    private WebElement leaveValue;
    @FindBy(xpath = "//li[contains(@class,'clickable active') and text()='Leave']")
    public WebElement leaveActive;
    @FindBy(xpath = "//li[text()='Task start date']")
    private WebElement taskStartDateValue;
    @FindBy(xpath = "//li[contains(@class,'clickable active') and text()='Task start date']")
    public WebElement taskstartdateActive;
    @FindBy(xpath = "//li[text()='Task deadline']")
    private WebElement taskDeadlineValue;
    @FindBy(xpath = "//li[contains(@class,'clickable active') and text()='Task deadline']")
    public WebElement taskdeadlineActive;
    @FindBy(xpath = "//li[text()='Project start date']")
    private WebElement projectStartDateValue;
    @FindBy(xpath = "//li[contains(@class,'clickable active') and text()='Project start date']")
    public WebElement projectstartdateActive;
    @FindBy(xpath = "//li[text()='Project deadline']")
    private WebElement projectDeadlineValue;
    @FindBy(xpath = "//li[contains(@class,'clickable active') and text()='Project deadline']")
    public WebElement projectdeadlineActive;




    @FindBy(xpath = "//span[@class='fc-icon fc-icon-chevron-right']//parent::button")
    public WebElement rightButton;
    @FindBy(xpath = "//button[text()='today']")
    public WebElement todayButton;
    @FindBy(xpath = "//button[text()='month']")
    public WebElement monthButton;
    @FindBy(xpath = "//button[text()='week']")
    public WebElement weekButton;
    @FindBy(xpath = "//button[text()='day']")
    public WebElement dayButton;
    @FindBy(xpath = "//button[text()='list']")
    public WebElement listButton;
    @FindBy(xpath = "//h2[text()='December 2023']")
    public WebElement december2023text;
    @FindBy(xpath = "//div[contains(@class,'dayGridMonth')]")
    public WebElement dayGridMonth;
    @FindBy(xpath = "//div[contains(@class,'timeGridWeek')]")
    public WebElement timeGridWeek;
    @FindBy(xpath = "//div[contains(@class,'timeGridDay')]")
    public WebElement timeGridDay;
    @FindBy(xpath = "//div[contains(@class,'listMonth')]")
    public WebElement listMonth;



    @FindBy(xpath = "//span[text()=' Team2_Test01']")
    public WebElement test01Events;
    @FindBy(xpath = "//span[text()=' Team2_Test02']")
    public WebElement test02Events;





    public PageLocator_Rise(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void EventsPage(String email_, String passwork_) {
        email.clear();
        email.sendKeys(email_);
        passwork.clear();
        passwork.sendKeys(passwork_);
        signinButton.click();
        eventsButton.click();
    }
    public void KiemTraTrangThaiMacDinhDropdownEventType()  {

        eventTypeButton.click();
    }
    public void KiemtrahienthikhikhongchongiatritrongDropdownList(){

        eventTypeButton.click();
        eventsValue.click();
    }

    public void KiemTraChucNangGiaTriLeave(){
        eventTypeButton.click();
        eventsValue.click();
        leaveValue.click();
    }
    public void KiemTraChucNangGiaTriTaskstartdate()  {
        eventTypeButton.click();
        eventsValue.click();
        taskStartDateValue.click();
    }
    public void KiemTraChucNangGiaTriTaskdeadline(){
        eventTypeButton.click();
        eventsValue.click();
        taskDeadlineValue.click();
    }
    public void KiemTraChucNangGiaTriProjectstartdate() {
        eventTypeButton.click();
        eventsValue.click();
        projectStartDateValue.click();
    }
    public void KiemTraChucNangGiaTriProjectdeadline(){
        eventTypeButton.click();
        eventsValue.click();
        projectDeadlineValue.click();
    }
    public void KiemTraChucNangKhiChonTatCaGiaTriTrongDropdownlist(){
        eventTypeButton.click();
        leaveValue.click();
        taskStartDateValue.click();
        taskDeadlineValue.click();
        projectStartDateValue.click();
        projectDeadlineValue.click();
    }
    public void KiemTraChucNangKhiHuyChonTatCaGiaTriTrongDropdownlist(){
        eventsValue.click();
        leaveValue.click();
        taskStartDateValue.click();
        taskDeadlineValue.click();
        projectStartDateValue.click();
        projectDeadlineValue.click();
    }


}
