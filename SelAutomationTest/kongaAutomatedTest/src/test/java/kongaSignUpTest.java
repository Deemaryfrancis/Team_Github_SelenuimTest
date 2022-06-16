import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class kongaSignUpTest {
    //1. Import WebDriver
    private WebDriver driver;
    @BeforeTest

    //2. install chrome driver
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //a. Launch browser
        driver = new ChromeDriver();
        //3. Enter Web Url
        driver.get("https://konga.com/");
        Thread.sleep(5000);
        //a. Maximize window
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    public class testMe {
        @Test(priority = 0)
        public void ValidEmailAndPassword() throws InterruptedException {
            Thread.sleep(5000);
            //1. Navigate to Login Page
            //a. Click on Login/SignUp
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(5000);
            //Get Page Title
            String Pagetitle = driver.getTitle();
            System.out.println("The page title is : '" + Pagetitle + "'");
            //2. Enter Email, Password and Login
            //a. Email Address
            driver.findElement(By.id("username")).sendKeys(" ");
            //b. Enter Password
            driver.findElement(By.id("password")).sendKeys(" ");
            //3. Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
            //Test 1: Verify that user is successfully Login with Valid details
            WebElement sp = driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span"));
            String ExpectedText = "My Account";
            String ActualText = sp.getText();
            System.out.println(ActualText);
            if (ActualText.contains(ExpectedText))
                System.out.println("Pass: User Successfully Login");
            else
                System.out.println("Failed: User unable to Login with valid details" + ActualText);
            //4. Click LogOut
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
            Thread.sleep(2000);
        }

        @Test(priority = 1)
        public void BlanksFields () throws InterruptedException {
            //Refresh webpage
            driver.get("https://www.konga.com/");
            driver.get(driver.getCurrentUrl());
            //1. Navigate to Login Page
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //2. Enter Email, Password and Login
            //a. Blank Email Field
            driver.findElement(By.id("username")).sendKeys(" ");
            //b. Blank Password Field
            driver.findElement(By.id("password")).sendKeys(" ");
            //c. Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
            //Test 3: Verify that user is unable to Login in with Blank Fields
            String ExpectedWebUrl = "https://www.konga.com/account/login?return_url=/";
            String ActualWebUrl = driver.getCurrentUrl();
            if (ActualWebUrl.contains(ExpectedWebUrl))
                System.out.println("Pass: User Unable to Login with blank fields");
            else
                System.out.println("Failed: User successfully Login with blank fields");
        }

        @Test(priority = 2)
        public void InvalidEmail () throws InterruptedException {
            //Refresh webpage
            driver.get("https://www.konga.com/");
            driver.get(driver.getCurrentUrl());
            //1. Navigate to Login Page
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //2. Enter Email, Password and Login
            //a. Enter Invalid Email Address
            driver.findElement(By.id("username")).sendKeys(" ");
            //b. Enter Password
            driver.findElement(By.id("password")).sendKeys(" ");
            //c. Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
            //Test 4: Verify that user is unable to Login in with invalid email
            WebElement sp = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div"));
            String ExpectedError = "The username or password you have entered is incorrect. Please try again.";
            String ActualError = sp.getText();
            if (ActualError.contains(ExpectedError))
                System.out.println("Pass: User Unable to Login. An error message is displayed that says: '" +ActualError + "'");
            else
                System.out.println("Failed: User successfully Login with invalid email");
        }
        @Test(priority = 3)
        public void WrongCombination () throws InterruptedException {
            //Refresh webpage
            driver.get("https://www.konga.com/");
            driver.get(driver.getCurrentUrl());
            //1. Navigate to Login Page
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //2. Enter Email, Password and Login
            //a. Correct Email Address
            driver.findElement(By.id("username")).sendKeys(" ");
            //b. Wrong Password
            driver.findElement(By.id("password")).sendKeys(" ");
            //c. Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
            //Test 5: Verify that user is unable to Login in with Blank Fields
            WebElement sp = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div"));
            String ExpectedError = "The username or password you have entered is incorrect. Please try again.";
            String ActualError = sp.getText();
            if (ActualError.contains(ExpectedError))
                System.out.println("Pass: User Unable to Login. An error message is displayed that says: '" +ActualError + "'");
            else
                System.out.println("Failed: User successfully Login with wrong password" + "");
        }
        @Test(priority = 4)
        public void NonExistingEmail () throws InterruptedException {
            //Refresh webpage
            driver.get("https://www.konga.com/");
            driver.get(driver.getCurrentUrl());
            //1. Navigate to Login Page
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //2. Enter Email, Password and Login
            //a. Not-existing Email Address
            driver.findElement(By.id("username")).sendKeys(" ");
            //b. Enter Password
            driver.findElement(By.id("password")).sendKeys(" ");
            //c. Click login
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(2000);
            //Test 6: Verify that user is unable to Login in with Blank Fields
            WebElement sp = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[1]/div"));
            String ExpectedError = "The username or password you have entered is incorrect. Please try again.";
            String ActualError = sp.getText();
            if (ActualError.contains(ExpectedError))
                System.out.println("Pass: User Unable to Login. An error message is displayed that says: '" +ActualError + "'");
            else
                System.out.println("Failed: User successfully Login with non existing email");
        }
        public void ForgotPassword() throws InterruptedException {
            driver.get("https://www.konga.com/");
            driver.get(driver.getCurrentUrl());
            //1. Navigate to Login Page
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            Thread.sleep(2000);
            //2. Enter Email, Password and Login
            //a. Blank Email Field
            driver.findElement(By.id("username")).sendKeys(" ");
            //b. Blank Password Field
            driver.findElement(By.id("password")).sendKeys(" ");
            //c. Click Forgot Password
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[1]/form/div[2]/label/a")).click();
            //Test 7: Verify that Forgot Password
            String ExpectedWebUrl = "https://www.konga.com/account/forgot-password";
            String ActualWebUrl = driver.getCurrentUrl();
            if (ActualWebUrl.contains(ExpectedWebUrl))
                System.out.println("Pass: The forgot password link is clickable");
            else
                System.out.println("Fail: The forgot password link is not clickable");
        }

        @AfterTest
        // Quit Browser
        public void QuitBrowser() {
        driver.quit();
        }
    }
}
