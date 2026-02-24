package com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CodigoError {

        ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
        INSERCION_FALLIDA_EXISTENTE("GC-0002", "Fallo la insercion, ya existe es mismo registro en el sistema"),
        INSERCION_FALLIDA("GC-0003", "El elemento no pudo ser insertado en la base de datos");
        
        private final String codigo;
        private final String llaveMensaje;
}