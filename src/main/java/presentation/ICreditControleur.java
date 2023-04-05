package presentation;

import dao.exceptions.DaoException;

public interface ICreditControleur {
    void afficher_Menduaalite(Long idCredit) throws Exception, DaoException;
}
