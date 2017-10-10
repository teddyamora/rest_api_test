/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.utils;

import java.util.Date;
import org.apache.log4j.Logger;

/**
 * Clase destinada a almacenar metodos a forma utilidades para ser re utilizados
 * @author Teddy
 */
public class ClassUtilities {
    
    /**
     * Log
     */
    public static final Logger LOGGER = Logger.getLogger(ClassUtilities.class);
    
    /**
     * Se encarga de comparar las fechas de compra y de baja, para ssaber si se inserta o actualiza un bien
     * @param purchaseDate
     * @param dischargeDate
     * @return
     * @throws Exception
     */
    public static boolean comparePurchAndDischargeDates(Date purchaseDate, Date dischargeDate) throws Exception {
        boolean isTrue = true;
        try {
            if (dischargeDate != null) {
                if (purchaseDate != null && purchaseDate.compareTo(dischargeDate) > 0) {
                    isTrue = false;
                }
            }
            
        } catch (Exception e) {
            LOGGER.error("Error comparing Dates: " + e.getMessage(), e);
            throw e;
            
        }
        return isTrue;
    }
    
}
