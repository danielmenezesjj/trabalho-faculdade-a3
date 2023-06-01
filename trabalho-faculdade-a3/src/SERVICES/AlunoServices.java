package services;

import controle.ExameDAO;
import controle.PagamentoDAO;
import modelo.ExameDTO;
import modelo.PagamentoDTO;
import modelo.UsuarioDTO;
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
    
    public void fazerExame(int tipoExameId){
        ExameDTO exameDto = new ExameDTO();
        exameDto.setAluno_id(UsuarioDTO.usuarioLogado.getId_usuario());
        exameDto.setTipo_exame_id(tipoExameId);
        
        new ExameDAO().cadastrarExame(exameDto);
    }
}
