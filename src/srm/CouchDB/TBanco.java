/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srm.CouchDB;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

/**
 * Classe de acesso ao banco counchDB
 * @author root
 */
public class TBanco {
    public static final String host = "localhost";
    public static final Cluster cluster = CouchbaseCluster.create(host);
    public static final String nomeBanco = "default";
    
    public static Bucket getBanco(){
        return TBanco.cluster.openBucket(TBanco.nomeBanco);
    }
    
}
