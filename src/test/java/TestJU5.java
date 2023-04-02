import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestJU5 {


    @BeforeEach
    void setup() {

        open("https://goodkitchen.su/online-menu/sbalansirovannoe-pitanie/sbalansirovannoe-pitanie-racion-2700/");

        Configuration.browserSize = "1920x1080";
    }


    @Tags({@Tag("Report"), @Tag("UI")})

    @CsvSource ({
            "10, 19 250",
            "24, 44 400"
    })

    @ParameterizedTest (name="при заказе питания длительностью {0} дней цена рациона составляет {1} рублей")

    void testFindSite (
        String numberOfDays,
        String price
    )
    {

        $$(".form-group label").find(text(numberOfDays)).click();
        $("#product").$(".rations__product-price-new").shouldHave(text(price));
    }
}
