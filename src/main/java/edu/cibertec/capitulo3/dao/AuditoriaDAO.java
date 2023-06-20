package edu.cibertec.capitulo3.dao;

import edu.cibertec.capitulo3.dao.entity.AuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriaDAO extends JpaRepository<AuditoriaEntity,Integer> {
}
