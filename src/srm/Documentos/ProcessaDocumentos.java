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
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author root
 */
public final class ProcessaDocumentos {
    
    private final List<TDocumentos> listaDocs;
    private final TRemoveWords rmw;
    
    public ProcessaDocumentos() throws FileNotFoundException{
        File file = new File(Consts.getAbsoluthPath()+Consts.pathDocs);
        File[] files = file.listFiles();
        this.listaDocs = new ArrayList<>();
        this.rmw = new TRemoveWords();
        
        
        for (File f : files) {
            List<String> termosArquivo = this.getListaTermosArquivo(f); 
            TDocumentos doc = new TDocumentos();
            doc.setNomeDocumento(f.getName());
            doc.setPathDocumento(f.getPath());
            doc.setListaTermos(getTermos(termosArquivo));
            doc.setTotalTermos(doc.getListaTermos().size());
            listaDocs.add(doc);
            
        }
    }
    
    private List<TTermo> getTermos(List<String> lista){
        List<TTermo> listaTermos = new ArrayList<>();
        List<String> termosArquivo = lista;
        
        for(String t: lista){
           TTermo termo = new TTermo();
           termo.setTermo(t);
           
           for (String t1 : lista){
               if (t1.equals(t)){
                   termo.inc();
               }
           }
           
           listaTermos.add(termo);
           
        }
        
        return listaTermos;
    }
    
    private List<String> getListaTermosArquivo(File file){
        BufferedReader bf = null;
        List<String> lista = new ArrayList<>();
        try {
            bf = new BufferedReader(new FileReader(file));
            try {
                while(bf.ready()){
                    //String[] linha = bf.readLine().toLowerCase().split(",|:|;|!|<|>|=|" + Pattern.quote("|") + "|" + Pattern.quote("(") + "|" + Pattern.quote(")") + "|" + Pattern.quote("?") + "|" + Pattern.quote("+") + "|" + Pattern.quote("*") + "|" + Pattern.quote(".") + "|" + Pattern.quote("-") + "|" + Pattern.quote("\"") + "|" + Pattern.quote("\'"));
                   Pattern p = Pattern.compile("(\\d+)|([a-záéíóúçãõôê]+)");
                   Matcher m = p.matcher(bf.readLine());
                   
                   while (m.find()){
                       String s = m.group();
                       
                       if (this.rmw.getAdverbios().contains(s))
                           continue;
                       if (this.rmw.getStopwords().contains(s))
                           continue;
                       
                       lista.add(s);
                   }
                    
                  
                }
            } catch (IOException ex) {
                Logger.getLogger(ProcessaDocumentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProcessaDocumentos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(ProcessaDocumentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lista;
    }

    public List<TDocumentos> getListaDocs() {
        return listaDocs;
    }
    
    

    
}
