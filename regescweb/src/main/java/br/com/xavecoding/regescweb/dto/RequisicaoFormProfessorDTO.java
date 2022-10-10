package br.com.xavecoding.regescweb.dto;

import br.com.xavecoding.regescweb.models.Professor;
import br.com.xavecoding.regescweb.models.StatusProfessor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RequisicaoFormProfessorDTO {
    @NotBlank
    @NotNull
    private String nome;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal salario;
    private StatusProfessor status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public StatusProfessor getStatus() {
        return status;
    }

    public void setStatus(StatusProfessor status) {
        this.status = status;
    }

    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatus(this.status);

        return professor;
    }

    public void fromProfessor(Professor professor){
        this.nome = professor.getNome();
        this.salario = professor.getSalario();
        this.status = professor.getStatus();
    }

    public Professor toProfessor(Professor professor){
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatus(this.status);

        return professor;
    }
    @Override
    public String toString() {
        return "RequisicaoNovoProfessorDTO{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                ", status=" + status +
                '}';
    }
}
