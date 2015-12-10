package com.laboratoriodesoftware2015.hermesbucarbala.domain;

/**
 * Created by AGUSTIN.BALA on 06-12-15.
 */
public class Configuration {

    public static final String TABLE_NAME = "CONFIGURATION";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_SERVER = "SERVER";
    public static final String COLUMN_PORT = "PORT";

    private long id;
    private String server;
    private String port;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
