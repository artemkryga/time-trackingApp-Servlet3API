package ua.kryha.timetrack.db;


import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;

public class ConnectionPool {

    private static PGPoolingDataSource instance;

    private ConnectionPool() {

    }

    public static DataSource getInstance() {
        if(instance == null) {
            synchronized(ConnectionPool.class) {
                if(instance == null) {
                    instance = new PGPoolingDataSource();
                    instance.setDataSourceName("A Data Source");
                    instance.setServerName("databaseforlearn.caviatwn83le.eu-central-1.rds.amazonaws.com:5432");
                    instance.setDatabaseName("postgres");
                    instance.setUser("postgres");
                    instance.setPassword("19061972");
                    instance.setInitialConnections(1);
                    instance.setMaxConnections(25);
                }
            }
        }

        return instance;
    }



}