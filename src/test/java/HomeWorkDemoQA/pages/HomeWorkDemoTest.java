package HomeWorkDemoQA.pages;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static HomeWorkDemoQA.TestData.ADDRESS;
import static HomeWorkDemoQA.TestData.BASE_URL;
import static HomeWorkDemoQA.TestData.CITY;
import static HomeWorkDemoQA.TestData.FIRST_NAME;
import static HomeWorkDemoQA.TestData.GENDER;
import static HomeWorkDemoQA.TestData.HOBBIES;
import static HomeWorkDemoQA.TestData.LAST_NAME;
import static HomeWorkDemoQA.TestData.MODAL_TEXT;
import static HomeWorkDemoQA.TestData.MONTH;
import static HomeWorkDemoQA.TestData.RANDOM_FIRST_NAME;
import static HomeWorkDemoQA.TestData.STATE;
import static HomeWorkDemoQA.TestData.SUBJECT;
import static HomeWorkDemoQA.TestData.SUCCESSFUL_USER_NUMBER;
import static HomeWorkDemoQA.TestData.UNSUCCESSFUL_USER_NUMBER;
import static HomeWorkDemoQA.TestData.USER_EMAIL;
import static HomeWorkDemoQA.TestData.YEAR;

public class HomeWorkDemoTest extends BaseTestsDemoQA {

    private final RegistrationPageWithPageObjectsTests registrationPage =
            new RegistrationPageWithPageObjectsTests();

    @Test
    @Feature("Форма регистрации")
    @Story("Пользователь регистрируется с указанием всех полей")
    @Owner("Maksim10")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Registration", url = BASE_URL + "/automation-practice-form")
    @DisplayName("Успешная регистрации с валидными данными")
    void successfulFullRegistration() {
        registrationPage
                .setFirstName(RANDOM_FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setSubject(SUBJECT)
                .setCurrentAddress(ADDRESS)
                .setUserNumber(SUCCESSFUL_USER_NUMBER)
                .setUserEmail(USER_EMAIL)
                .setDateOFBirth(MONTH,YEAR)
                .setHobbies(HOBBIES)
                .selectSateAndCity(STATE, CITY)
                .submitButton()
                .checkSuccessfulModalResult(MODAL_TEXT)
                .checkResult("Student Name", RANDOM_FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", USER_EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Subjects", SUBJECT)
                .checkResult("Address", ADDRESS)
                .checkResult("Mobile", SUCCESSFUL_USER_NUMBER)
                .checkResult("Date of Birth", "01 January,2001")
                .checkResult("Hobbies", HOBBIES)
                .checkResult("State and City", STATE + " " + CITY);

    }

    @Test
    @Feature("Форма регистрации")
    @Story("Валидация номера")
    @Owner("Maksim10")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Registration", url = BASE_URL + "/automation-practice-form")
    @DisplayName("Поле номера подсвечивается красным при неверном формате")
    void unsuccessfulMandatoryRegistration() {
        registrationPage
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(UNSUCCESSFUL_USER_NUMBER)
                .submitButton()
                .checkNotValidInput()
                .checkUnsuccessfulModalResult();
    }


    @Test
    @Feature("Форма регистрации")
    @Story("Пользователь может зарегистрироваться без указания необязательных полей")
    @Owner("Maksim10")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Registration", url = BASE_URL + "/automation-practice-form")
    @DisplayName("Успешная регистрация с минимальными данными")
    void onlyMandatorySuccessfulRegistration() {
        registrationPage
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserNumber(SUCCESSFUL_USER_NUMBER)
                .submitButton()
                .checkSuccessfulModalResult(MODAL_TEXT)
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", SUCCESSFUL_USER_NUMBER);
    }
}
