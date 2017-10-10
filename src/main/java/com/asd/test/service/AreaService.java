/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.service;

import com.asd.test.entity.Area;
import com.asd.test.manager.AreaManager;
import com.asd.test.utils.ReturnOperation;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 *
 * @author Teddy
 */
@Stateless
@Path(value = "/Area")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class AreaService {

    /**
     * Logger
     */
    public static final Logger LOGGER = Logger.getLogger(AreaService.class);

    @EJB
    AreaManager manager;

    /**
     * Encargado de consulta via REST para obtener todas los Areas
     *
     * @return
     */
    @GET
    @Path("/findAll")
    public Response findAll() {
        Response response = null;
        Gson gson = new Gson();
        List<Area> find = new ArrayList();
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

}
