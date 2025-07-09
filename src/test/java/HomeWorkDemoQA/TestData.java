package HomeWorkDemoQA;

import java.io.File;

import static HomeWorkDemoQA.utils.RandomUtils.generateRandomString;

public class TestData {
    public static final String BASE_URL = "https://demoqa.com";
    public static final String BROWSER = "chrome";
    public static final int TIMEOUT = 15000;
    public static final int PAGE_LOAD_TIMEOUT = 20000;

    public static final String RANDOM_FIRST_NAME = generateRandomString(10);
    public static final String FIRST_NAME = "Max";
    public static final String LAST_NAME = "Drobysh";
    public static final String MODAL_TEXT = "Thanks for submitting the form";
    public static final String SUCCESSFUL_USER_NUMBER = "3764949249";
    public static final String UNSUCCESSFUL_USER_NUMBER = "376494924";
    public static final String USER_EMAIL = "max_dro01@mail.ru";
    public static final String SUBJECT = "Maths";
    public static final String GENDER = "Male";
    public static final String ADDRESS = "Pobedy 59";
    public static final String STATE = "NCR";
    public static final String CITY = "Delhi";
    public static final String MONTH = "0";
    public static final String YEAR = "2001";
    public static final File PICTURE = (new File("src/test/resources/img/1.png"));
    public static final String HOBBIES = "Sports";


}
