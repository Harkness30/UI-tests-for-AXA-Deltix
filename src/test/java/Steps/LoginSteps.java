package Steps;

import com.Pages.Login.LoginPage;
import com.Pages.Summary.SummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;


public class LoginSteps extends LoggerBaseStepDefinitions {

    public LoginPage loginPage = new LoginPage();
    public SummaryPage summaryPage = new SummaryPage();

    @Description("Description: Login page Test case")
    @Given("Deltix login page is opened")
    public void deltixLoginPageIsOpened() {
        loginPage.open();
        log.info("Test started, main page is opened.");
    }

    @Step("Step - entering valid username and password, submit.")
    @When("user sign in")
    public void userSignIn() {
        loginPage.LogIn();
        log.info("Successfully signed in.");
    }

    @Step("Step - looking for an element from the main page.")
    @Then("main page opens and {string} button is available")
    public void mainPageOpensAndButtonIsAvailable(String name) {
        try {
            summaryPage.getElement(name).should(exist).shouldBe(visible);
        } catch (NoSuchElementException exception) {
            log.error("Element " + name + " not found!", exception);
        }
    }

    @Step("Step - looking for an element from the main page.")
    @And("{string} is available")
    public void isAvailable(String name) {
        try {
            summaryPage.getElement(name).should(exist).shouldBe(visible);
        } catch (NoSuchElementException exception) {
            log.error("Element " + name + " not found!", exception);
        }
    }

    @Step(" Step - looking for an element from the main page.")
    @And("{string} with all section is available")
    public void visAllIsAvailable(String name, List<String> sections) {
        summaryPage.getElement(name).should(exist).shouldBe(visible);
        for (String s : sections) {
            summaryPage.navigator.getElement(s).should(exist).shouldBe(visible);
        }
        log.info("Test complete!");
    }

}
