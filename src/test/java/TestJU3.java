import com.codeborne.selenide.Configuration;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestJU3 {


    @BeforeEach
    void setup() {

        open("https://www.mvideo.ru");

        Configuration.browserSize = "1920x1080";

    }


    @Tags({@Tag("Report"), @Tag("FindTV")})

    static @NotNull Stream <Arguments> testFindTV (){
        return Stream.of(
                Arguments.of("43NANO776QA", "LG 43NANO776QA"),
                Arguments.of("32DB2E", "Sharp 32DB2E"),
                Arguments.of("50NANO769QA", "LG 50NANO769QA")
        );
    }

    @MethodSource("testFindTV")

    @ParameterizedTest (name="в результате поиска модели {0} дожен отобразиться товар с наименованием {1}")

    void testFindModel(
        String findText,
        String foundModel
    )
    {
        $(".input__field").setValue(findText).pressEnter();
        $(".plp__card-grid").shouldHave(text(foundModel));
    }
}
