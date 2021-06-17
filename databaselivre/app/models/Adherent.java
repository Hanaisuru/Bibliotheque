package models ;

import java.util.*;
import io.ebean.*;
import javax.persistence.*;


@Entity
public class Adherent extends Model {
  
    private static final long serialVersionUID = 1L;

    @Id
    private long idAdh;    
    private String nom ;
    private String prenom;
    private int nbAnneeAdh ;
    private String adherentMtn;
    
    public Adherent(String nom, String prenom, int nbAnneeAdh, String adherentMtn){
        this.nom=nom;
        this.prenom=prenom;
        this.nbAnneeAdh=nbAnneeAdh;
        this.adherentMtn=adherentMtn;
    }
    
    public Adherent(){   
    }
    
    public Long getIdAdh(){
        return this.idAdh;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public int getNbAnneeAdh(){
        return this.nbAnneeAdh;
    }
    
    public String getAdherentMtn(){
      return this.adherentMtn;
    }
    
    public void setIdAdh(long idAdh){
        this.idAdh=idAdh;
    }
    
    public void setNom(String nom){
        this.nom= nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public void setNbAnneeAdh(int nbAnneeAdh){
        this.nbAnneeAdh = nbAnneeAdh;
    }
    
    public void setAdherentMtn(String adherentMtn){
        if ((adherentMtn.equals("Oui"))|(adherentMtn.equals("Non"))){
        this.adherentMtn=adherentMtn;   
        }
        else{
            
        }
    }
    
    public static Finder<Long, Adherent> find = new Finder<Long,Adherent>(Adherent.class);
}