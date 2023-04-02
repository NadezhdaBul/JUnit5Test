
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestJU2{


    @BeforeEach
    void set() {
        open("https://www.google.com");
    }
    @Tag("report")
    @ValueSource(strings = {"OZON", "Delikateska", "MVideo"})


    @ParameterizedTest

    void testFindSite (String siteName)
    {
        $("[name=q]").setValue(siteName).pressEnter();

        $("#search").shouldHave(text(siteName));
    }
}
