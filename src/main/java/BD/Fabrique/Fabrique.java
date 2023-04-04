package BD.Fabrique;

import dao.CreditDao;

public abstract class Fabrique {
    public static final int FABRIQUE_BDMYSQL=1;
    public static final int FABRIQUE_BDFICHIERS=2;
    public static final int FABRIQUE_BDVOLATILE=3;
    public static Fabrique getFabrique(int type){
        if(type == 1) return FabriqueMySql.getinstance();
        else if (type ==2) return new Fabriquefichiers();
        else if (type == 3) return new FabriqueVolatile();

        return null;
    }
    public abstract CreditDao getClientDAO();
}
