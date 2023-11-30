	package automation.PageLocator;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Project_Login {

	private WebDriver driver;
	
		@FindBy(id="email")
		private WebElement Dangki;
	
		@FindBy(id="password")
		private WebElement password;
		
		@FindBy(xpath="//button[text()='Sign in']")
		private WebElement signinButton;
		
		@FindBy(xpath="//span[text()='Events']//parent::a//parent::li")
		private WebElement eventsButton;
		
		@FindBy(xpath="//a[text()=' Add event']")
		private WebElement AddEvent;
		
		@FindBy(xpath = "//input[@id='title']")
		private WebElement inputTitle;
		
		@FindBy(xpath = "//div[@role='textbox']")
		private WebElement inputDescription;
		
		@FindBy(xpath = "//input[@id='start_date']")
		private WebElement inputStartdate;
		
		@FindBy(xpath = "//input[@id='end_date']")
		private WebElement inputEnddate;
		
		@FindBy(xpath = "//button[text()=' Save']")
		private WebElement buttonSave;
		
		@FindBy(xpath = "//td[@data-date='2023-11-30']//descendant::span[text()=' hihihi']")
		private WebElement hihihiEvent;
		
		@FindBy(xpath = "//a[text()=' Edit event']")
		private WebElement buttonEditEvent;
		
		@FindBy(xpath = "//td[@data-date='2023-11-29']//descendant::span[text()=' hahaha']")
		private WebElement HahahaEvent;
		
		@FindBy(xpath ="//div/a[text()=' Delete event']")
		private WebElement buttonDelete;
		
		@FindBy(xpath = "//a[text()=' Edit event']")
		private WebElement buttonYesDelete;
		
		
		public Project_Login(WebDriver driver)
		{
	        this.driver = driver;
	        PageFactory.initElements(driver,this);
	    }
		//phuong thuc eventsPage de di den trang Event
	    public void EventsPage(String email_, String passwork_)
	    {
	        Dangki.clear();
	        Dangki.sendKeys(email_);
	        password.clear();
	        password.sendKeys(passwork_);
	        signinButton.click();
	        eventsButton.click();
	    }	
		
	    //tao phuong thuc moi de tao moi event, de phuc vu cho viec ben testsuite chi can goi ra 
	    public void AddEvent(String title, String Date) throws InterruptedException //khi minh goi truyen thong tin vao title
	    {
	    	//click vao Add event , addevent la goi o ben tren dong 29
	    	AddEvent.click();
	    	//tam dung 5s
	    	Thread.sleep(5000);
	    	inputTitle.sendKeys(title);
	    	
	    	WebElement startDate = driver.findElement(
	                By.xpath("//input[@id='start_date']"));
	    	//ham js nay de nhap ngay thang 
	        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", startDate);
	        startDate.clear();
	        startDate.sendKeys(Date);
	        //the same enter 
	        startDate.sendKeys(Keys.TAB);
	        buttonSave.click();
	        
	    }
	    
	    public void EditEvent(String Title, String Date) throws InterruptedException
	    {
	    	hihihiEvent.click();
	    	Thread.sleep(5000);
	    	buttonEditEvent.click();
	    	//tien hanh xoa du lieu trong o title
	    	Thread.sleep(5000);
	    	inputTitle.clear();
	    	//truyen du lieu moi vao title, ti nua sang ben testsuite se nhap vao sau
	    	Thread.sleep(5000);
	    	inputTitle.sendKeys(Title);
	    	
	    	//nay de tien hanh xoa du lieu ngay thang va truyen du lieu ngay thang
	    	WebElement startDate = driver.findElement(
	                By.xpath("//input[@id='start_date']"));
	    	//ham js nay de nhap ngay thang 
	        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", startDate);
	        startDate.clear();
	        startDate.sendKeys(Date);
	        buttonSave.click();
	        
	    }
	    
	    public void DeleteEvent()
	    {
	    	HahahaEvent.click();
	    	buttonDelete.click();
	    	buttonYesDelete.click();
	    	
	    }
	   
	
	
	}
