package com.prueba.gtc.gtc_back_prueba.service.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {
    @NotBlank(message = "Obligatorio ingreso de id")
    private String id;
    @NotBlank(message = "Obligatorio ingreso de nombre")
    private String nombre;
    @NotBlank(message = "obligatorio uso de apellido")
    private String apellido;
    
    private Integer grupo;
}
