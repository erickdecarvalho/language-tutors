package com.languagetutors.api.domain.aula;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AulaRepository extends JpaRepository<Aula, Long> {

    Boolean existsByProfessorIdAndData(Long idProfessor, LocalDateTime data);
}
