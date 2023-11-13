package coffeshoppp.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private final String usuario;
    private final String pass;
    private final String url;
    private Connection cn;
    private Statement st;
    
    public Connection getConnection() {
        return cn;
    }

    // Constructor to initialize connection parameters
    public Conexion(String usuario, String pass, String url) {
        this.usuario = usuario;
        this.pass = pass;
        this.url = url;
    }

    // Method to establish a database connection
    public void conectar() {
        try {
            cn = DriverManager.getConnection(url, usuario, pass);
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Method to close the database connection
    public void desconectar() {
        try {
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Getter for Statement, allowing external classes to get the Statement
    public Statement getStatement() {
        return st;
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}