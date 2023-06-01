package modelo;

public class UsuarioDTO extends Usuario {  
    private String tipo_perfil;

    public String getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(String tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }
}
