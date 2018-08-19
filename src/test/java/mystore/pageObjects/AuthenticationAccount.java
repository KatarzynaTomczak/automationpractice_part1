package mystore.pageObjects;

import mystore.repository.EmailRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AuthenticationAccount{

    private WebDriver driver;

  public AuthenticationAccount(WebDriver driver){
    this.driver = driver;
  }

  public WebElement getInputEmailForRegistration(){
     return driver.findElement(By.xpath("//input[@id='email_create']"));
  }

 public WebElement getInputEmailForAuthorization(){
  return driver.findElement(By.xpath("//input[@id='email']"));
 }

  public WebElement getInputFirstName(){
   return driver.findElement(By.xpath("//*[@id='account-creation_form']/div/div[2]/input [@id='customer_firstname']"));
  }

 public WebElement getInputLastName() {
  return driver.findElement(By.xpath("//input[@id='customer_lastname']"));
 }

 public WebElement getInputPassword(){
  return driver.findElement(By.xpath("//input[@id='passwd']"));
 }

 public WebElement getInputAddress(){
  return driver.findElement(By.name("address1"));
 }

 public WebElement getInputCity(){
  return driver.findElement(By.name("city"));
 }

 public WebElement getInputPasswordForAuthorization(){
  return driver.findElement(By.name("passwd"));
 }

 public WebElement getInputPostCode(){
  return driver.findElement(By.name("postcode"));
 }

 public WebElement getOptionState(){
  return driver.findElement(By.xpath("//*[@id='id_state']/option[2]"));
 }

 public WebElement getInputMobilePhone(){
  return driver.findElement(By.name("phone_mobile"));
 }

 public WebElement getInputAlias(){
  return driver.findElement(By.xpath("//input[@name='alias']"));
 }

  public WebElement getCreateAccountErrorText(){
   return driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li"));
  }

 public WebElement getCreateAccountText() {
  return driver.findElement(By.xpath("//h3[contains(.,'Create an account')]"));
 }

 public WebElement getYourPersonalInformationText(){
  return driver.findElement(By.xpath("//h3[contains(.,'Your personal information')]"));
 }


  public WebElement getAccountButton(){
    return driver.findElement(By.name("submitAccount"));
  }

  public WebElement getCreateButton(){
   return driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
  }

  public WebElement getSignOutButton(){
   return driver.findElement(By.xpath("//a[@class='logout']"));
  }

  public WebElement getSignInButton(){
   return driver.findElement(By.xpath("//a[@class='login']"));
  }

  public WebElement getLoginButton(){
   return driver.findElement(By.name("SubmitLogin"));
  }


  public boolean isContain(String pageText){
    return driver.getPageSource().contains(pageText);
 }

  public String getRandomEmail(){
    StringBuilder email = new StringBuilder(RandomStringUtils.randomAlphabetic(10));
    email.append("@op.com");
    saveEmail(email.toString());
    return email.toString();
  }

  public void saveEmail(String email){
    EmailRepo emailRepo = EmailRepo.getInstance();
    emailRepo.addEmail(email);
  }

  public void timeOut(){
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
}
