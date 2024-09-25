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

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city);
        registrationPage.clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithMinDataTest() {
        String firstName = "Mihail";
        String lastName = "Zubenko";
        String gender = "Male";
        String phoneNumber = "8999665533";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber);
        registrationPage.clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage().clickSubmit();

        registrationPage.negativeCheck();
    }
}

