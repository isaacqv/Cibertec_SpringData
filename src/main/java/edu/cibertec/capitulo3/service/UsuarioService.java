package edu.cibertec.capitulo3.service;

import edu.cibertec.capitulo3.dao.UsuarioDAO;
import edu.cibertec.capitulo3.dao.entity.UsuarioEntity;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
     public UsuarioEntity validarLogin(UsuarioEntity usuario){
         /*UsuarioEntity rpta = getUsuario(usuario.getUsuario());
         if(rpta==null){
             return rpta;
         }
         if (!rpta.getClave().equalsIgnoreCase(usuario.getClave())){
             rpta = null;
         }*/
         UsuarioEntity rpta = usuarioDAO.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
         return rpta;
     }
     
     public void insertarUsuario(UsuarioEntity usuario){
         usuarioDAO.save(usuario);
     }
     
     public List<UsuarioEntity> getListaUsuarios(){
         return usuarioDAO.findAll();
     }
    public List<UsuarioEntity> getListaUsuarios(Pageable pagina){
        return usuarioDAO.findAll(pagina).getContent();
    }

     public UsuarioEntity getUsuario(String codigo){
         UsuarioEntity rpta = null;
         Optional<UsuarioEntity> busqueda = usuarioDAO.findById(codigo);
         if (busqueda.isPresent()){
             rpta = busqueda.get();
         }
         return rpta;
     }

    public void eliminarUsuario(String codigo) {
        usuarioDAO.deleteById(codigo);
    }

    // Tarea Eliminar un Usuario
    // Editar un usuario

}
