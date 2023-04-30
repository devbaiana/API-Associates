package com.IBM.associates.repository;

import com.IBM.associates.entidades.Estagiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociatesRepository extends JpaRepository<Estagiario, Long> {
}
