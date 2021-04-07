import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSteps {

    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Test
    public void testIssueSearch1() {
        open(BASE_URL);

        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(By.linkText(REPOSITORY)).click();

        $(withText("Issues12")).click();

        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }
}