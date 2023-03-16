
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestJU2 {

    @BeforeEach
    void setup() {
        open("https://www.google.com");

    }

    @Tags({@Tag("Blocker"), @Tag("Functional")})

    @CsvSource ({
            "OZON, https://www.ozon.ru",
            "Delikateska, https://www.delikateska.ru",
            "MVideo, https://www.mvideo.ru"
    })

    @ParameterizedTest

    void testFindSite (
        String siteName,
        String siteUrl
    )
    {
        $("[name=q]").setValue(siteName).pressEnter();
        $("#search").shouldHave(text(siteUrl));
    }
}
