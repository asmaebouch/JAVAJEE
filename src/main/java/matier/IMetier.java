package matier;

import dao.Credit;
import dao.exceptions.DaoException;

public interface IMetier {
    Credit calculer_Mensualite(Long idCreedit)
            throws Exception, DaoException;
}
