import java.sql.*;

public class DatabaseApp {

    private static String JDBC_URL = "jdbc:postgresql://localhost:5433/notesdb";
    private static String DATABASE_USER = "postgres";
    private static String DATABASE_PASS = "programator";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(JDBC_URL, DATABASE_USER, DATABASE_PASS);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM notes");

//        boolean resultFlag = statement.execute("INSERT INTO users (user_id, user_nick, user_name) VALUES (100, 'kowal123', 'Jan');");
//        if (!resultFlag){
//            System.out.println("Ilość dodanych rekordów: + " + statement.getUpdateCount());
//        }

        int resultCount = statement.executeUpdate("CREATE TABLE tests (test_id integer, test_name character varying (256));");



        statement.close();
        connection.close();
    }


}
