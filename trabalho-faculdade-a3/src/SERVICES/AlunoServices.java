package SERVICES;

import controle.PagamentoDAO;
import modelo.PagamentoDTO;
import visao.aluno.servicos.ProvaTeorica;

public class AlunoServices {

    public void fazerProvaTeorica() {
        new ProvaTeorica().setVisible(true);
    }
    
    public void pagarBoleto(int idItem, int idAluno){
        PagamentoDTO pgmtDto = new PagamentoDTO();
        pgmtDto.setItem_id(idItem);
        pgmtDto.setUsuario_id(idAluno);      
        new PagamentoDAO().cadastrar(pgmtDto); 
    }
}
