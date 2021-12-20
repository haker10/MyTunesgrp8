package dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class daoConnecter {
        public class DatabaseConnector {
                private SQLServerDataSource dataSource;

                public DatabaseConnector() {
                        dataSource = new SQLServerDataSource();
                        dataSource.setDatabaseName("myTunesTeam8");
                        dataSource.setUser("CSe21B_3");
                        dataSource.setPassword("CSe21B_3");
                        dataSource.setPortNumber(1433);
                        dataSource.setServerName("10.176.111.31");
                }
                public Connection getConnection() throws SQLServerException, SQLServerException {
                        return dataSource.getConnection();
                }
        }
        // This is for connect to the sqlserver
}
