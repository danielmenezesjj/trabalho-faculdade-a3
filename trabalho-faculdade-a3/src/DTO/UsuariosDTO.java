/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class UsuariosDTO extends Usuario {

    private int perfil_usuario;
    private boolean admin;

    public int getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(int perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
