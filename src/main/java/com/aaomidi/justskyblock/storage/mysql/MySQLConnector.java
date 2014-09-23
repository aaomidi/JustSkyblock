package com.aaomidi.justskyblock.storage.mysql;

import com.aaomidi.justskyblock.JustSkyblock;
import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author aaomidi
 */
public class MySQLConnector {
    private final JustSkyblock instance;
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String database;
    private final int minPoolSize;
    private final int maxPoolSize;
    private BoneCP boneCP;
    private Connection connection;

    public MySQLConnector(JustSkyblock instance, String host, int port, String username, String password, String database, int minPoolSize, int maxPoolSize) {
        this.instance = instance;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
        this.createBoneCP();
    }

    private void createBoneCP() {
        try {
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl(String.format("jdbc:mysql://%s:%d/%s", this.host, this.port, this.database));
            config.setUsername(this.username);
            config.setPassword(this.password);
            config.setPartitionCount(2);
            config.setMinConnectionsPerPartition(this.minPoolSize);
            config.setMaxConnectionsPerPartition(this.maxPoolSize);
            boneCP = new BoneCP(config);
            this.createConnection();
        } catch (Exception ex) {
            throw new Error("Unrecoverable error when creating the BoneCP object.", ex);
        }
    }

    private void createConnection() {
        try {
            connection = boneCP.getConnection();
        } catch (Exception ex) {
            throw new Error("Unrecoverable error when creating the connection.", ex);
        }
    }

    private boolean isConnected() {
        return (this.connection != null);

    }

    private Connection getConnection() {
        if (isConnected()) {
            return this.connection;
        }
        this.createConnection();
        return this.connection;
    }

    /**
     * Execute a query and expect a ResultSet from the database.
     *
     * @param query      The query.
     * @param parameters The parameters in the query.
     * @return The ResultSet from the database.
     * Note: If connection is not active and the plugin cannot reconnect, the plugin will throw an unrecoverable error.
     */
    public ResultSet executeQuery(String query, Object... parameters) {
        int parameterCount = (parameters == null) ? 0 : parameters.length;
        if (StringUtils.countMatches(query, "?") != parameterCount) {
            this.instance.getLogger().warning("Error whilst preparing SQL query: Incorrect number of parameters!");
            return null;
        }
        Connection connection = this.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            Object parameter;
            for (int i = 0, j = 1; i < parameterCount; i++, j++) {
                parameter = parameters[i];
                if (parameter instanceof String) {
                    statement.setString(j, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(j, (Integer) parameter);
                } else if (parameter instanceof Double) {
                    statement.setDouble(j, (Double) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(j, (Float) parameter);
                } else if (parameter instanceof Boolean) {
                    statement.setBoolean(j, (Boolean) parameter);
                } else {
                    statement.setObject(j, parameter);
                }
            }
            return statement.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException("Problem when executing query.", ex);
        }
    }

    /**
     * Executes a query and do not expect a result.
     *
     * @param query      The query.
     * @param parameters The parameters in the query.
     * @return status of the query.
     * Note: If connection is not active and the plugin cannot reconnect, the plugin will throw an unrecoverable error.
     */
    public int executeUpdate(String query, Object... parameters) {
        int parameterCount = (parameters == null) ? 0 : parameters.length;
        if (StringUtils.countMatches(query, "?") != parameterCount) {
            this.instance.getLogger().warning("Error whilst preparing SQL query: Incorrect number of parameters!");
            return -1;
        }
        Connection connection = this.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            Object parameter;
            for (int i = 0, j = 1; i < parameterCount; i++, j++) {
                parameter = parameters[i];
                if (parameter instanceof String) {
                    statement.setString(j, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(j, (Integer) parameter);
                } else if (parameter instanceof Double) {
                    statement.setDouble(j, (Double) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(j, (Float) parameter);
                } else if (parameter instanceof Boolean) {
                    statement.setBoolean(j, (Boolean) parameter);
                } else {
                    statement.setObject(j, parameter);
                }
            }
            return statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Problem when executing update!", ex);
        }
    }

    /**
     * Simply gracefully disconnect from the MySQL database.
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
