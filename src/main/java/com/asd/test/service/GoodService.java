/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.service;

import com.asd.test.utils.ReturnOperation;
import com.asd.test.entity.Good;
import com.asd.test.manager.GoodManager;
import com.asd.test.utils.ClassUtilities;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 *
 * @author Teddy
 */
@Stateless
@Path(value = "/Good")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class GoodService {

    /**
     * Logger
     */
    public static final Logger LOGGER = Logger.getLogger(GoodService.class);

    @EJB
    GoodManager manager;

    /**
     * Encargado de consulta via REST para obtener todos los bienes
     *
     * @return
     */
    @GET
    @Path("/findAll")
    public Response findAll() {
        Response response = null;
        Gson gson = new Gson();
        List<Good> find = new ArrayList();
        LOGGER.info("Begin @GET method findAll...");
        try {
            find = manager.findAll();
            if (find == null || find.isEmpty()) {
                response = Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(new ReturnOperation(ReturnOperation.NOT_FOUND, "No records found", new Date().getTime()))).build();
            } else {
                response = Response.ok(gson.toJson(find)).build();
            }
        } catch (Exception e) {
            LOGGER.error("Error on GET method findAll" + e.getMessage(), e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(new ReturnOperation(ReturnOperation.ERROR, e.getMessage(), new Date().getTime()))).build();
            return response;
        }
        return response;
    }

    /**
     * Encargado de consulta via REST para obtener los bienes con base al
     * identificador de bien solicitado
     *
     * @param id
     * @return
     */
    @GET
    @Path("/find/{id}")
    public Response find(@PathParam("id") BigDecimal id) {
        LOGGER.info("Begin @GET method find...");
        Gson gson = new Gson();
        Response response = null;
        Good good = new Good();
        try {
            good = manager.findById(id);
            if (good == null) {
                response = Response.status(Response.Status.NOT_FOUND).entity(gson.toJson(new ReturnOperation(ReturnOperation.NOT_FOUND, "Good not found. id:" + id, new Date().getTime()))).build();
            } else {
                response = Response.ok(gson.toJson(good)).build();
            }
        } catch (Exception e) {
            LOGGER.error("Error on @GET method find. " + e.getMessage(), e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(new ReturnOperation(ReturnOperation.ERROR, e.getMessage(), new Date().getTime()))).build();
            return response;
        }
        LOGGER.info("End @GET method find...");
        return response;
    }

    /**
     * Encargado de consulta via REST para obtener todos los bienes cuyo tipo
     * concuerde con el argumento enviado
     *
     * @param type
     * @return
     */
    @GET
    @Path("/find/type/{type}")
    public Response findByType(@PathParam("type") BigInteger type) {
        LOGGER.info("Begin @GET method findByType...");
        Gson gson = new Gson();
        Response response = null;
        List<Good> goodList = new ArrayList();
        try {
            goodList = manager.findByGoodType(type);
            if (goodList == null || goodList.isEmpty()) {
                response = Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("Good not found. type" + type)).build();
            } else {
                response = Response.ok(gson.toJson(goodList)).build();
            }
        } catch (Exception e) {
            LOGGER.error("Error on @GET method findByType. " + e.getMessage(), e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(new ReturnOperation(ReturnOperation.ERROR, e.getMessage(), new Date().getTime()))).build();
            return response;
        }
        LOGGER.info("End @GET method findByType...");
        return response;
    }

    /**
     * Encargado de consulta via REST para obtener todos los bienes cuyo serial
     * concuerde con el parametro enviado
     *
     * @param serial
     * @return
     */
    @GET
    @Path("/find/serial/{serial}")
    public Response findBySerial(@PathParam("serial") BigInteger serial) {
        LOGGER.info("Begin @GET method findBySerial...");
        Gson gson = new Gson();
        Response response = null;
        List<Good> goodList = new ArrayList();
        try {
            goodList = manager.findBySerial(serial);
            if (goodList == null || goodList.isEmpty()) {
                response = Response.status(Response.Status.NOT_FOUND).entity(gson.toJson("Good not found. serial" + serial)).build();
            } else {
                response = Response.ok(gson.toJson(goodList)).build();
            }
        } catch (Exception e) {
            LOGGER.error("Error on @GET method findBySerial. " + e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(new ReturnOperation(ReturnOperation.ERROR, e.getMessage(), new Date().getTime()))).build();

        }
        LOGGER.info("End @GET method findBySerial...");
        return response;
    }

    /**
     *
     * @param numRows
     * @param firstRow
     * @return
     */
    @GET
    @Path("/findRange/{numRows}/{firstRow}")
    public List<Good> findRange(@PathParam("numRows") int numRows,
            @PathParam("firstRow") int firstRow) {
        return manager.findRange(numRows, firstRow);
    }

    /**
     * Encargado de editar informacion para un bien determinado, consultando
     * antes, si el mismo existe, y luego, sobreescribiendo la informacion
     *
     * @param good
     * @return
     */
    @PUT
    @Path("/")
    public ReturnOperation edit(Good good) {
        LOGGER.info("Begin @PUT method edit...");
        ReturnOperation result = new ReturnOperation();
        Good goodCopy = new Good();
        boolean isUpdate = true;
        try {
            if (good == null || good.getGoodId() == null) {
                result.setCode(ReturnOperation.MISSING_INFO);
                result.setMessage("Missing Data. id is needed in order to update");
            } else {
                goodCopy = manager.findById(good.getGoodId());
                if (goodCopy == null) {
                    result.setCode(ReturnOperation.NOT_FOUND);
                    result.setMessage("Good doesnt exist. Impossible to update");
                } else {
                    isUpdate = ClassUtilities.comparePurchAndDischargeDates(good.getPurchaseDate(), good.getDischargeDate());
                    if (isUpdate) {
                        manager.edit(good);
                        LOGGER.info("Updated Good with id: " + good.getGoodId());
                    } else {
                        result.setCode(500);
                        result.setMessage("PURCHASE_DATE cant be greater than DISCHARGE_DATE");
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error on edit Method. " + e.getMessage(), e);
            result.setCode(ReturnOperation.ERROR);
            result.setMessage(e.getMessage());
            return result;
        }
        LOGGER.info("End @GET method findBySerial...");
        return result;
    }

    /**
     * Encargado de insertar un nuevo bien. Ya que el identificador es auto
     * generado, este no debe ser enviado. De lo contrario, no se realizara la
     * insercion
     *
     * @param good
     * @return
     */
    @POST
    @Path("/")
    public ReturnOperation insert(Good good) {
        ReturnOperation result = new ReturnOperation();
        boolean isInsert = true;
        LOGGER.info("Begin @POST method");
        try {
            if (good == null) {
                result.setCode(ReturnOperation.MISSING_INFO);
                result.setMessage("Missing Data. error Inserting");
            } else {
                isInsert = ClassUtilities.comparePurchAndDischargeDates(good.getPurchaseDate(), good.getDischargeDate());
                if (isInsert) {
                    result = manager.save(good);
                } else {
                    result.setCode(ReturnOperation.ERROR);
                    result.setMessage("PURCHASE_DATE cant be greater than DISCHARGE_DATE");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error on @POST Method. " + e.getMessage(), e);
            result.setCode(ReturnOperation.ERROR);
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    /**
     * Encargado de eliminar un Bien, para tal fin, con el identificador enviado
     * como parametro, sera consultado y se procedera a borrar el mismo
     *
     * @param goodId
     * @return
     */
    @DELETE
    @Path("/{id}")
    public ReturnOperation delete(@PathParam("id") BigDecimal goodId) {
        LOGGER.info("Begin @DELETE method");
        ReturnOperation result = new ReturnOperation();
        Good good = new Good();
        try {
            good = manager.findById(goodId);
            if (good == null) {
                result.setCode(ReturnOperation.NOT_FOUND);
                result.setMessage("Good doesnt exist. Impossible to delete");
            } else {
                manager.delete(good);
                LOGGER.info("Deleted Good with id: " + good.getGoodId());
            }
        } catch (Exception e) {
            LOGGER.error("Error on delete Method. id:" + goodId + ". " + e.getMessage(), e);
            result.setCode(ReturnOperation.ERROR);
            result.setMessage(e.getMessage());
            return result;
        }
        LOGGER.info("End @DELETE method");
        return result;
    }

}
