package com.prueba.gtc.gtc_back_prueba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prueba.gtc.gtc_back_prueba.data.entities.EstudianteEntity;
import com.prueba.gtc.gtc_back_prueba.data.projections.EstudianteResumen;
import com.prueba.gtc.gtc_back_prueba.data.repositories.IEstudianteRepository;
import com.prueba.gtc.gtc_back_prueba.service.DTOs.EstudianteDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class EstudianteService{

    @Qualifier("modelMapperGenerico")
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private IEstudianteRepository estudianteRepository;

    /***
     * Obtine la lista de estudiantes de la base de datos
     * @return
     */
    public List<EstudianteDto> obtenerEstudiantes(){
        Iterable<EstudianteEntity> entidades = estudianteRepository.findAll();
        List<EstudianteDto> estudiantes = new ArrayList<>();
        estudiantes = mapper.map(entidades, new TypeToken<List<EstudianteDto>>() {
        }.getType());
        return estudiantes;
    }

    /***
     * obtiene la lista de estudiantes mediante una proyecttion.
     * @return
     */
     public List<EstudianteDto> obtenerEstudiantesResumen(){
        List<EstudianteResumen> entidades = estudianteRepository.findAllProyectedBy();
        List<EstudianteDto> estudiantes = new ArrayList<>();
        estudiantes = mapper.map(entidades, new TypeToken<List<EstudianteDto>>() {
        }.getType());
        return estudiantes;
    }

    /***
     * Agrega un estudiante a la base con los datos nuevaData
     * @param nuevaData
     * @return estudiante insertado
     */
    public EstudianteDto agregarEstudiante(EstudianteDto nuevaData){
        EstudianteEntity entidad = mapper.map(nuevaData, EstudianteEntity.class);
        EstudianteEntity entidadAgregada = estudianteRepository.save(entidad);
        return mapper.map(entidadAgregada, EstudianteDto.class);
    }

    /***
     * Elimina una registro de la base identificado con id
     * @param id
     * @return true en exito
     */
    public Boolean eliminarEstudiante(String id){
        Optional<EstudianteEntity> entidad = estudianteRepository.findById(id);
        if(entidad.isEmpty()){
            return false;
        }
        EstudianteEntity entidadEliminar = entidad.get();
        estudianteRepository.delete(entidadEliminar);
        return true;
    }

}
