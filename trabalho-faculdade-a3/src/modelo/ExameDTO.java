package modelo;

public class ExameDTO {
    private int id;
    private int tipo_exame_id;
    private int aluno_id;
    private String resultado;
    private String aluno_nome;
    private String aluno_cpf;

    public String getAluno_cpf() {
        return aluno_cpf;
    }

    public void setAluno_cpf(String aluno_cpf) {
        this.aluno_cpf = aluno_cpf;
    }

    public String getAluno_nome() {
        return aluno_nome;
    }

    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo_exame_id() {
        return tipo_exame_id;
    }

    public void setTipo_exame_id(int tipo_exame_id) {
        this.tipo_exame_id = tipo_exame_id;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}
