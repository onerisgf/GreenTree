package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnectionSqlite() throws SQLException {

        Connection connection; //VARIAVEL DE CONEXÃO
        PreparedStatement stmt; //PREPARA A CONEXÃO COM O BD

        connection = DriverManager.getConnection("jdbc:sqlite:banco.db");   //PASSSO A CONEXÃO COM O DB CRIADO.
        return connection;

    }

}
