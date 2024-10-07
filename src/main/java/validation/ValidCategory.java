package validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryValidator.class)
@Documented
public @interface ValidCategory {
String message() default "Invalid Category";
Class<?>[] groups() default{};
Class <? extends Payload>[] payload() default{};
}
