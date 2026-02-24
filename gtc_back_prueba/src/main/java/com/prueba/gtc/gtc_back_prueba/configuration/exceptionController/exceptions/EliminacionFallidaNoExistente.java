package com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.exceptions;

import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat.CodigoError;

import lombok.Getter;

@Getter
public class EliminacionFallidaNoExistente extends RuntimeException{
    private final String llaveMensaje;
    private final String codigo;

    public EliminacionFallidaNoExistente() {
        super();
        llaveMensaje = CodigoError.ELIMINACION_FALLIDA_NO_EXISTE.getLlaveMensaje();
        codigo = CodigoError.ELIMINACION_FALLIDA_NO_EXISTE.getCodigo();
    }
}
