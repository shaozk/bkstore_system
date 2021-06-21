/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shaozk
 */
public class TextUtil {
    public static final String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static boolean isEmailAddressOk(String emailAddress) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(emailAddress);
        return m.matches();
    }
}
