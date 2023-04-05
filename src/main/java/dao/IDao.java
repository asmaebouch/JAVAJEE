package dao;

import dao.exceptions.DaoException;

import java.util.List;

public interface IDao<T,ID> {
    T trouveParId(ID id) throws DaoException;
    List<T> findAll() throws DaoException;
    T save (T objet) throws DaoException;
    T update(T objet) throws DaoException;
    Boolean delete(T objet) throws DaoException;
    Boolean deleteById(ID id) throws DaoException;

}
//interface ICredits extends IDao<dao.Credit,Long>{
 //   List
//}
