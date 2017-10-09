package com.asd.test.facade;

import com.asd.test.entity.Good;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 * Clase Facade para tratamiento de objetos de tipo Good
 *
 * @author Teddy
 */
@Stateless
@LocalBean

public class GoodFacade extends AbstractFacade<Good> {

    @PersistenceContext(unitName = "ASD_TEST", type = PersistenceContextType.TRANSACTION)

    private EntityManager entityManager;

    /**
     *
     */
    public GoodFacade() {
        super(Good.class);
    }

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Consulta en base de datos, a partir del tipo de bien
     *
     * @param goodType
     * @return
     * @throws Exception
     */
    public List<Good> findByGoodType(BigInteger goodType) throws Exception {
        List<Good> results = new ArrayList();
        try {
            Query query = entityManager.createNamedQuery("Good.findByGoodTypeId");
            query.setParameter("goodTypeId", goodType);
            results = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return results;
    }

    /**
     * Consulta en base de datos, a partir del serial del bien
     *
     * @param serial
     * @return
     * @throws Exception
     */
    public List<Good> findByGoodSerial(BigInteger serial) throws Exception {
        List<Good> results = new ArrayList();
        try {
            Query query = entityManager.createNamedQuery("Good.findBySerial");
            query.setParameter("serial", serial);
            results = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return results;
    }

    /**
     * Consulta en base de datos, a partir de la fecha de compra del bien
     *
     * @param purchaseDate
     * @return
     * @throws Exception
     */
    public List<Good> findByGoodPurchaseDate(Date purchaseDate) throws Exception {
        List<Good> results = new ArrayList();
        try {
            Query query = entityManager.createNamedQuery("Good.findByPurchaseDate");
            query.setParameter("purchaseDate", purchaseDate);
            results = query.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return results;
    }

}
