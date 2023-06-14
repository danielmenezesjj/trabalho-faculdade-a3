package services;

import controle.aluno.PagamentoDAO;
import modelo.AlunoDTO;
import modelo.PagamentoDTO;
import visao.aluno.servicos.ProvaTeorica;

public class AlunoServices {

    public void fazerProvaTeorica() {
        new ProvaTeorica().setVisible(true);
    }
    
    public void pagarBoleto(int idItem){   
        int idAluno = new AlunoDTO().usuarioLogado.getId_usuario();
        PagamentoDTO pgmtDto = new PagamentoDTO();
        pgmtDto.setItem_id(idItem);
        pgmtDto.setAluno_id(idAluno);   
         
        new PagamentoDAO().cadastrar(pgmtDto); 
    }    
}
