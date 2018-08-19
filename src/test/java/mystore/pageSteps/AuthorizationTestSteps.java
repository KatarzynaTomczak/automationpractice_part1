package mystore.pageSteps;

import config.WebDriverConfig;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import mystore.pageObjects.AuthenticationAccount;
import mystore.pageObjects.MainPage;
import org.junit.Assert;


public class AuthorizationTestSteps extends WebDriverConfig {

    private MainPage mainPage;
    private AuthenticationAccount authenticationAccount;

    public AuthorizationTestSteps(){
        mainPage = new MainPage(driver);
        authenticationAccount = new AuthenticationAccount(driver);
    }

    @Given("^I am on authentication page$")
    public void I_am_on_authentication_page() throws Exception {
        mainPage.getUrl();
        authenticationAccount.getSignInButton().click();
    }

    @When("^I will enter correct email address$")
    public void I_will_enter_correct_email_address() throws Exception {
        authenticationAccount.timeOut();
        authenticationAccount.getInputEmailForAuthorization().sendKeys("test7@op.pl");
    }

    @When("^I will enter correct password$")
    public void I_will_enter_correct_password() throws Throwable {
        authenticationAccount.getInputPasswordForAuthorization().sendKeys("Test123!!");
    }

    @When("^I will click on Sign button$")
    public void I_will_click_on_Sign_button() throws Throwable {
        authenticationAccount.getLoginButton().click();
    }

    @Then("^I should be on my account")
    public void I_should_be_on_my_account() {
        authenticationAccount.timeOut();
        Assert.assertTrue(authenticationAccount.isContain("My account"));
        authenticationAccount.getSignOutButton().click();
        mainPage.quite();
    }

    //negative scenario
    @When("^I will enter invalid email address$")
    public void I_will_enter_invalid_email_address() throws Throwable {
        authenticationAccount.getInputEmailForAuthorization().sendKeys("test@test.test");
    }

    @Then("^I should not be login$")
    public void I_should_not_be_login() {
        Assert.assertTrue(authenticationAccount.isContain("Authentication"));
    }

    @Then("^I receive error message$")
    public void I_receive_error_message() throws Throwable {
        Assert.assertTrue(authenticationAccount.isContain("Authentication failed"));
        mainPage.quite();
    }

    @When("^I will enter null password$")
    public void I_will_enter_null_password() throws Throwable {
        authenticationAccount.getInputPasswordForAuthorization().sendKeys("");
    }

    @Then("^I receive error message_password$")
    public void I_receive_error_message_password() throws Throwable {
        Assert.assertTrue(authenticationAccount.isContain("Password is required"));
        mainPage.quite();
    }
}
