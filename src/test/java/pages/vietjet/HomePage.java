package pages.vietjet;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.vietjet.FlyType;
import objects.vietjet.BookingInfo;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement acceptBtn = $(By.xpath("//div[contains(@class, 'MuiDialogContent-root')]//button"));
    private final SelenideElement laterReceiveOfferNotification = $("#NC_CTA_TWO");
    private final SelenideElement flyTypeReturn = $(By.xpath("//input[@value='roundTrip']"));
    private final SelenideElement flyTypeOneWay = $(By.xpath("//input[@value='oneway']"));
    private final SelenideElement departDateInput = $(By.xpath("//p[.='Departure date']")).sibling(0);
    private final ElementsCollection dateFromTodayBtn = $$(By.xpath("//button[contains(@class, 'rdrDay') and not (contains(@class,'rdrDayPassive') or contains(@class,'rdrDayDisabled'))]"));
    private final SelenideElement fromIpt = $(By.xpath("//div[label[.='From']]//input"));
    private final SelenideElement toIpt = $(By.xpath("//div[label[.='To']]//input"));
    private final SelenideElement adultsDecrementBtn = $(By.xpath("//div[div[p[.='Adults']]]/following-sibling::div/button[1]"));
    private final SelenideElement adultsIncrementBtn = $(By.xpath("//div[div[p[.='Adults']]]/following-sibling::div/button[2]"));
    private final SelenideElement findLowestRadioBtn = $(By.xpath("//div[h3[.='Find lowest fare']]//input"));
    private final SelenideElement letGoBtn = $(By.xpath("//button[span[.=\"Let's go\"]]"));


    public void acceptCookiesAndClosePopUp() {
        acceptBtn.shouldBe(visible);
        acceptBtn.click();
        acceptBtn.shouldBe(disappear);
        webdriver().driver().switchTo().frame("preview-notification-frame");
        laterReceiveOfferNotification.shouldBe(exist);
        laterReceiveOfferNotification.click();
        laterReceiveOfferNotification.shouldBe(disappear);
        webdriver().driver().switchTo().defaultContent();
    }

    public void selectDateFromToday(int day) {
        dateFromTodayBtn.get(day).click();
    }

    public void fillBookingInfo(BookingInfo bookingInfo) {
        if (bookingInfo.getFlyType() == FlyType.RETURN) {
            flyTypeReturn.click();
        } else if (bookingInfo.getFlyType() == FlyType.ONEWAY) {
            flyTypeOneWay.click();
        }
        fromIpt.setValue(bookingInfo.getFrom());
        toIpt.setValue(bookingInfo.getTo());
        departDateInput.click();
        selectDateFromToday(bookingInfo.getFromDate());
        selectDateFromToday(bookingInfo.getToDate());
        letGoBtn.click();
    }
}
