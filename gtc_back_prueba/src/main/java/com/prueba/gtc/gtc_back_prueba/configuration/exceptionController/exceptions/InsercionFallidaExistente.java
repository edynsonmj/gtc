package com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.exceptions;

import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat.CodigoError;

import lombok.Getter;

@Getter
public class InsercionFallidaExistente extends RuntimeException{
    
    private final String llaveMensaje;
    private final String codigo;

    public InsercionFallidaExistente() {
        super();
        llaveMensaje = CodigoError.INSERCION_FALLIDA_EXISTENTE.getLlaveMensaje();
        codigo = CodigoError.INSERCION_FALLIDA_EXISTENTE.getCodigo();
    }
}
