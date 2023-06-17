package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.CursoDAO;
import edu.cibertec.capitulo3.dao.entity.CursoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoDAO cursoDAO;

    public List<CursoEntity> consultarPorEstado(int estado) {
        return cursoDAO.consultarPorEstado(estado);
    }

    public List<CursoEntity> consultarAbiertoIncompleto(){
        return cursoDAO.abiertoIncompleto();
    }

    public List<CursoEntity> consultarPorFecha(Date fecha){
        return cursoDAO.consultaPorFecha(fecha);
    }

    public List<CursoEntity> consultarFaltantes(Integer cantidad){
        return cursoDAO.consultarFaltantes(cantidad);
    }

    public List<CursoEntity> consultarPorNombre(String cadena){
        return cursoDAO.consultarPorNombre(cadena);
    }
}
