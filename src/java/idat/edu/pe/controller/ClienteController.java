/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.controller;

import com.google.gson.Gson;
import idat.edu.pe.model.Alumno;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author LuisAngel
 */
@Controller
public class ClienteController {
    
    
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index (Model model){
        //MantAlumnoDAO objAlumnoDAO = new MantAlumnoDAO();
        //List<Alumno> lstAlumnos = objAlumnoDAO.ListarAlumnos();
        String URL_PRINCIPAL = "http://localhost:8080/WSRestSpringBD/Alumno/ListarAlumnosxEspec/";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(URL_PRINCIPAL+"E03", String.class);
        Alumno[] lst = new Gson().fromJson(result, Alumno[].class);
        List<Alumno> mcList = new ArrayList<>(Arrays.asList(lst));
        model.addAttribute("dato",mcList);
        return "index";
    }
    
    
}
