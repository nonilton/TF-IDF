/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm.Documentos;

import java.io.File;

/**
 *
 * @author root
 */
public class Consts {
    public static final String pathWords = "/source/";
    public static final String pathDocs = "/docs/";
    
    public static String getAbsoluthPath(){
        return new File("").getAbsolutePath();
    }
    
}
