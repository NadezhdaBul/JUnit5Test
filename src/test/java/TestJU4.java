
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestJU4 extends TestBase {

    @BeforeEach
    void set() {

        open("https://consumer.huawei.com/ru");
        $("span[class='icon font-ico-search']").shouldBe(visible).click();

    }

    @Tag("report")
    @DisplayName("Поиск телефона Huawei")

    @CsvSource ({
            "mate, HUAWEI Mate 50",
            "p50, HUAWEI P50"
    })

    @ParameterizedTest (name="в результате поиска по модели {0} дожна найтись информация о телефоне {1}")

    void testFindSite (
        String findText,
        String modelInfo
    )
    {
        $("#search").setValue(findText).pressEnter();
        $("#search-result").shouldHave(text(modelInfo));
    }
}
