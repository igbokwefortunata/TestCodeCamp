import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("web-driver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        // Test1. Verify the user input the right url and is on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage ");
            else
                //fail
           System.out.println("Wrong Webpage");

        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();

    }

    @Test (priority =0)
             public void positiveSignup () throws InterruptedException {
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test7. Verify that user is successfully signed up when valid details are inputted
         //5. input your username on the username field
         driver.findElement(By.id("user_username")).sendKeys("fortune600");
         Thread.sleep(5000);
         //6. locate the email address field and input an email address on the email field
         driver.findElement(By.id("user_email")).sendKeys("chizitere208@mailinator.com");
         Thread.sleep(5000);
         //7. locate the password field and input your password on the password field
         driver.findElement(By.id("user_password")).sendKeys("admin");
         Thread.sleep(5000);
         //8. click on the signup button
         driver.findElement(By.id("submit")).click();
         Thread.sleep(5000);
     }
    @Test (priority =1 )
    public void user1 () throws InterruptedException {
        //9. click on the username item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
        //Test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage ");
        else
            //fail
            System.out.println("Wrong Webpage");


        Thread.sleep(5000);
    }

    @Test (priority =2)
            public void Xpath () throws InterruptedException {
                //10. search for an item(using python with selenium) and confirm it is present
                driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            //Test9. Verify that the item searched for on the user1 page is present
                String expectedTitle = "/users/1";
                String actualTitle = driver.getTitle();
                if (actualTitle.contains(expectedTitle))
                    //pass
                    System.out.println("Correct Webpage ");
                else
                    //fail
                    System.out.println("Wrong Webpage");

                Thread.sleep(5000);

            }

        @Test (priority =3)
            public void logout () {
                //11. click on logout
                driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
                //Test10. Verify that when the user logout he/she is directed back to the home page
                String expectedTitle = "AlphaBlog";
                String actualTitle = driver.getTitle();
                if (expectedTitle.contains(actualTitle))
                    //pass
                    System.out.println("Correct Webpage ");
                else
                    //fail
                    System.out.println("Wrong Webpage");


            }
                @Test (priority =4)
                public void negativeSignup () throws InterruptedException {

                    //4. Click on Signup button to open the Signup page
                    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
                    Thread.sleep(5000);
                    //Test3. Verify that user cannot signup with username less than 3 characters
                    //5. input your username on the username field
                    driver.findElement(By.id("user_username")).sendKeys("aa");
                    Thread.sleep(5000);
                    //6. locate the email address field and input an email address on the email field
                    driver.findElement(By.id("user_email")).sendKeys("chizitere68@mailinator.com");
                    Thread.sleep(5000);
                    //7. locate the password field and input your password on the password field
                    driver.findElement(By.id("user_password")).sendKeys("admin");
                    Thread.sleep(5000);
                    //8. click on the signup button
                    driver.findElement(By.id("submit")).click();
                    Thread.sleep(5000);

                }

                 @Test (priority =5)
                   public void Negativetest1 () throws InterruptedException {

                     driver.get("https://selenium-blog.herokuapp.com/signup");
                     Thread.sleep(5000);
                     //Test4. Verify that user cannot signup with invalid email address
                     //6. locate the email address field and input an email address on the email field
                     driver.findElement(By.id("user_email")).sendKeys("chie62@mailinator.com");
                     Thread.sleep(5000);
                     //7. locate the password field and input your password on the password field
                     driver.findElement(By.id("user_password")).sendKeys("admin");
                     Thread.sleep(5000);
                     //8. click on the signup button
                     driver.findElement(By.id("submit")).click();
                     Thread.sleep(5000);
                 }

                  @Test(priority = 6)
                  public void Negativetest2 () throws InterruptedException {

                      driver.get("https://selenium-blog.herokuapp.com/signup");
                      Thread.sleep(5000);
                      //Test5. Verify that user cannot login with password less than or equal to one character
                      //7. locate the password field and input your password on the password field
                      driver.findElement(By.id("user_password")).sendKeys("mi");
                      Thread.sleep(5000);
                      //8. click on the signup button
                      driver.findElement(By.id("submit")).click();
                      Thread.sleep(5000);
                  }

                      @Test (priority = 7)
                       public void Negativetest3 () throws InterruptedException {

                          driver.get("https://selenium-blog.herokuapp.com/signup");
                          Thread.sleep(5000);
                          //Test6. Verify that user cannot signup with either/all the fields blank
                          //6. locate the email address field and input an email address on the email field
                          driver.findElement(By.id("user_email")).sendKeys("");
                          Thread.sleep(5000);
                          //7. locate the password field and input your password on the password field
                          driver.findElement(By.id("user_password")).sendKeys("");
                          Thread.sleep(5000);
                          //8. click on the signup button
                          driver.findElement(By.id("submit")).click();
                          Thread.sleep(5000);
                  }


    @AfterTest
    public void closeBrowser() {
        // Quit the browser
        driver.quit();


    }

}