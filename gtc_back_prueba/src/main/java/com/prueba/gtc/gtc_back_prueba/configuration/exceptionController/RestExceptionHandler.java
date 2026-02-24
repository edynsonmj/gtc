package com.prueba.gtc.gtc_back_prueba.configuration.exceptionController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat.ErrorData;
import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.errorFormat.ErrorUtils;
import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.exceptions.EliminacionFallidaNoExistente;
import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.exceptions.ErrorGenerico;
import com.prueba.gtc.gtc_back_prueba.configuration.exceptionController.exceptions.InsercionFallidaExistente;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {
    /**
     * Captura las exceptiones producto de las validaciones en el dto, validated y valid generan exception tipo MethodArgumentNotValidException
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
                Map<String, String> errores = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String campo = ((FieldError) error).getField();
                        String mensajeDeError = error.getDefaultMessage();
                        errores.put(campo, mensajeDeError);
                });

                return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
        }
    
        /**
         * lanzar cuando el objeto a insertar ya exista en la base de datos
         * @param req
         * @param ex
         * @return
         */
    @ExceptionHandler(InsercionFallidaExistente.class)
        public ResponseEntity<ErrorData> GenericException(final HttpServletRequest req, final InsercionFallidaExistente ex){
            String codigo = ex.getCodigo();
            String mensaje = String.format("%s, %s", ex.getLlaveMensaje(), ex.getMessage());
            Integer codigoHttp = HttpStatus.BAD_REQUEST.value();
            final ErrorData error = ErrorUtils.crearError(codigo, mensaje, codigoHttp);
            error.setUrl(req.getRequestURL().toString());
            error.setMetodo(req.getMethod());
            return new ResponseEntity<ErrorData>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorGenerico.class)
        public ResponseEntity<ErrorData> GenericException(final HttpServletRequest req, final ErrorGenerico ex){
            String codigo = ex.getCodigo();
            String mensaje = String.format("%s, %s", ex.getLlaveMensaje(), ex.getMessage());
            Integer codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR.value();
            final ErrorData error = ErrorUtils.crearError(codigo, mensaje, codigoHttp);
            error.setUrl(req.getRequestURL().toString());
            error.setMetodo(req.getMethod());
            return new ResponseEntity<ErrorData>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EliminacionFallidaNoExistente.class)
        public ResponseEntity<ErrorData> GenericException(final HttpServletRequest req, final EliminacionFallidaNoExistente ex){
            String codigo = ex.getCodigo();
            String mensaje = String.format("%s, %s", ex.getLlaveMensaje(), ex.getMessage());
            Integer codigoHttp = HttpStatus.BAD_REQUEST.value();
            final ErrorData error = ErrorUtils.crearError(codigo, mensaje, codigoHttp);
            error.setUrl(req.getRequestURL().toString());
            error.setMetodo(req.getMethod());
            return new ResponseEntity<ErrorData>(error,HttpStatus.BAD_REQUEST);
    }
}
