package dao.filesRepository;

import dao.daoMySQL.MySqlSessionFactory;
import dao.exceptions.DaoConfigException;

public class FileFactory {
    private static MySqlSessionFactory INSTANCE = null;
    public static MySqlSessionFactory getINSTANCE(){

        if(INSTANCE == null){
            try {
                INSTANCE=new MySqlSessionFactory();}catch (DaoConfigException | Exception e){
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }
}
