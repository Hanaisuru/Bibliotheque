package models ;

import java.util.*;
import io.ebean.*;
import javax.persistence.*;


@Entity
public class Livre extends Model {
  
    private static final long serialVersionUID = 1L;

    @Id
    private long id;    
    private String titre ;
    private String auteur;
    private int anneeParue ;
    private double prix;
    
    public Livre(String titre, String auteur, int anneeParue, double prix){
        this.titre=titre;
        this.auteur=auteur;
        this.anneeParue=anneeParue;
        this.prix=prix;
    }
    
    public Livre(){   
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getTitre(){
        return this.titre;
    }
    
    public String getAuteur(){
        return this.auteur;
    }
    
    public int getAnneeParue(){
        return this.anneeParue;
    }
    
    public double getPrix(){
        return this.prix;
    }
    
    public void setId(long id){
        this.id=id;
    }
    
    public void setTitre(String titre){
        this.titre = titre;
    }
    
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }
    
    public void setAnneeParue(int anneeParue){
        this.anneeParue = anneeParue;
    }
    
    public void setPrix(double prix){
        this.prix=prix;
    }
    
    public static Finder<Long, Livre> find = new Finder<Long,Livre>(Livre.class);
}