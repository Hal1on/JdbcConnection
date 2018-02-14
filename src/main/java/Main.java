import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:Database", "hal1on", "somePassword");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE Users(ID INT , NAME VARCHAR(20))");
            statement.execute("INSERT INTO Users VALUES ('0', 'User1')");
            statement.execute("INSERT INTO Users VALUES ('1', 'User2')");
            ResultSet rs = statement.executeQuery("SELECT ID, NAME FROM Users");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                System.out.println("ID: " +  id);
                System.out.println("NAME: " +  name);

            }
            rs.close();
            statement.close();
            connection.close();
            System.out.println(connection.isClosed());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}