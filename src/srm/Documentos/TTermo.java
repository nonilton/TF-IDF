/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm.Documentos;

/**
 *
 * @author root
 */
public class TTermo {
    private String termo;
    private int frequencia;

    public TTermo() {
        this.frequencia = 0;
    }
    
    public void inc(){
        this.frequencia += 1;
    }
    
    public int getFrequencia(){
        return this.frequencia;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }
    
    
    
    
    
}
