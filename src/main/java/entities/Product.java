package entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record Product(
        @NotBlank(message = "Id cannot be empty or null")
        String id,
        @NotBlank(message = "Name cannot be empty or null")
        String name,
        Category category,
        @Min(value = 0, message = "Rating should be over 0")
        @Max(value = 10, message = "Rating should be max 10")
        int rating,
        @NotNull(message = "Date cannot be null")
        LocalDateTime createdDate,
        LocalDateTime modifiedDate) {
}