/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * Representacion de objeto para retorno, una vez consumida la API
 *
 * @author Teddy
 */
public class ReturnOperation implements Serializable {

    /**
     * Constante con codigo de transaccion exitosa
     */
    public static final int SUCCESS = 200;

    /**
     * Constante con codigo de informacion faltante
     */
    public static final int MISSING_INFO = 400;

    /**
     * Constante con codigo para informar que no fue posible retornar
     * informacion
     */
    public static final int NOT_FOUND = 404;

    /**
     * Constante con codigo de error
     */
    public static final int ERROR = 500;

    int code;
    Object message;
    Long timeExecute;

    /**
     * Constructor de la clase ReturnOperation
     *
     * @param code
     * @param message
     * @param timeExecute
     */
    public ReturnOperation(int code, String message, Long timeExecute) {
        this.code = code;
        this.message = message;
        this.timeExecute = timeExecute;
    }

    /**
     * Constructor por defecto
     */
    public ReturnOperation() {
        this.code = ReturnOperation.SUCCESS;
        timeExecute = new Date().getTime();
        this.message = "SUCCESSFUL";

    }

    /**
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public Long getTimeExecute() {
        return timeExecute;
    }

    /**
     *
     * @param timeExecute
     */
    public void setTimeExecute(Long timeExecute) {
        this.timeExecute = timeExecute;
    }

    /**
     *
     * @return
     */
    public Object getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(Object message) {
        this.message = message;
    }

}
