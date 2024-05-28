package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

    private static Connection connection = null;

    private static final String DB_NAME = "database.sql";
    private static final String DB_DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:" + DB_NAME;

    public static boolean loadDriver() {
        try {
            Class.forName(DB_DRIVER);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean connect() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isConnected() {
        return connection != null;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static ResultSet getTablaVehiculos() {
        try {
            return connection.createStatement().executeQuery("SELECT * FROM Vehiculos");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void printTablaVehiculos() {
        ResultSet rs = getTablaVehiculos();
        try {
            while (rs.next()) {
                System.out.println(rs.getString("matricula") + " " + rs.getString("marca") + " " + rs.getString("modelo"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getVehiculo(int ID) {
        try {
            return connection.createStatement().executeQuery("SELECT * FROM Vehiculos WHERE ID = " + ID);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getVehiculo(String matricula) {
        try {
            return connection.createStatement().executeQuery("SELECT * FROM Vehiculos WHERE matricula = '" + matricula + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean existVehiculo(int ID) {
        ResultSet rs = getVehiculo(ID);
        try {
            if (!rs.first()) {
                rs.close();
                return false;
            }
            rs.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean existVehiculo(String matricula) {
        ResultSet rs = getVehiculo(matricula);
        try {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void printVehiculo(int ID) {
        ResultSet rs = getVehiculo(String.valueOf(ID));
        try {
            if (rs.next()) {
                System.out.println(rs.getString("matricula") + " " + rs.getString("marca") + " " + rs.getString("modelo"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printVehiculo(String matricula) {
        ResultSet rs = getVehiculo(matricula);
        try {
            if (rs.next()) {
                System.out.println(rs.getString("matricula") + " " + rs.getString("marca") + " " +
                        rs.getString("modelo"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean insertVehiculo(Vehiculo vehiculo) {
        try {
            return connection.createStatement().execute("INSERT INTO Vehiculos (matricula, marca, modelo, peso)" +
                    "VALUES ('" + vehiculo.getMatricula() + "', '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() +
                    "', " + vehiculo.getPeso() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateVehicle(int id, Vehiculo vehiculo) {
        try {
            boolean execute = connection.createStatement().execute("UPDATE Vehiculos SET matricula = '" + vehiculo.getMatricula() +
                    "', marca = '" + vehiculo.getMarca() + "', modelo = '" + vehiculo.getModelo() + "', peso = " +
                    vehiculo.getPeso() + " WHERE ID = " + id);
            return execute;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteVehiculo(int id) {
        try {
            return connection.createStatement().execute("DELETE FROM Vehiculos WHERE ID = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteVehiculo(String matricula) {
        try {
            DBManager.connect();
            return connection.createStatement().execute("DELETE FROM Vehiculos WHERE matricula = '" + matricula + "'");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}