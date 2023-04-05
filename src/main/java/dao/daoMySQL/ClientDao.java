package dao.daoMySQL;

import dao.Client;
import dao.Credit;
import dao.IDao;
import dao.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDao implements IDao<Client,Long> {
    MySqlSessionFactory factory;

    @Override
    public Client trouveParId(Long idCredit) throws DaoException
    {

        return null;
    }

    @Override
    public List<Client> findAll() throws DaoException
    {
        return null;
    }

    @Override
    public Client save(Client objet) throws DaoException
    {
        return null;
    }

    @Override
    public Client update(Client objet) throws DaoException
    {
        return null;
    }

    @Override
    public Boolean delete(Client objet) throws DaoException
    {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) throws DaoException
    {
        return null;
    }
    public Credit map(ResultSet rs) throws DaoException{
        try {
            long id = rs.getLong("id");

            double cp = rs.getDouble("capital");
            int nbrM= rs.getInt("nbMois");
            double taux = rs.getDouble("taux");
            int idClient= rs.getInt("demandeur");
            double mensulite = rs.getDouble("mensualite");
            var client=factory.getClientDao().trouveParId((long)idClient);
            return new Credit(id,cp,nbrM,taux,client,mensulite);
        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }



    }
}
