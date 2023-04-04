package BD.Fabrique;

import dao.CreditDao;

public class FabriqueVolatile extends Fabrique{
    @Override
    public CreditDao getClientDAO() {
        return null;
    }
}
