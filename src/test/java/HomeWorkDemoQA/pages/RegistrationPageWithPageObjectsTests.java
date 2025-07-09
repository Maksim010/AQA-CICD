package HomeWorkDemoQA.pages;

import HomeWorkDemoQA.pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageWithPageObjectsTests extends BaseTestsDemoQA {

    private static final SelenideElement FIRST_NAME_INPUT_SELECTOR = $("#firstName");
    private static final SelenideElement LAST_NAME_INPUT_SELECTOR = $("#lastName");
    private static final SelenideElement EMAIL_INPUT_SELECTOR = $("#userEmail");
    private static final SelenideElement USER_NUMBER_INPUT_SELECTOR = $("#userNumber");
    private static final SelenideElement CURRENT_ADDRESS_INPUT_SELECTOR = $("#currentAddress");
    private static final SelenideElement GENDER_RADIO_SELECTOR = $("#genterWrapper");
    private static final SelenideElement FEMALE_GENDER_RADIO_SELECTOR = $("#gender-radio-2");
    private static final SelenideElement OTHER_GENDER_RADIO_SELECTOR = $("#gender-radio-3");
    private static final SelenideElement DATE_OF_BIRTH_INPUT_SELECTOR = $("#dateOfBirthInput");
    private static final SelenideElement MONTH_SELECTOR = $(".react-datepicker__month-select");
    private static final SelenideElement YEAR_SELECTOR = $(".react-datepicker__year-select");
    private static final SelenideElement DAY_30_SELECTOR = $(".react-datepicker__day--030");
    private static final SelenideElement SUBJECT_INPUT_SELECTOR = $("#subjectsInput");
    private static final SelenideElement HOBBIES_INPUT_SELECTOR = $("#hobbiesWrapper");
    private static final SelenideElement PICTURE_INPUT_SELECTOR = $("#uploadPicture");
    private static final SelenideElement STATE_CITY_SELECTOR = $("#stateCity-wrapper");
    private static final SelenideElement STATE_PLACEHOLDER_SELECTOR = $("#state");
    private static final SelenideElement CITY_PLACEHOLDER_SELECTOR = $("#city");
    private static final SelenideElement SUBMIT_BUTTON_SELECTOR = $("#submit");
    private static final SelenideElement TABLE_RESPONSIVE_SELECTOR = $(".table-responsive");
    private static final SelenideElement MODAL_DIALOG_SELECTOR = $(".modal-dialog");
    private static final SelenideElement MODAL_TITLE_SELECTOR = $("#example-modal-sizes-title-lg");

    private final CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Заполнить поле имени : '{firstName}'")
    public RegistrationPageWithPageObjectsTests setFirstName(String firstName) {
        FIRST_NAME_INPUT_SELECTOR.setValue(firstName);

        return this;
    }

    @Step("Заполнить поле фамилии : '{lastName}'")
    public RegistrationPageWithPageObjectsTests setLastName(String lastName) {
        LAST_NAME_INPUT_SELECTOR.setValue(lastName);

        return this;
    }
    @Step("Заполнить поле мобильного телефона : '{userNumber}'")
    public RegistrationPageWithPageObjectsTests setUserNumber(String userNumber) {
        USER_NUMBER_INPUT_SELECTOR.setValue(userNumber);

        return this;
    }
    @Step("Заполнить поле почты : '{userEmail}'")
    public RegistrationPageWithPageObjectsTests setUserEmail(String userEmail) {
        EMAIL_INPUT_SELECTOR.setValue(userEmail);

        return this;
    }
    @Step("Заполнить поле адреса : '{address}'")
    public RegistrationPageWithPageObjectsTests setCurrentAddress(String address) {
        CURRENT_ADDRESS_INPUT_SELECTOR.setValue(address);

        return this;
    }
    @Step("Заполнить поле пола : '{gender}'")
    public RegistrationPageWithPageObjectsTests setGender(String gender) {
        GENDER_RADIO_SELECTOR.$(byText(gender)).click();

        return this;
    }
    @Step("Заполнить поле предмета : '{subject}'")
    public RegistrationPageWithPageObjectsTests setSubject(String subject) {
        SUBJECT_INPUT_SELECTOR.setValue(subject).pressEnter();

        return this;
    }
    @Step("Заполнить поле о хобби : '{hobbies}'")
    public RegistrationPageWithPageObjectsTests setHobbies(String hobbies) {
        HOBBIES_INPUT_SELECTOR.$(byText(hobbies)).click();

        return this;
    }
    @Step("Заполнить поле с днем рождения : '{month}', '{year}'")
    public RegistrationPageWithPageObjectsTests setDateOFBirth(String month, String year) {
        DATE_OF_BIRTH_INPUT_SELECTOR.click();
        calendarComponent.setDate(month, year);

        return this;
    }

    @Step("Выбор фотографии '{picture}'")
    public RegistrationPageWithPageObjectsTests selectPicture(File picture) {
        PICTURE_INPUT_SELECTOR.uploadFile(picture);

        return this;
    }

    @Step("Выбор страны и города проживания '{state}', '{city}'")
    public RegistrationPageWithPageObjectsTests selectSateAndCity(String state, String city) {
        STATE_PLACEHOLDER_SELECTOR.click();
        STATE_CITY_SELECTOR.$(byText(state)).click();
        CITY_PLACEHOLDER_SELECTOR.click();
        STATE_CITY_SELECTOR.$(byText(city)).click();

        return this;
    }

    @Step("Нажатие на кнопку подтверждения")
    public RegistrationPageWithPageObjectsTests submitButton() {
        SUBMIT_BUTTON_SELECTOR.click();

        return this;
    }

    @Step("Проверка результата регистрации '{key}', '{value}'")
    public RegistrationPageWithPageObjectsTests checkResult(String key, String value) {
        TABLE_RESPONSIVE_SELECTOR.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    @Step("Проверка на появление окна с успешной регистрацией '{value}'")
    public RegistrationPageWithPageObjectsTests checkSuccessfulModalResult(String value) {
        MODAL_DIALOG_SELECTOR.should(appear);
        MODAL_TITLE_SELECTOR.shouldHave(text(value));

        return this;
    }
    @Step("Проверка, что окно с успешной регистрацией не появилось '{value}'")
    public RegistrationPageWithPageObjectsTests checkUnsuccessfulModalResult() {
        MODAL_DIALOG_SELECTOR.should(not(appear));

        return this;
    }
    @Step("Проверка на подсвечивание некорректно введенного поля телефона")
    public RegistrationPageWithPageObjectsTests checkNotValidInput() {
        USER_NUMBER_INPUT_SELECTOR.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }




}

