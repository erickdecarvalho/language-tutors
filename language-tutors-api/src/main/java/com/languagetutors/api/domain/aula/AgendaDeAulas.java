package com.languagetutors.api.domain.aula;

import com.languagetutors.api.domain.aluno.AlunoRepository;
import com.languagetutors.api.domain.aula.validacoes.ValidadorAgendamentoDeAula;
import com.languagetutors.api.domain.professor.Professor;
import com.languagetutors.api.domain.professor.ProfessorRepository;
import com.languagetutors.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeAulas {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private List<ValidadorAgendamentoDeAula> validadores;

    public DadosDetalhamentoAula agendar(DadosAgendamentoAula dados) {

        if (!alunoRepository.existsById(dados.idAluno())) {
            throw new ValidacaoException("Id do aluno informado não existe");
        }

        if (dados.idProfessor() != null && !professorRepository.existsById(dados.idProfessor())) {
            throw new ValidacaoException("Id do professor informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));

        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var professor = escolherProfessor(dados);

        var aula = new Aula(null, professor, aluno, dados.data());

        aulaRepository.save(aula);

        return new DadosDetalhamentoAula(aula);
    }

    private Professor escolherProfessor(DadosAgendamentoAula dados) {
        if (dados.idProfessor() != null) {
           return professorRepository.getReferenceById(dados.idProfessor());
        }

        if (dados.idioma() == null) {
            System.out.println(dados.idioma());
            throw new ValidacaoException("Idioma é obrigatório quando professor não for escolhido!");
        }

        return professorRepository.escolherProfessorAleatorioLivreNaData(dados.idioma(), dados.data());
    }

}
