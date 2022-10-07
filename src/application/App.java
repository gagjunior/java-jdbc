package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class App {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                "INSERT INTO seller "
                    +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    +"VALUES "
                    +"(?, ?, ?, ?, ?)");

            st.setString(1, "Gilberto Junior");
            st.setString(2, "fulano@detal.com.br");
            st.setDate(3, new java.sql.Date(sdf.parse("25/06/1987").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! " + rowsAffected + " affected");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        } finally {
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
