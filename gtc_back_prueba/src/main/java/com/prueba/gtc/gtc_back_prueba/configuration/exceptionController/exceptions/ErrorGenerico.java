package com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.exceptions;

import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat.CodigoError;

import lombok.Getter;

@Getter
public class ErrorGenerico extends RuntimeException{
    private final String llaveMensaje;
    private final String codigo;

    public ErrorGenerico() {
        super();
        llaveMensaje = CodigoError.ERROR_GENERICO.getLlaveMensaje();
        codigo = CodigoError.ERROR_GENERICO.getCodigo();
    }
}
