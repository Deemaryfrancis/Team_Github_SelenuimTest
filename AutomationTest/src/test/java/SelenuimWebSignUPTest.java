import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelenuimWebSignUPTest {

    //Import selenuimdriver
    private WebDriver driver;
    @BeforeTest

    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open Chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium Demo Page URL (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");
        //Testcase 1. Verify that when user clicks on the signup button, the user is directed to the signup page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            System.out.println("Pass - Current URL displayed" );
        else
            System.out.println("Fail");
        //Wait globally for full loading
        Thread.sleep(5000);
        //3. Maximise the browser
        driver.manage().window().maximize();
    }

    @Test (priority = 0)
    public void PositiveTest() throws InterruptedException {
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            System.out.println("Pass - Current URL displayed" );
        else
            System.out.println("Fail");
        //4. Click SignUp
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Enter UserName
        driver.findElement(By.id("user_username")).sendKeys("minniedion29ba");
        //6. Enter EmailAddress
        driver.findElement(By.id("user_email")).sendKeys("minniedion29ba@mailinator.com");
        //7. Enter Password
        driver.findElement(By.id("user_password")).sendKeys("Minnie");
        //8. Click SignUp
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        //TestCase 7. Verify that user is successfully signed up when valid details are inputted.
            //a. Locate the web element
        WebElement s = driver.findElement(By.id("flash_success"));
            //b. assign variables
        String ExpectedSuccessMessage = "Welcome to the alpha blog ";
        String ActualSuccessMessage = s.getText();
            //c. Compare result
        if(ActualSuccessMessage.contains(ExpectedSuccessMessage))
            System.out.println("Pass - User successfully SignUP,a success message is displayed which says '" + ActualSuccessMessage + "'");
        else
            System.out.println("Failed - User cannot SignUP");
        //Test 8. Verify that User1 item is present on the item list page
            //a. Locate web element
        WebElement sp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a"));
            //b. assign variables
        String ExpectedSearchResult1 = "user1";
        String ActualSearchResult1 = sp.getText();
            //c. Compare result
        if(ActualSearchResult1.contains(ExpectedSearchResult1))
            System.out.println("Pass - User1 is found");
        else
        System.out.println("Failed - User1 is not found");
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void SelectUser1() throws InterruptedException {
        //9. Select User1
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
        //TestCase 9. Verify that Learn Xpath is present.
            //a. Locate web element
        WebElement sp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a"));
            //b. assign variables
        String ExpectedSearchResult2 = "Learn Xpath";
        String ActualSearchResult2 = sp.getText();
            //c. Compare result
        if(ActualSearchResult2.contains(ExpectedSearchResult2))
            System.out.println("Pass - Learn Xpath is found");
        else
            System.out.println("Failed - Learn Xpath is not found");
        //10.
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(5000);
        //11 LogOut
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //TestCase 10. Verify that when the user logout, he/she is directed back to the home page
            //a. assign variables
        String ExpectedWebUrl = "https://selenium-blog.herokuapp.com/";
        String ActualWebUrl = driver.getCurrentUrl();
            //b. Compare result
        if(ActualWebUrl.contains(ExpectedWebUrl))
            System.out.println("Pass - User successfully logout");
        else
            System.out.println("Failed - User cannot log out");
    }

    @Test (priority = 2)
    public void UsernameLess3() throws InterruptedException {
        //1. To refresh page
        driver.get("https://selenium-blog.herokuapp.com");
        driver.get(driver.getCurrentUrl());
        //2. Click SignUp
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //3. Enter UserName
        driver.findElement(By.id("user_username")).sendKeys("mi");
        //4. Enter EmailAddress
        driver.findElement(By.id("user_email")).sendKeys("minniedion4pa@mailinator");
        //5. Enter Password
        driver.findElement(By.id("user_password")).sendKeys("Minnie");
        //6. Click SignUp
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
        //TestCase 3. Verify that user cannot signup with username less than 3 characters
            //a. Locate the web element
        WebElement s = driver.findElement(By.className("panel-body"));
            //b. assign variables
        String Expectederrormessage = "Username is too short (minimum is 3 characters)";
        String Actualerrormessage = s.getText();
            //c. Compare result
        if(Actualerrormessage.contains(Expectederrormessage))
            System.out.println("Pass - User cannot SignUP, an error message is displayed which says '" + Actualerrormessage);
        else
            System.out.println("Failed - Actual error message is:" + Actualerrormessage);
        Thread.sleep(5000);
        //9 Click SignUp on Header
    }

    @Test (priority = 3)
    public void InvalidEmail() throws InterruptedException {
        //1. To refresh page
        driver.get("https://selenium-blog.herokuapp.com");
        driver.get(driver.getCurrentUrl());
        //4. Click SignUp
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Enter UserName
        driver.findElement(By.id("user_username")).sendKeys("minniedion1b");
        //6. Enter EmailAddress
        driver.findElement(By.id("user_email")).sendKeys("minniedion1b@mailinator");
        //7. Enter Password
        driver.findElement(By.id("user_password")).sendKeys("Minnie");
        //8. Click SignUp
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
        //TestCase 4. Verify user cannot signup with invalid email address
            //a. Locate the web element
        WebElement s = driver.findElement(By.className("panel-body"));
            //b. assign variables
        String ExpectedWebUrl = "https://selenium-blog.herokuapp.com/users";
        String ActualWebUrl = driver.getCurrentUrl();
        String ActualErrorMessage = s.getText();
            //c. Compare result
        if(ActualWebUrl.contains(ExpectedWebUrl))
            System.out.println("Pass - User cannot SignUP, an error message is displayed which says '" + ActualErrorMessage);
        else
            System.out.println("Failed - User successfully SignUP");
        Thread.sleep(5000);

    }

    @Test (priority = 4)
    public void PassWordEq1() throws InterruptedException {
        //1. Locate URL
        driver.get("https://selenium-blog.herokuapp.com");
        driver.get(driver.getCurrentUrl());
        //2. Click SignUp
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //3. Enter UserName
        driver.findElement(By.id("user_username")).sendKeys("minniedion6c");
        //4. Enter EmailAddress
        driver.findElement(By.id("user_email")).sendKeys("minniedion6c@mailinator.com");
        //5. Enter Password
        driver.findElement(By.id("user_password")).sendKeys("M");
        //6. Click SignUp
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
        //TestCase 5. Verify user cannot login with password less than or equal to one character
            //a. Locate the web element
        //WebElement s = driver.findElement(By.className("panel-body"));
            //b. assign variables
        String ExpectedWebUrl = "https://selenium-blog.herokuapp.com/users";
        String ActualWebUrl = driver.getCurrentUrl();
        //String ActualErrorMessage = s.getText();
            //c. Compare result
        if(ActualWebUrl.contains(ExpectedWebUrl))
            System.out.println("Pass - User cannot SignUP, an error message is displayed");
        else
            System.out.println("Failed - User successfully SignUP with password equal to 1");
        Thread.sleep(5000);
        //9 Click SignUp on Header

    }

    @Test (priority = 5)
    public void BlankFields() throws InterruptedException {
        //1. Locate URL
        driver.get("https://selenium-blog.herokuapp.com");
        driver.get(driver.getCurrentUrl());
        //4. Click SignUp
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Enter UserName
        driver.findElement(By.id("user_username")).sendKeys(" ");
        //6. Enter EmailAddress
        driver.findElement(By.id("user_email")).sendKeys("minniedion1d@mailinator.com");
        //7. Enter Password
        driver.findElement(By.id("user_password")).sendKeys("Minnie");
        //8. Click SignUp
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
        //TestCase 6. Verify user cannot signup with either/all of the fields blank
            //a. Locate the web element
        WebElement s = driver.findElement(By.className("panel-body"));
            //b. assign variables
        String ExpectedWebUrl = "https://selenium-blog.herokuapp.com/users";
        String ActualWebUrl = driver.getCurrentUrl();
        String ActualErrorMessage = s.getText();
            //c. Compare result
        if(ActualWebUrl.contains(ExpectedWebUrl))
            System.out.println("Pass - User cannot SignUP, an error message is displayed which says '" + ActualErrorMessage);
        else
            System.out.println("Failed - User successfully SignUP");
        Thread.sleep(5000);
        //9 Click SignUp on Header
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
    }

    @AfterTest
    public void closeBroswer() {
        //Quit browser
        driver.quit();
    }
}
