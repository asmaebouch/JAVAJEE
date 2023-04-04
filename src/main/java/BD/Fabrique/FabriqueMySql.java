package BD.Fabrique;

import dao.CreditDao;

import java.sql.Connection;

public class FabriqueMySql extends Fabrique {
    private static Connection connection = null;
    private static BD.Singleton INSTANCE = null;
    private FabriqueMySql() {
    }

    @Override
    public CreditDao getClientDAO() {
        return new CreditDao();
    }

    public static FabriqueMySql getinstance() {
        if (INSTANCE == null) {
            //  INSTANCE=new FabriqueMySql() ;
            //   return INSTANCE;
        }
        return null;
    }
}
