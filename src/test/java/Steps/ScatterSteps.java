package Steps;

import com.Pages.Base.Elements.BarElements;
import com.Pages.Scatter.ScatterPage;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;

public class ScatterSteps extends LoggerBaseStepDefinitions {

    public ScatterPage scatterPage;
    private String Xaxis;
    private String Yaxis;
    private SelenideElement scatter;

    @Description("Description: Test case checks how changing an attributes affects the Scatter.")
    @Given("user is signed in and Scatter-plot view is opened")
    public void userIsSignedIn() {
        scatterPage = new ScatterPage();
        scatterPage.navigator.goTo(BarElements.SCATTER);
        log.info("Scatter test started.");
    }

    @Step("Step - set a start x-attribute")
    @Given("there is {string} selected as X-attribute")
    public void thereIsSelectedAsXAttribute(String atr) {
        scatterPage.X_ATTRIBUTE.selectAttribute(atr);
    }

    @Step("Step - set a start y-attribute")
    @And("there is {string} selected as Y-attribute")
    public void thereIsSelectedAsYAttribute(String atr) {
        scatterPage.Y_ATTRIBUTE.selectAttribute(atr);
    }

    @Step("Step - set intervals")
    @And("intervals set as {int}")
    public void intervalsSetAs(int value) {
        scatterPage.setInterval(value);
        Xaxis = scatterPage.getXs().shouldBe(visible).getText();
        Yaxis = scatterPage.getYs().shouldBe(visible).getText();
        scatter = scatterPage.getScatter();
    }

    @Step("Step - changing an x-attribute")
    @When("user changes the X-attribute to {string}")
    public void userChangesTheX(String atr) {
        scatterPage.X_ATTRIBUTE.selectAttribute(atr);
    }

    @Step("Step - make sure x-values updated")
    @Then("values of axes should be updated {string}")
    public void valuesOfAxesShouldBeUpdated(String attribute) {
        scatterPage.getXs().shouldNotHave(text(Xaxis)).should(exist).shouldBe(visible);
    }

    @Step("Step - make sure x-axis label updated")
    @And("the name of the X-axis should change to {string} Attribute")
    public void theNameOfTheXAxisShouldChangeToAttribute(String attribute) {
        scatterPage.getXLabel().shouldHave(text(attribute));
        log.info("Name of axes should be " + attribute + "!");
    }

    @Step("Step - changing an y-attribute")
    @When("user changes the Y-attribute to {string}")
    public void userChangesTheYAttributeTo(String atr) {
        scatterPage.Y_ATTRIBUTE.selectAttribute(atr);
    }

    @Step("Step - make sure y-values updated")
    @Then("values updated")
    public void valuesUpdated() {
        scatterPage.getYs().shouldNotHave(text(Yaxis)).should(exist).shouldBe(visible);
    }

    @Step("Step - make sure y-axis label updated")
    @And("the name of the Y-axis should change to {string} attribute")
    public void theNameOfTheYAxisShouldChangeToAttribute(String atr) {
        scatterPage.getYLabel().shouldHave(text(atr));
        log.info("Name of axes should be " + atr + "!");
    }

    @Step("Step - make sure that whole Scatter changed")
    @And("grid should collapse")
    public void gridShouldCollapse() {
        SelenideElement currentScatter = scatterPage.getScatter().should(exist).should(appear).shouldBe(visible);
        Assert.assertSame(scatter, currentScatter);
        log.info("Scatter test completed!");
    }


}
