package BD;

import dao.Client;
import dao.Credit;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class TestJDBC {
    // static List<Credit> map = new ArrayList<>() ;

    /* public static ArrayList map(ResultSet resultSet) throws SQLException{
         Connection connection = null;
         PreparedStatement ps=null;
         ResultSet rs = null;
         ArrayList credits = new ArrayList<dao.Credit>();
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             //  ps = connection.prepareStatement("select * from credits where id = ? and capitl = ?");
             ps = connection.prepareStatement("select * from credits");
             //  ps.setLong(1,3L);//Joker num 1
             // ps.setDouble(2,30000);
             rs=ps.executeQuery();
             while (rs.next()){
                 var id = rs.getLong("id");
                 var cp = rs.getDouble("capital");
                 var nbrM= rs.getInt("nbrMois");
                 var taux = rs.getDouble("taux");
                 var demandeur = rs.getString("demandeur");
                 var mensulite = rs.getDouble("mensualite");
                 dao.Credit credit=new dao.Credit(id,cp,nbrM,taux,demandeur,mensulite);
                 credits.add(credit);
             }
             credits.forEach(System.out::println);
             //siree 9ra maven
         } catch (ClassNotFoundException e) {
             //    throw new RuntimeException(e);
             System.out.println("Le driver du MySQL est introuvble" );
         } catch (SQLException e) {
             //throw new RuntimeException(e);
             System.out.println("Connexion échouée");
         }
         return credits;
     }
     static void findByID(Long idCredit){
         Connection connection1 = null;
         PreparedStatement besoin = null;
         ResultSet resultSet= null;
         try{
         String url,login,pass;
         ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
         var config = classLoader.getResourceAsStream("config.properties");
         Properties properties = new Properties();
         properties.load(config);
         url=properties.getProperty("url");
         login=properties.getProperty("login");
         pass=properties.getProperty("pass");
         connection1= DriverManager.getConnection(url,login,pass);
         System.out.printf("Connexion etablit avec sucees");
         besoin = connection1.prepareStatement("SELECT * FROM  credits");
         besoin.setLong(1,idCredit);
         resultSet=besoin.executeQuery();
         var cresits = map(resultSet);
     } catch (
     IOException e) {
         throw new RuntimeException(e);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }




     }*/
    public static void main(String[] args) {

        //   findByID(1L);
        //static List<Credit> map
     /*   var url = "jdbc:mysql://localhost:3306/bankati";
        var login = "bankUser";
        var pss = "banker";

        var driver = " com .mysql.cj.jdbc.Driver";
        Connection connection = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        ArrayList credits = new ArrayList<dao.Credit>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Chargemeent du driver JDBC pour MSQL reussi ^_^");
            connection = DriverManager.getConnection(url, login, pss);
            System.out.println("Connexion à la BD Bnkati établit avec succees");
            //  ps = connection.prepareStatement("select * from credits where id = ? and capitl = ?");
            ps = connection.prepareStatement("select * from credits");
            //  ps.setLong(1,3L);//Joker num 1
            // ps.setDouble(2,30000);
            rs=ps.executeQuery();
            while (rs.next()){
                var id = rs.getLong("id");
                var cp = rs.getDouble("capital");
                var nbrM= rs.getInt("nbrMois");
                var taux = rs.getDouble("taux");
                var demandeur = rs.getString("demandeur");
                var mensulite = rs.getDouble("mensualite");
                dao.Credit credit=new dao.Credit(id,cp,nbrM,taux,demandeur,mensulite);
                credits.add(credit);
            }
            credits.forEach(System.out::println);
            //siree 9ra maven
        } catch (ClassNotFoundException e) {
            //    throw new RuntimeException(e);
            System.out.println("Le driver du MySQL est introuvble" );
        } catch (SQLException e) {'
            //throw new RuntimeException(e);
            System.out.println("Connexion échouée");
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Connexion fermé avec succes ");
                }
            } catch (SQLException e) {
                //   throw new RuntimeException(e);
                System.out.println("Connexion n'est pas  fermé avec succes ");

            }
            try {
                if(ps != null)
                {
                    ps.close();
                    System.out.println("Connexion fermé avec succes ");
                }
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                System.out.println("Connexion n'a pas pu etre fermé");
            }
            try {
                if(connection != null)
                {
                    connection.close();
                    System.out.println("Connexion fermé avec succes ");
                }
            } catch (SQLException e) {
                // throw new RuntimeException(e);
                System.out.println("Connexion n'a pas pu etre fermé");
            }


        }*/
        Connection connection1 = Singleton.getSession();
      //  PreparedStatement besoin = null;
        //ResultSet resultSet = null;
        var credits = new ArrayList<Credit>();
        try {

          /*  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            var config = classLoader.getResourceAsStream("application.properties");
            if(config == null) throw new IOException("fichier properties introuvable");
            Properties properties = new Properties();
            properties.load(config);
          var  url = properties.getProperty("url");
           var login = properties.getProperty("login");
         var   pass = properties.getProperty("pass");
            connection1 = DriverManager.getConnection(url, login, pass);
            System.out.printf("Connexion etablit avec sucees");


            var statement = connection1.createStatement();
          //  var rs = statement.executeQuery(
                   /* "select cr.id, cr.capital, cr.nbMois, cr.taux, cr.demandeur, cr.mensualite, u.nom, u.prenom " +
                            "FROM credits cr, client cl, utilisateur u " +
                            "WHERE cr.demandeur=cl.id AND cl.id=u.id AND cr.capital='3000'");*/
           var ps = connection1.prepareStatement( " select * FROM credits cr, client cl, utilisateur u WHERE cr.demandeur=cl.id AND cl.id=u.id AND cr.capital=?"
            );
            ps.setDouble(1,3000.0);
            var rs = ps.executeQuery();
                  //  "select * from credits"

 while(rs.next()){
     var id = rs.getLong("id");
     var cp = rs.getDouble("capital");
     var nbrM= rs.getInt("nbMois");
     var taux = rs.getDouble("taux");
     var nomdemandeur = rs.getString("nom");
     var prenomdemandeur= rs.getString("prenom");
     //var demandeur=rs.getInt("demandeur");
     var mensulite = rs.getDouble("mensualite");

var client= new Client();
client.SetNomComplet(nomdemandeur,prenomdemandeur);
credits.add(new Credit(id,cp,nbrM,taux,client,mensulite));

 }
if(credits.isEmpty()) throw new SQLException("Aucun crédit trouvé");
else credits.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
  Singleton.closeSession();
    }
}
