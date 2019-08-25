import java.sql.*;

public class DatabaseApp {

    private static String JDBC_URL = "jdbc:postgresql://localhost:5433/notesdb";
    private static String DATABASE_USER = "postgres";
    private static String DATABASE_PASS = "programator";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(JDBC_URL, DATABASE_USER, DATABASE_PASS);
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM notes");
//        int i = 0;
//        while ((resultSet.next())){
//            i++;
//            System.out.println("Kursor aktualnie jest na " + i + " wierszu.");
//        }

//        while ( (resultSet.next())){
//            int noteId = resultSet.getInt(1);
//            String noteTitle = resultSet.getString("note_title");
//            String noteMsg = resultSet.getString(3);
//            int userId = resultSet.getInt("user_id");
//
//            System.out.println("Id notatki: " +noteId+ ",tytuł: " + noteTitle+ ",treść:" +noteMsg+ ",id użytkownika: " +userId);
//        }

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO notes (note_id, note_title, note_message, user_id) VALUES (?, ?, ?, ?);");

        preparedStatement.setInt(1, 123);
        preparedStatement.setString(2, "aaa");
        preparedStatement.setString(3, "xyz");
        preparedStatement.setInt(4, 2);

        preparedStatement.executeUpdate();


//        boolean resultFlag = statement.execute("INSERT INTO users (user_id, user_nick, user_name) VALUES (100, 'kowal123', 'Jan');");
//        if (!resultFlag){
//            System.out.println("Ilość dodanych rekordów: + " + statement.getUpdateCount());
//        }

//        int resultCount = statement.executeUpdate("CREATE TABLE tests (test_id integer, test_name character varying (256));");



        preparedStatement.close();
        connection.close();
    }


}
