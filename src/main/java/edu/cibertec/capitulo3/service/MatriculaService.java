package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.AuditoriaDAO;
import edu.cibertec.capitulo3.dao.MatriculaDAO;
import edu.cibertec.capitulo3.dao.entity.AuditoriaEntity;
import edu.cibertec.capitulo3.dao.entity.MatriculaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaDAO matriculaDAO;
    @Autowired
    private AuditoriaDAO auditoriaDAO;

    public List<MatriculaEntity> listarTodas(){
        return matriculaDAO.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void grabarMatricula(MatriculaEntity me){
        matriculaDAO.save(me);
        AuditoriaEntity ae = new AuditoriaEntity(0,new Date(Calendar.getInstance().getTimeInMillis()),
                me.getUsuario(),"Insertando matricula " + me.getIdMatricula());
        //Para forzar error
        AuditoriaEntity ae2 = new AuditoriaEntity(0,new Date(Calendar.getInstance().getTimeInMillis()),
                null,"Insertando matricula " + me.getIdMatricula());
        auditoriaDAO.save(ae2);
    }
}
