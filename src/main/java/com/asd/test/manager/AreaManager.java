/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.manager;

import com.asd.test.entity.Area;
import com.asd.test.facade.AreaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 * @author Teddy
 */
@Stateless
@LocalBean
public class AreaManager {

    /**
     * Logger
     */
    public static final Logger LOGGER = Logger.getLogger(AreaManager.class.getName());

    @EJB
    AreaFacade areaFacade;

    /**
     * Metodo encargado de invocar al facade de Area para listar todas las areas
     *
     * @return
     * @throws java.lang.Exception
     */
    public List<Area> findAll() throws Exception {
        List<Area> findAll = new ArrayList();
        try {
            findAll = areaFacade.findAll();
        } catch (Exception e) {
            LOGGER.error("Error on findall Method." + e.getMessage(), e);
            throw e;
        }
        return findAll;
    }

}
