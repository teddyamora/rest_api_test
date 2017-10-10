package com.asd.test.manager;

import com.asd.test.utils.ReturnOperation;
import com.asd.test.entity.Good;
import com.asd.test.facade.GoodFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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

public class GoodManager {

    /**
     * Logger
     */
    public static final Logger LOGGER = Logger.getLogger(GoodManager.class.getName());

    @EJB
    GoodFacade goodFacade;

    /**
     * Metodo encargado de invocar al facade de Good para listar todos los
     * bienes
     *
     * @return
     * @throws java.lang.Exception
     */
    public List<Good> findAll() throws Exception {
        List<Good> findAll = new ArrayList();
        try {
            findAll = goodFacade.findAll();
        } catch (Exception e) {
            LOGGER.error("Error on findall Method." + e.getMessage(), e);
            throw e;
        }
        return findAll;
    }

    /**
     *
     * @param numRows
     * @param firstRow
     * @return
     */
    public List<Good> findRange(int numRows, int firstRow) {
        int[] range = {numRows, firstRow};
        List<Good> find = goodFacade.findRange(range);
        return find;
    }

    /**
     * Metodo encargado de invocar al facade de Good para listar los bienes por
     * su identificador(PK)
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    public Good findById(BigDecimal id) throws Exception {
        Good find = new Good();
        try {
            find = goodFacade.find(id);
        } catch (Exception e) {
            LOGGER.error("Error on findById Method. " + e.getMessage(), e);
            throw e;
        }
        return find;
    }

    /**
     * Metodo encargado de invocar al facade de Good para listar los bienes por
     * tipo de bien
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    public List<Good> findByGoodType(BigInteger id) throws Exception {
        List<Good> find = new ArrayList();
        try {
            find = goodFacade.findByGoodType(id);
        } catch (Exception e) {
            LOGGER.error("Error on findById Method. " + e.getMessage(), e);
            throw e;
        }
        return find;
    }

    /**
     * Metodo encargado de invocar al facade de Good para listar los bienes por
     * serial
     *
     * @param serial
     * @return
     * @throws java.lang.Exception
     */
    public List<Good> findBySerial(BigInteger serial) throws Exception {
        List<Good> find = new ArrayList();
        try {
            find = goodFacade.findByGoodSerial(serial);
        } catch (Exception e) {
            LOGGER.error("Error on findBySerial Method. " + e.getMessage(), e);
            throw e;
        }
        return find;
    }

    /**
     * Metodo encargado de invocar al facade de Good para listar los bienes por
     * su fecha de compra
     *
     * @param purchaseDate
     * @return
     * @throws java.lang.Exception
     */
    public List<Good> findByPruchaseDate(Date purchaseDate) throws Exception {
        List<Good> find = new ArrayList();
        try {
            find = goodFacade.findByGoodPurchaseDate(purchaseDate);
        } catch (Exception e) {
            LOGGER.error("Error on findBySerial Method. " + e.getMessage(), e);
            throw e;
        }
        return find;
    }

    /**
     * Metodo encargado de invocar al facade de Good para crear un nuevo bien
     *
     * @param good
     * @return
     * @throws java.lang.Exception
     */
    public ReturnOperation save(Good good) throws Exception {
        ReturnOperation result = new ReturnOperation();
        try {
            goodFacade.create(good);
            return result;
        } catch (Exception e) {
            LOGGER.error("Error creando GoodManager", e);
            result.setCode(ReturnOperation.ERROR);
            result.setMessage(e.getMessage());
            throw e;
        }
    }

    /**
     * Metodo encargado de invocar al facade de Good para editar los bienes
     *
     * @param good
     * @return
     * @throws java.lang.Exception
     */
    public ReturnOperation edit(Good good) throws Exception {
        ReturnOperation result = new ReturnOperation();
        try {
            goodFacade.edit(good);
            return result;
        } catch (Exception e) {
            LOGGER.error("Error editando GoodManager", e);
            result.setCode(ReturnOperation.ERROR);
            result.setMessage(e.getMessage());
            throw e;
        }
    }

    /**
     * Metodo encargado de invocar al facade de Good para eliminar bienes
     *
     * @param good
     * @return
     * @throws java.lang.Exception
     */
    public ReturnOperation delete(Good good) throws Exception {
        ReturnOperation result = new ReturnOperation();
        try {
            if (good == null || good.getGoodId() == null) {
                result.setCode(ReturnOperation.MISSING_INFO);
                result.setMessage("Missing Data, cant delete from DB ");
            } else {
                goodFacade.remove(good);
            }
        } catch (Exception e) {
            LOGGER.error("Error on delete Method. id:" + (good == null && good.getGoodId() == null ? "___" : good.getGoodId()) + ". " + e.getMessage(), e);
            throw e;
        }
        return result;
    }
}
