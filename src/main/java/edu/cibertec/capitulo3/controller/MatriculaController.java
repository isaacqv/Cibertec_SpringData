package edu.cibertec.capitulo3.controller;

import edu.cibertec.capitulo3.dao.entity.CursoEntity;
import edu.cibertec.capitulo3.dao.entity.MatriculaEntity;
import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;
import edu.cibertec.capitulo3.service.CursoService;
import edu.cibertec.capitulo3.service.MatriculaService;
import edu.cibertec.capitulo3.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("matriculaMostrar")
    public ModelAndView matriculaMostrar(){
        ModelAndView mv = new ModelAndView("matricula", "listaMat", matriculaService.listarTodas());
        mv.addObject("listaUsu",usuarioService.getListaUsuarios());
        mv.addObject("listaCur",cursoService.consultarPorEstado(0));
        return mv;
    }

    @RequestMapping("matriculaGrabar")
    public ModelAndView matriculaGrabar(MatriculaEntity entity, HttpServletRequest request){

        try {
            CursoEntity ce = new CursoEntity();
            ce.setIdCurso(Integer.parseInt(request.getParameter("cmbCurso")));
            UsuarioEntity ue = new UsuarioEntity();
            ue.setUsuario(request.getParameter("cmbUsuario"));

            entity.setCurso(ce);
            entity.setUsuario(ue);

            matriculaService.grabarMatricula(entity);
            return new ModelAndView("redirect:matriculaMostrar.do");

        } catch (Exception e) {
            ModelAndView mv = new ModelAndView("exception");
            mv.addObject("errorMessage", "Ocurrio un error al grabar la matrícula: \n" + e.getMessage());
            return mv;
        }

    }
}
