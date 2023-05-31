package modelo;

public class ExameDTO {
    private int id;
    private int tipo_exame_id;
    private int aluno_id;
    private String resultado = "aguardando...";

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
