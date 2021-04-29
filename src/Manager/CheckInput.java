package Manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =

            //Patter.CASE_Insensitive là không phân biệt chữ hoa chữ thường
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
//    public static final Pattern pattern = Pattern.compile("^\\d");;
//    public static boolean validateNumber(String number) {
//        Matcher matcher = pattern.matcher(number);
//        return matcher.find();
//    }

}
