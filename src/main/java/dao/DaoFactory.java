package dao;

import dao.daoMySQL.MySqlSessionFactory;
import dao.filesRepository.FileFactory;
import dao.inMemoryRepository.MemFactory;

public abstract class DaoFactory {

    public static final int MYSQL_DATA_UNIT=1,
    FILE_DATA_UNIT=2,
    InMEMORY_DATA_UNIT=3;
    public abstract IDao<Utilisateur,Long> getUtilisateurDao();
    public abstract IDao<Client,Long> getClientDao();
    public abstract IDao<Credit,Long> getCredits();
    public static final DaoFactory getDaoFactory(int factoryType){
        switch (factoryType){
            case 1: return (DaoFactory) MySqlSessionFactory.getINSTANCE();
            case 2 : return FileFactory.getINSTANCE();
            case 3: return MemFactory.getINSTANCE();
            default:return null;

        }
    }

}
