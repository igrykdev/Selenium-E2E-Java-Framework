package utils;

public class ErrorRepository {
    public static String loginError_WrongPassword = "Invalid login attempt.";
    public static String loginError_WrongEmail = "The Email field is not a valid e-mail address.";

    public static String registrationError_WrongConfirmPassword = "The password and confirmation password do not match.";
    public static String registrationError_WrongEmail = "The Email field is not a valid e-mail address.";
    public static String registrationError_WrongPassword_Length = "The Password must be at least 6 and at max 100 characters long.";
    public static String registrationError_WrongPassword_NoUppercase = "Passwords must have at least one uppercase ('A'-'Z').";
    public static String registrationError_WrongPassword_NoLowercase = "Passwords must have at least one lowercase ('a'-'z').";
    public static String registrationError_WrongPassword_NoAlphanumeric = "Passwords must have at least one non alphanumeric character.";
    public static String registrationError_WrongPassword_NoDigit = "Passwords must have at least one digit ('0'-'9').";
    public static String registrationError_NoPassword = "The Password field is required.";

    public static String addProcessError_NameLength = "The field Name must be a string with a minimum length of 3 and a maximum length of 30.";
    public static String addProcessError_NoName = "The Name field is required.";

    public static String addCharacteristicError_NoProcessSelected = "The value 'Select process' is not valid for ProjectId.";
    public static String addCharacteristicError_EmptyUslField = "The value '' is invalid.";
}