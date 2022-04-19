package DataAccess.Concrete;

import DataAccess.Abstract.IVeritabaniRepository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class PostreSqlSunucu implements IVeritabaniRepository {


    private Connection baglan(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/veritabani",
                    "postgres", "123");

            System.out.println("Veritabanına bağlandı!");

        } catch (Exception e) {
            System.out.println("Bağlantı girişimi başarısız!");
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public boolean kullaniciAdiDogrula(String kullaniciAdi) {
        Connection conn=this.baglan();
        try {
            CallableStatement stmt = conn.prepareCall("{?= call kullaniciadidogrula(?)}");
            stmt.setString(2,kullaniciAdi);
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.execute();
            conn.close();
            if(stmt.getInt(1)==1)
                return true;

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean kullaniciDogrula(String kullaniciAdi, String sifre) {
        Connection conn=this.baglan();
        try {
            CallableStatement stmt = conn.prepareCall("{?= call kullanicidogrula(?,?)}");
            stmt.setString(2,kullaniciAdi);
            stmt.setString(3,sifre);
            stmt.registerOutParameter(1,Types.INTEGER);
            stmt.execute();
            conn.close();
            if(stmt.getInt(1)==1)
                return true;

            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
