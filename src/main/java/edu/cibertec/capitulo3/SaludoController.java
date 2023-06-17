package edu.cibertec.capitulo3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaludoController {
    
    @RequestMapping("saludo")
    public ModelAndView saludar() {
        return new ModelAndView("saludo", "mensaje", "Bienvenido desde el controlador MV");
    }
}
