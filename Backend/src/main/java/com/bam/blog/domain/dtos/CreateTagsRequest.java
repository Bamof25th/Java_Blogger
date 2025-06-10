package com.bam.blog.domain.dtos;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagsRequest {

    @NotEmpty(message = "At least one tag name is required")
    @Size(max = 10, message = "Maximum {max} tags Allowed")
    private Set<@Size(min = 2, max = 30, message = "Tag Name must be b/w {min} to {max} characters") @Pattern(regexp = "^[\\w\\s-]+$", message = "Tag name can only contain letters , numbers , spaces and hyphens  ") String> names;

}
