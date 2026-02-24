package com.prueba.gtc.gtc_back_prueba.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ESTUDIANTE")
public class EstudianteEntity {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer grupo;
}
