package com.languagetutors.api.domain.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("""
            select p from Professor p
            where
            p.idioma = :idioma
            and
            p.id not in(
                    select a.professor.id from Aula a
                    where
                    a.data = :data
            )
            order by rand()
            limit 1
            """)
    Professor escolherProfessorAleatorioLivreNaData(Idioma idioma, LocalDateTime data);
}
