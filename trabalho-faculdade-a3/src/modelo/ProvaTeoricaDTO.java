package modelo;

import java.util.Date;

public class ProvaTeoricaDTO {
    
    private int idAluno;
    private int acertos;
    private String respostaAluno;
    private Date data_prova;
    private String resultado;

    public int getAcertos() {
        return acertos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public Date getData_prova() {
        return data_prova;
    }

    public void setData_prova(Date data_prova) {
        this.data_prova = data_prova;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public String getRespostaAluno() {
        return respostaAluno;
    }

    public void setRespostaAluno(String respostaAluno) {
        this.respostaAluno = respostaAluno;
    }
}
