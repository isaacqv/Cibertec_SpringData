package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoMostrar")
    public String CursoMostrar(){
        return "cursoBusqueda";
    }

    @RequestMapping("cursoBusqueda")
    public ModelAndView loginAccion(HttpServletRequest request){

        ModelAndView mv = new ModelAndView("cursoBusqueda");

        String tipoConsulta = request.getParameter("tipo");

        switch (tipoConsulta){
            case "estado":
                int estado = Integer.parseInt(request.getParameter("estado"));
                mv.addObject("lista", cursoService.consultarPorEstado(estado));
                break;
            case "incompleto":
                mv.addObject("lista", cursoService.consultarAbiertoIncompleto());
                break;
            case "porfecha":
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                mv.addObject("lista", cursoService.consultarPorFecha(fecha));
                break;
            case "faltante":
                int faltante = Integer.parseInt(request.getParameter("numero"));
                mv.addObject("lista", cursoService.consultarFaltantes(faltante));
                break;
            case "nombre":
                String cadena = request.getParameter("cadena");
                mv.addObject("lista", cursoService.consultarPorNombre(cadena));
                break;
            default:
                mv.addObject("lista",null);
                break;
        }
        return mv;
    }
}
