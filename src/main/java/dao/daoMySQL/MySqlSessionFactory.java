package dao.daoMySQL;

import dao.*;
import dao.exceptions.DaoConfigException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlSessionFactory extends DaoFactory {
    private static MySqlSessionFactory INSTANCE = null;
    private static Connection session = null;
    private static IDao<Client, Long> CLIENT_DAO = null;
    private static IDao<Credit, Long> CREDIT_DAO = null;
    private static IDao<Utilisateur, Long> USER_DAO = null;
    private MySqlSessionFactory() throws DaoConfigException, Exception {

    try {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        var config = cl.getResourceAsStream("application.properties");
        if(config == null) throw new IOException("fichier introuvable");
        Properties propertiesFile =  new Properties();
        propertiesFile.load(config);
        var url = propertiesFile.getProperty("URL");
        var lg = propertiesFile.getProperty("USERNAME");
        var pass = propertiesFile.getProperty("PASSWORD");
        session = DriverManager.getConnection(url,lg,pass);
        System.out.println("cnx avec success");

        var creditDao = propertiesFile.getProperty("CREDITDAO");
        var clientDao = propertiesFile.getProperty("CLIENTDAO");
        var utilisateurDao = propertiesFile.getProperty("USERDAO");

        Class cCreditDao = Class.forName(creditDao);
        Class cClientDao = Class.forName(clientDao);
        Class cUserDao = Class.forName(utilisateurDao);

        CREDIT_DAO = (IDao<Credit, Long>) cCreditDao.getDeclaredConstructor().newInstance();
        CLIENT_DAO = (IDao<Client, Long>) cClientDao.getDeclaredConstructor().newInstance();
        USER_DAO = (IDao<Utilisateur, Long>) cUserDao.getDeclaredConstructor().newInstance();

        Method
                setFactory = cCreditDao.getMethod("serFactory", DaoFactory.class);
        setFactory.invoke(CREDIT_DAO, this);
        setFactory = cClientDao.getMethod("setFactory", DaoFactory.class);
        setFactory.invoke(CLIENT_DAO,this);
        setFactory = cUserDao.getMethod("setFactory",DaoFactory.class);
        setFactory.invoke(USER_DAO,this);



    }catch (Exception e)
    {
        //throw new DaoConfigException(e.getMessage());
        throw new Exception(e.getMessage());
    }

}
public static MySqlSessionFactory getINSTANCE(){

    if(INSTANCE == null){
        try {
            INSTANCE=new MySqlSessionFactory();}catch (DaoConfigException | Exception e){
            e.printStackTrace();
        }
    }
    return INSTANCE;
}
public Connection getSession(){
        if (session!=null) getINSTANCE();
        return session;
}
public void  closeSession(){

    if(session!=null){
        try {
            session.close();
            System.out.println("Fermeture de session avec succès");
        }catch (SQLException e ){
            System.out.println("Femeture dee session échoué");
        }
    }
}
    @Override
    public IDao<Utilisateur, Long> getUtilisateurDao() {
        if(USER_DAO==null) getINSTANCE();
        return USER_DAO;
    }

    @Override
    public IDao<Client, Long> getClientDao() {
       if(CLIENT_DAO==null) getINSTANCE();
       return CLIENT_DAO;
    }

    @Override
    public IDao<Credit, Long> getCredits() {
       if (CREDIT_DAO==null) getINSTANCE();
       return CREDIT_DAO;
    }
}
