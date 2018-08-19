package mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parameters.DataUtility;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getLogin(){
        return driver.findElement(By.xpath("//a[@class='login']"));
    }

    public void getUrl(){
        driver.get(DataUtility.TESTED_URL);
    }

    public void quite(){
        driver.quit();
    }

}
