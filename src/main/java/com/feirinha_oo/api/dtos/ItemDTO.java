package com.feirinha_oo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemDTO {
    
    @NotBlank
    @Size(max = 50)
    private String name;

    private Integer quantity;
}
