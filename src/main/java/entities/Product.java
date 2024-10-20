package entities;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

//check how to have enum empty
public record Product(
        @NotBlank(message = "Id cannot be empty or null")
        String id,
        @NotBlank(message = "Name cannot be empty or null")
        String name,
        @NotNull(message = "Category cannot be null")
        Category category,
        @Min(value = 0, message = "Rating should be over 0")
        @Max(value = 10, message = "Rating should be max 10")
        int rating,
        @NotNull(message = "Date cannot be null")
        @PastOrPresent(message = "Date must be in the past or present. Not in the future")
        LocalDateTime createdDate,
        @NotNull(message = "Modified date cannot be null")
        @PastOrPresent(message = "Modified date must be in the past or present. Not in the future")
        LocalDateTime modifiedDate) {
}