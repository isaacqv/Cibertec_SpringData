package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.dao.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface CursoDAO extends JpaRepository<CursoEntity, Integer> {

    //Consulta de cursos por estado
    @Query("SELECT c FROM CursoEntity c WHERE c.estado = ?1")
    List<CursoEntity> consultarPorEstado(int estado);

    //Consulta de cursos abiertos pero aun no completos
    //Lo trae desde el NamedQuery de la Entidad
    List<CursoEntity> abiertoIncompleto();

    //Consulta de cursos despues de la fecha x
    @Query("SELECT c FROM CursoEntity c WHERE c.fechaInicio >= :fecha")
    List<CursoEntity> consultaPorFecha(@Param("fecha") Date fecha);

    //Consulta de cursos a los que les falta X números de alumnos para llenarse
    @Query(value = "SELECT * FROM curso WHERE alumnosMin - alumnosAct = :cantidad", nativeQuery = true)
    List<CursoEntity> consultarFaltantes(@Param("cantidad") Integer cantidad);

    //Consulta de cursos por su nombre
    //Invocacion a un Stored Procedure
    @Query(nativeQuery = true, value = "call Curso_Por_Nombre(:cadena)")
    List<CursoEntity> consultarPorNombre(@Param("cadena") String cadena);
}
