package mystore.pageSteps;

import config.WebDriverConfig;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import mystore.pageObjects.AuthenticationAccount;
import mystore.pageObjects.MainPage;
import mystore.repository.EmailRepo;
import org.junit.Assert;

public class RegistrationTestSteps extends WebDriverConfig {

    private MainPage mainPage;
    private AuthenticationAccount authenticationAccount;

    public RegistrationTestSteps(){
        mainPage = new MainPage(driver);
        authenticationAccount = new AuthenticationAccount(driver);
    }

    @Given("^I am on registration page$")
    public void I_am_on_registration_page() throws Exception {
        mainPage.getUrl();
        mainPage.getLogin().click();
    }

    @When("^I will enter correct email$")
    public void I_will_enter_correct_email() throws Exception {
        authenticationAccount.getInputEmailForRegistration().sendKeys(authenticationAccount.getRandomEmail());
    }

    @When("^I will click on create account button$")
    public void I_will_click_on_create_account_button() throws Exception{
        authenticationAccount.getCreateButton().click();
    }

    @Then("^I should be on your personal information page$")
    public void I_should_be_on_your_personal_information_page()throws Exception {
        authenticationAccount.timeOut();
        Assert.assertTrue(authenticationAccount.getYourPersonalInformationText().isDisplayed());
    }

    @Given("^I am on personal information page$")
    public void I_am_on_personal_information_page() throws Exception {
        Assert.assertTrue(authenticationAccount.isContain("Create an account"));
    }

    @When("^I will enter correct data$")
    public void I_will_enter_correct_data() {
        authenticationAccount.getInputFirstName().sendKeys("Test");
        authenticationAccount.getInputLastName().sendKeys("Test");
        authenticationAccount.getInputPassword().sendKeys("Test123!!");
        authenticationAccount.getOptionState().click();
        authenticationAccount.getInputAddress().sendKeys("Test123");
        authenticationAccount.getInputCity().sendKeys("Warszawa");
        authenticationAccount.getInputPostCode().sendKeys("12345");
        authenticationAccount.getInputMobilePhone().sendKeys("12345");
        authenticationAccount.getInputAlias().sendKeys("");
    }

    @When("^I will click on Register button$")
    public void I_will_click_on_Register_button() {
        authenticationAccount.getAccountButton().click();
    }

    @Then("^I should be on my account page$")
    public void I_should_be_on_my_account_page() {
        Assert.assertTrue(authenticationAccount.isContain("My account"));
    }

    @Then("^I should avaliable SignOut button$")
    public void I_should_avaliable_SignOut_buttons() {
         Assert.assertTrue(authenticationAccount.getSignOutButton().isDisplayed());
         mainPage.quite();
     }

    @When("^I will enter existing email$")
    public void I_will_enter_existing_email() throws Throwable {
        EmailRepo emailRepo = EmailRepo.getInstance();
        String usageEmail = emailRepo.getEmailTree().first();
        authenticationAccount.getInputEmailForRegistration().sendKeys(usageEmail);
    }

    @Then("^I should receive error message$")
    public void I_should_receive_error_message() throws Exception {
        authenticationAccount.timeOut();
        Assert.assertTrue(authenticationAccount.getCreateAccountErrorText().isDisplayed());
        mainPage.quite();
    }

    @Given("^I am on CREATE AN ACCOUNT page$")
    public void I_am_on_CREATE_AN_ACCOUNT_page() throws Exception {
        Assert.assertTrue(authenticationAccount.getCreateAccountText().isDisplayed());
    }
    @Then("^I should LogOut$")
    public void I_should_LogOut() throws Throwable {
        authenticationAccount.getSignOutButton().click();
    }

}
