package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.dao.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaDAO extends JpaRepository<MatriculaEntity,Integer> {


}
