package dao;

import java.util.List;

public interface IDao<T,ID> {
    T trouveParId(ID id);
    List<T> findAll();
    T save (T objet);
    T update(T objet);
    Boolean delete(T objet);
    Boolean deleteById(ID id);

}
//interface ICredits extends IDao<dao.Credit,Long>{
 //   List
//}
