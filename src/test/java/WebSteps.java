import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url) {
        open(url);
    }
    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }
    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }
    @Step("Переходим в таб Issues")
    public void clickIssueTab() {
        $(withText("Issues")).click();
    }
    @Step("Проверяем что Issue c номером {number} существует")
    public void shouldSeeIssueTab(int number) {
        $(withText("#" + number)).should(Condition.exist);
    }
}
