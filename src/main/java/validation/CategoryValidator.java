package validation;

import entities.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<ValidCategory, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Category.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            // Disable the default error message
            context.disableDefaultConstraintViolation();
            // Provide a custom error message that includes the invalid category
            context.buildConstraintViolationWithTemplate("Invalid category: " + value)
                   .addConstraintViolation();
            return false;
        }
    }
}
