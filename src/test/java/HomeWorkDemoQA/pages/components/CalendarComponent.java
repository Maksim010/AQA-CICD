package HomeWorkDemoQA.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement MONTH_SELECT = $(".react-datepicker__month-select");
    private final SelenideElement DAY_SELECT = $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)");
    private final SelenideElement YEAR_SELECT = $(".react-datepicker__year-select");

    public void setDate(String month, String year) {
        MONTH_SELECT.selectOptionByValue(month);
        YEAR_SELECT.selectOption(year);
        DAY_SELECT.click();
    }
}
