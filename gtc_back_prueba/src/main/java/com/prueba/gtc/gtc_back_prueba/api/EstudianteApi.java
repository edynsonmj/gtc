package com.prueba.gtc.gtc_back_prueba.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.gtc.gtc_back_prueba.service.EstudianteService;
import com.prueba.gtc.gtc_back_prueba.service.DTOs.EstudianteDto;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/")
@Validated
public class EstudianteApi {
    @Autowired
    private EstudianteService estudianteService;


    /*TODO: Crear un API REST que permita:
    Agregar estudiantes
    Listar estudiantes
    Eliminar estudiantes
    Uso de Lombook
    Base de datos relacional
    Opcional: Editar estudiantes
    Opcional: Implementar una estructura de respuesta estandarizada utilizando DTOs que
    incluyan campos como data, httpStatus, y message (por ejemplo: 200 OK, 404 Not Found, 202
    Accepted, etc.)
    Requisitos
    Uso de DTOs y entidades
    Implementación de mappers (por ejemplo, con MapStruct o manuales)
    Uso de proyecciones para optimizar consultas*/

    /***
     * lISTAR ESTUDIANTES
     * @return
     */
    @GetMapping("/estudiante")
    public ResponseEntity<List<EstudianteDto>> obtenerEstudiantes(){        
        List<EstudianteDto> respuesta = estudianteService.obtenerEstudiantes();
        return new ResponseEntity<List<EstudianteDto>>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/estudiante/resumen")
    public ResponseEntity<List<EstudianteDto>> obtenerEstudiantesResumen(){
        List<EstudianteDto> respuesta = estudianteService.obtenerEstudiantesResumen();
        return new ResponseEntity<List<EstudianteDto>>(respuesta, HttpStatus.OK);
    }

    /***
     * @param entity
     * @return
     */
    @PostMapping("/estudiante")
    public ResponseEntity<EstudianteDto> agregarEstudiante(@Valid @RequestBody EstudianteDto dto) {
        EstudianteDto respuesta = estudianteService.agregarEstudiante(dto);
        return new ResponseEntity<EstudianteDto>(respuesta, HttpStatus.CREATED);
    }

    @DeleteMapping("/estudiante/{id}")
    public ResponseEntity<Boolean> eliminarEstudiante(@PathVariable String id){
        Boolean respuesta = estudianteService.eliminarEstudiante(id);
        return new ResponseEntity<Boolean>(respuesta, HttpStatus.OK);
    }
    
}
