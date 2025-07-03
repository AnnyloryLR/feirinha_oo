package com.feirinha_oo.api.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemDTO {
    
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @Min(1)
    private Integer quantity;
}
