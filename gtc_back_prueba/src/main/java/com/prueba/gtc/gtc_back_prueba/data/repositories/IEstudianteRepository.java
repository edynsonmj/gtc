package com.prueba.gtc.gtc_back_prueba.data.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prueba.gtc.gtc_back_prueba.data.entities.EstudianteEntity;
import com.prueba.gtc.gtc_back_prueba.data.projections.EstudianteResumen;

public interface IEstudianteRepository extends CrudRepository<EstudianteEntity,String>{
    List<EstudianteResumen> findAllProyectedBy();
}
