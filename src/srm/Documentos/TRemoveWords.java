/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm.Documentos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TRemoveWords {
    
    private final List<String> adverbios;
    private final List<String> stopwords;
    
    private List<String> get(String nome){
        List<String> lista = new ArrayList<>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(Consts.getAbsoluthPath() + Consts.pathWords+nome));
            while (bf.ready()) {
                lista.add(bf.readLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TRemoveWords.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TRemoveWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public TRemoveWords(){
        this.adverbios = get("adverbios.txt");
        this.stopwords = get("stopwords.txt");
    }

    public List<String> getAdverbios() {
        return adverbios;
    }

    public List<String> getStopwords() {
        return stopwords;
    }

    
}
