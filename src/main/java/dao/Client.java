package dao;

public class Client extends Utilisateur{
    private String email,cin,tel,adresse;
    private Sexe sexe;

    public void SetNomComplet(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }

}
