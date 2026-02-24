package com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat;

public final class ErrorUtils {

    ErrorUtils() {

    }

    /**
     * Crea un nuevo objeto de <code>Error</code>
     * 
     * @param codigoError
     * @param llaveMensaje
     * @param codigoHttp
     * @return - Objeto creado
     */
    public static ErrorData crearError(final String codigoError, final String llaveMensaje, final Integer codigoHttp) {
        final ErrorData error = new ErrorData();
        error.setCodigoError(codigoError);
        error.setMensaje(llaveMensaje);
        error.setCodigoHttp(codigoHttp);
        return error;
    }
}
