package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationDemoQATests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        String  firstName = "Mihail",
                lastName = "Zubenko",
                userEmail = "mafia@sobaka.ru",
                gender = "Male",
                phoneNumber = "8999665533",
                dayOfBirth = "25",
                monthOfBirth = "July",
                yearOfBirth = "1995",
                subjects = "Maths",
                hobbies = "Reading",
                picName = "avva.jpg",
                currentAddress = "Vladimirskiy, Central 12/3",
                state = "Haryana", city = "Panipat";

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.setGender(gender);
        registrationPage.setUserNumber(phoneNumber);
        registrationPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage.setSubjects(subjects);
        registrationPage.setHobbies(hobbies);
        registrationPage.setPicture(picName);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Student Email", userEmail);
        registrationPage.checkResult("Gender", gender);
        registrationPage.checkResult("Mobile", phoneNumber);
        registrationPage.checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        registrationPage.checkResult("Subjects", subjects);
        registrationPage.checkResult("Hobbies", hobbies);
        registrationPage.checkResult("Picture", picName);
        registrationPage.checkResult("Address", currentAddress);
        registrationPage.checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithMinDataTest() {
        String firstName = "Mihail";
        String lastName = "Zubenko";
        String gender = "Male";
        String phoneNumber = "8999665533";

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setGender(gender);
        registrationPage.setUserNumber(phoneNumber);
        registrationPage.clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName);
        registrationPage.checkResult("Gender", gender);
        registrationPage.checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage().clickSubmit();

        registrationPage.negativeCheck();
    }
}

