package ning.nc.framework.validation.impl;


import ning.nc.framework.validation.annotation.Mobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号码校验实现
 *
 * @author Allen
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    private static Pattern pattern = Pattern.compile("^0?(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

    @Override
    public void initialize(Mobile constraintAnnotation) {

    }
}
