/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import srm.Documentos.TProcessaDocumentos;
import srm.Documentos.TDocumentos;
import srm.Documentos.TTermo;

/**
 *
 * @author root
 */
public class SRM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       TProcessaDocumentos pd;
        try {
            pd = new TProcessaDocumentos();
            
            for(TDocumentos d: pd.getListaDocs()){
                System.out.println("doc: " + d.getNomeDocumento());
                System.out.println("totalTermos: " + d.getTotalTermos());
                
                for (TTermo t: d.getListaTermos()){
                    System.out.println("termo: " + t.getTermo() + " frequencia: " + t.getFrequencia());
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SRM.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    
    }
    
}
