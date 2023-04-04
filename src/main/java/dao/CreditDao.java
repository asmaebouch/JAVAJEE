package dao;

import BD.Fabrique.FabriqueMySql;
import org.springframework.stereotype.Component;

import java.sql.Connection;
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
    public Credit trouveParId(Long id) {
        System.out.println("[DAO - DS volatile] trouver le credit n : "+id);
        return BDCredits().stream().filter(credit -> credit.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<Credit> findAll() {
        return null;
    }

    @Override
    public Credit save(Credit objet) {
        return null;
    }

    @Override
    public Credit update(Credit objet) {
        return null;
    }

    @Override
    public Boolean delete(Credit objet) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

}
