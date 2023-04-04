package dao;

public class Utilisateur {
    protected Long id;
    protected String login,motDePass,nom,prenom;
    protected Role role;
    public String nomComplet(){return prenom +""+nom;}
}
