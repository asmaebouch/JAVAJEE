package dao.daoMySQL;

import dao.IDao;
import dao.Utilisateur;

import java.util.List;

public class UtilisateurDao implements IDao<Utilisateur,Long> {
    @Override
    public Utilisateur trouveParId(Long aLong) {
        return null;
    }

    @Override
    public List<Utilisateur> findAll() {
        return null;
    }

    @Override
    public Utilisateur save(Utilisateur objet) {
        return null;
    }

    @Override
    public Utilisateur update(Utilisateur objet) {
        return null;
    }

    @Override
    public Boolean delete(Utilisateur objet) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
