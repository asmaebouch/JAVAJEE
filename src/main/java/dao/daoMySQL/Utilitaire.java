package dao.daoMySQL;

import java.sql.*;

public class Utilitaire {
    public static PreparedStatement initPS(Connection CNX,String SQL,
                                           boolean generateKey,
                                           Object... Columns)throws SQLException{
        PreparedStatement PS=null;
        PS =CNX.prepareStatement(SQL,generateKey ? Statement.RETURN_GENERATED_KEYS:Statement.NO_GENERATED_KEYS);
        for (int i=0;i<Columns.length;i++)
            PS.setObject(i+1,Columns[i]);
        return PS;
    }
    public static void close(PreparedStatement ps){
        if(ps!=null){
            try{
                ps.close();
                System.out.println("Fermeture de l'objet stateement avec succès");
            }catch (SQLException e){
                System.err.println("Fermeture dee statement échoué");
            }
        }
    }
    public static void closee(ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
                System.out.println("Fermeture de l'objet resultSet avec succès");
            }catch (SQLException e){
                System.err.println("Fermeture de resultSet échoué");
            }
        }
    }
    public static void close(PreparedStatement ps,ResultSet rs){close(ps);
        close((PreparedStatement) rs);}


}
