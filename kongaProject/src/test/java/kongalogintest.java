import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class kongalogintest {

private WebDriver driver;

   @BeforeTest
    public void setup () throws InterruptedException {
       //locate where the chromedriver is
       System.setProperty("web-driver.chrome.driver", "resources/chromedriver.exe");

       //. Open your Chrome browser
       driver = new ChromeDriver();
   }

   @Test (priority =0)
       public void Url () throws InterruptedException {
       //1. Input Konga Page URL (https://www.konga.com/)
       driver.get("https://www.konga.com/");

       // Test1. Validate that the user inputs, the right url and is on the right webpage
       if (driver.getCurrentUrl().contains("https://www.konga.com/"))
           //pass
           System.out.println("Correct Webpage ");
       else
           //fail
           System.out.println("Wrong Webpage");
       Thread.sleep(5000);
   }

       @Test (priority = 1)
          public void Maximize () throws InterruptedException {
       //2. Maximize the browser
        //Test2. verify that the user web browser maximizes
       driver.manage().window().maximize();
   }

       @Test (priority =2 )
         public void Title () throws InterruptedException {
       //3. Get page title
        //Test3. validate that user gets the page title
       System.out.println("Page title is : " + driver.getTitle());
       Thread.sleep(5000);

   }

   @Test (priority =3)
       public void Signin () throws InterruptedException {
           //4. Click on the sign-in/ log in button
           driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
           Thread.sleep(5000);

           //Test4. Verify that user is successfully signed in, when valid details are inputted

           //5. Input your email address
           driver.findElement(By.id("username")).sendKeys("fo************");
           Thread.sleep(5000);

           //6. Input your password
           driver.findElement(By.id("password")).sendKeys("ch*******");
           Thread.sleep(5000);

           //7. click on the log-in button
           driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
             Thread.sleep(5000);
       }


    @Test (priority = 4)
    public void  account ()  throws InterruptedException {
        //Test5. Verify that when a user clicks on my account it displays the options
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        String expectedUrl = "https://www.konga.com/account";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);

    }
    @Test (priority =5)
    public void logout () {
        //11. click on logout
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();

        //Test6. Validate that the user logo out successfully
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");

    }

    @AfterTest
    public void closeBrowser() {
        // Quit the browser
        driver.quit();
    }

    }