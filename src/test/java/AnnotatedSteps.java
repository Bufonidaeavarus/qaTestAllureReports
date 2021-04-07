import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class AnnotatedSteps {

    private final String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("Igor")
    @Severity(SeverityLevel.BLOCKER)
    public void test(){
        steps.openMainPage(BASE_URL);
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickIssueTab();
        steps.shouldSeeIssueTab(ISSUE_NUMBER);
    }
}
