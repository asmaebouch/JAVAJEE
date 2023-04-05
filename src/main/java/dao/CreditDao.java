package dao;

import BD.Fabrique.FabriqueMySql;
import dao.daoMySQL.MySqlSessionFactory;
import dao.daoMySQL.Utilitaire;
import dao.exceptions.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Component("dao")

public class CreditDao implements IDao<Credit,Long> {
   // FabriqueMySql factory;
    Connection connection;
   // public CreditDao(Connection connection){
     //   this.connection=connection;
    //}
   MySqlSessionFactory factory;
    public static Set<Credit> BDCredits(){
         Client client=new Client();
        return new HashSet<Credit>(
                Arrays.asList(
                        new Credit(1L,30000.0,120,2.5,client,0.0)
              //  new Credit(2L,850000.0,240,2.5,"Tarik",0.0),
               // new Credit(3L,020000.0,030,1.5,"Sarah",0.0),
                // new Credit(4L,65000.0,060,2.0,"Tanae",0.0)
                ));
    }

    @Override
    public Credit trouveParId(Long id) throws DaoException {
    //    System.out.println("[DAO - DS volatile] trouver le credit n : "+id);
      //  return BDCredits().stream().filter(credit -> credit.getId()==id).findFirst().orElse(null);
        Credit credit = null;
        Connection session = factory.getSession();
        PreparedStatement ps =null;
        ResultSet rs= null;
        String SQL ="SELECT * FROM credits WHERE id =?";
        try{
            ps= Utilitaire.initPS(session,SQL,false,id);
            rs=ps.executeQuery();
            if(rs.next())credit=map(rs);
            System.out.println("[SQL] :"+SQL);
            return credit;
        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }
        finally {
            Utilitaire.close(ps,rs);
        }
    }

    @Override
    public List<Credit> findAll()  throws DaoException{
      //  return null;

        List<Credit> credits=null;
        Connection session = factory.getSession();
        PreparedStatement ps= null;
        ResultSet rs=null;
        String SQL ="SELECT * FROM credits";
        try{
            ps=Utilitaire.initPS(session,SQL,false);
            rs=ps.executeQuery();
            while(rs.next()) credits.add(map(rs));
            System.out.println("[SQL] :"+SQL);
            return credits;
        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }
        finally {
            Utilitaire.close(ps,rs);
        }
    }

    @Override
    public Credit save(Credit objet) throws DaoException {
        Connection session = factory.getSession();
        PreparedStatement ps= null;
        String SQL="INSERT INTO credits (capital,nbMois,taux,demandeur,mensualite)"+
                "VALUES (?,?,?,?,?)";
        try {
            ps=Utilitaire.initPS(session,SQL,true
                    ,objet.getcapilate_Emprunte(),
                    objet.getnombre_Mois(),
                    objet.getTaux_Mensuel(),
                    objet.getmensualite(),
                    objet.getnom_Demandeur().id,
                    objet.getId());
            var statut = ps.executeUpdate();
            if(statut == 0) throw new DaoException("0 credit inséré !!!");
            else {
                var rs=ps.getGeneratedKeys();
                var id= rs.getLong(1);
                objet.setId(id);
            }
            System.out.println("[SQL] :"+SQL);
            return objet;
        }catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        finally {
            Utilitaire.close(ps);
        }
    }

    @Override
    public Credit update(Credit objet) throws DaoException{
     //   return null;
        Connection session = factory.getSession();
        PreparedStatement ps= null;
        String SQL="UPDATE credits set capital=?,nbMois=?,taux=?,demandeur=?,mensualite=? WHERE id=?";
        try {
            ps=Utilitaire.initPS(session,SQL,true
            ,objet.getcapilate_Emprunte(),
                    objet.getnombre_Mois(),
                    objet.getTaux_Mensuel(),
                    objet.getmensualite(),
                    objet.getnom_Demandeur().id,
                    objet.getId());
            var statut = ps.executeUpdate();
            if(statut == 0) throw new DaoException("0 credit modifié !!!");
            System.out.println("[SQL] :"+SQL);
            return objet;
        }catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        finally {
            Utilitaire.close(ps);
        }
    }

    @Override
    public Boolean delete(Credit objet) throws DaoException{
        Connection session = factory.getSession();
        PreparedStatement ps= null;
        String SQL="DELETE FROM creedits WHERE id=?";
        try{
            ps=Utilitaire.initPS(session,SQL,false,objet.getId());
            var statut=ps.executeUpdate();
            if(statut==0) throw new DaoException("0 credit supprimé!!!");
            System.out.println("[SQL]:"+SQL);
            return true;
        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }
        finally {
            Utilitaire.close(ps);
        }

    }

    @Override
    public Boolean deleteById(Long aLong) throws DaoException {
        return null;
    }
    public Credit map(ResultSet rs) throws DaoException {
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
