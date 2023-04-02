
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestJU2 {

    @BeforeEach
    void setup() {
        open("https://www.google.com");

    }

    @Tags({@Tag("report"), @Tag("Functional")})

    @ValueSource(strings = {"OZON", "Delikateska", "MVideo"})


    @ParameterizedTest

    void testFindSite (String siteName)
    {
        $("[name=q]").setValue(siteName).pressEnter();

        $("#search").shouldHave(text(siteName));
    }
}
