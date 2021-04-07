import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaSteps {

    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Test
    public void testIssueSearch2() {
        step("Открываем главную страницу", () -> {
            open(BASE_URL);
        });
        step("Ищем репозиторий", () ->{
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий ", () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в таб Issues", () -> {
            $(withText("Issues12")).click();
        });
        step("Проверяем что Issue c номером "+ ISSUE_NUMBER+" существует", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }
}
