/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm.Documentos;

import java.util.List;



/**
 * Classe para manipulação de documentos retornados do banco de dados.
 * @author root
 */
public class TDocumentos {
    private String nomeDocumento;
    private String pathDocumento;
    private int totalTermos;
    private List<TTermo> listaTermos;

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }

    public String getPathDocumento() {
        return pathDocumento;
    }

    public void setPathDocumento(String pathDocumento) {
        this.pathDocumento = pathDocumento;
    }

    public int getTotalTermos() {
        return totalTermos;
    }

    public void setTotalTermos(int totalTermos) {
        this.totalTermos = totalTermos;
    }

    public List<TTermo> getListaTermos() {
        return listaTermos;
    }

    public void setListaTermos(List<TTermo> listaTermos) {
        this.listaTermos = listaTermos;
    }
    
    
}
