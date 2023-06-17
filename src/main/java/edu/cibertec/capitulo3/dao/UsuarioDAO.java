package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDAO extends JpaRepository<UsuarioEntity, String> {

    public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);

}
