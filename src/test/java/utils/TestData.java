package utils;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String dayOfBirth = String.format("%s", faker.number().numberBetween(1, 28));
    public String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.format("%s", faker.number().numberBetween(1970, 2010));
    public String subject = faker.options().option("Hindi", "English", "History", "Maths", "Physics", "Chemistry", "Biology");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("picture.jpg");
    public String currentAddress = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = selectCity(state);

    public String selectCity(String state) {
        switch (state) {

            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");

            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");

            case "Haryana":
                return faker.options().option("Karnal", "Panipat");

            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");

            default:
                return null;
        }
    }
}