package ru.rrozhkov.easykin.db.impl;

import org.hsqldb.server.Server;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class HSQLDBServer extends Thread {
    Server hsqlServer = null;

    public HSQLDBServer(String dbName, String dbPath) {
        this.hsqlServer = new Server();
        this.hsqlServer.setLogWriter(null);
        this.hsqlServer.setSilent(true);
        this.hsqlServer.setDatabaseName(0, dbName);
        this.hsqlServer.setDatabasePath(0, dbPath);
    }

    @Override
    public void start() {
        this.hsqlServer.start();
    }

    public void shutdown() {
        this.hsqlServer.stop();
    }
}
