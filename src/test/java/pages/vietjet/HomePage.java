package pages.vietjet;

import com.codeborne.selenide.SelenideElement;
import enums.vietjet.FlyType;
import objects.vietjet.BookingInfo;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private final SelenideElement flyTypeReturn = $(By.xpath("(//span[contains(@class, 'MuiFormControlLabel-label')])[1]"));
    private final SelenideElement flyTypeOneWay = $(By.xpath("(//span[contains(@class, 'MuiFormControlLabel-label')])[2]"));
    private final SelenideElement departDateInput = $(By.xpath("//p[.='Departure date']")).sibling(1);
    private final SelenideElement returnDateInput = $(By.xpath("//p[.='Return date']")).sibling(1);
    private final SelenideElement adultsDecrementBtn = $(By.xpath("//div[div[p[.='Adults']]]/following-sibling::div/button[1]"));
    private final SelenideElement adultsIncrementBtn = $(By.xpath("//div[div[p[.='Adults']]]/following-sibling::div/button[2]"));
    private final SelenideElement findLowestRadioBtn = $(By.xpath("//div[h3[.='Find lowest fare']]//input"));
    private final SelenideElement letGoBtn = $(By.xpath("//button[span[.=\"Let's go\"]]"));

    public void fillBookingInfo(BookingInfo bookingInfo) {
        if (bookingInfo.getFlyType() == FlyType.ONEWAY) {
            flyTypeOneWay.click();
        }
    }
}
