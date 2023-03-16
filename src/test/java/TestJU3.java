import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestJU3 {


    @BeforeEach
    void setup() {

        open("https://www.mvideo.ru");

        Configuration.browserSize = "1920x1080";

    }


    @Tags({@Tag("Critical"), @Tag("FindTV")})

    @CsvSource ({
            "43NANO776QA, LG 43NANO776QA",
            "32DB2E, Sharp 32DB2E",
            "50NANO769QA, LG 50NANO769QA"
    })

    @ParameterizedTest (name="в результате поиска модели {0} дожен отобразиться товар с наименованием {1}")

    void testFindSite (
        String findText,
        String foundModel
    )
    {
        $(".input__field").setValue(findText).pressEnter();
        $(".plp__card-grid").shouldHave(text(foundModel));
    }
}
