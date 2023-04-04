package BD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Singleton {
    private static Connection connection1 = null;
   private static Singleton INSTANCE = null;
    private Singleton(){

try{
    String url,login,pass;
    ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
    var config = classLoader.getResourceAsStream("application.properties");
   if(config==null) throw new IOException("fichier proprties introuvable");

    Properties properties = new Properties();
    properties.load(config);
    url=properties.getProperty("url");
    login=properties.getProperty("login");
    pass=properties.getProperty("pass");
connection1= DriverManager.getConnection(url,login,pass);
    System.out.printf("Connexion etablit avec sucees");
} catch (IOException e) {
    throw new RuntimeException(e);
} catch (SQLException e) {
    throw new RuntimeException(e);
}


    }
    public static Singleton getINSTANCE(){
        if(INSTANCE==null) INSTANCE=new Singleton();
        return INSTANCE;
    }
    public static Connection getSession(){
        if(connection1 == null) INSTANCE = new Singleton();
        return connection1 ;
    }
    public static void closeSession(){
if(connection1 != null)
{
    try{
        connection1.close();
      //  INSTANCE=null;
        System.out.printf("Connexion fermé aavec succes ");

    } catch (SQLException e) {
        System.err.printf("Fermeture de Connexion echoué !! ");
        //throw new RuntimeException(e);
    }
}


    }

}
