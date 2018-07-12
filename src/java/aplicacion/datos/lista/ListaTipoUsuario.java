/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.lista;

import java.util.ArrayList;

/**
 *
 * @author Agustin
 */
public class ListaTipoUsuario {
    private ArrayList<String> listaTipos;
    public ListaTipoUsuario() {
        listaTipos=new ArrayList();
    }

    /**
     * @return the listaTipos
     */
    public ArrayList<String> getListaTipos() {
        return listaTipos;
    }

    /**
     * @param listaTipos the listaTipos to set
     */
    public void setListaTipos(ArrayList<String> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
}
