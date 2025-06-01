package com.bam.blog.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {

    @NotBlank(message = "Category name is Required!")
    @Size(min = 2, max = 50, message = "category name must be between 2 to 50 characters!")
    @Pattern(regexp = "^[\\w\\s-]+$", message = "Category name can contain letter , number ,spaces & hyphens")
    private String name;

}
