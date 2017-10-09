/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.facade;

import com.asd.test.entity.Area;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Teddy
 */

@Stateless
@LocalBean
public class AreaFacade extends AbstractFacade<Area> {

    @PersistenceContext(unitName = "ASD_TEST", type = PersistenceContextType.TRANSACTION)

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public AreaFacade() {
        super(Area.class);
    }
    
    

}
