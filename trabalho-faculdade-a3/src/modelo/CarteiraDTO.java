package modelo;

import java.util.Date;

public class CarteiraDTO {
    private int id;
    private Date  dt_emissao;
    private Date dt_vencimento;
    private int aluno_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDt_emissao() {
        return dt_emissao;
    }

    public void setDt_emissao(Date dt_emissao) {
        this.dt_emissao = dt_emissao;
    }

    public Date getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public String getAluno_nome() {
        return aluno_nome;
    }

    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    public String getAluno_cpf() {
        return aluno_cpf;
    }

    public void setAluno_cpf(String aluno_cpf) {
        this.aluno_cpf = aluno_cpf;
    }
    private String aluno_nome;
    private String aluno_cpf;
}
