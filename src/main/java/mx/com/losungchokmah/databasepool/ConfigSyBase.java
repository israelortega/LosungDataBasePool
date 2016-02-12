/**
 * This file is part of Losung-Chokmah DataBasePool (http://www.losungchokmah.com.mx)
 * 
 *     Losung-Chokmah DataBasePool is free software: you can redistribute it and/or modify 
 *     it under the terms of the GNU Affero General Public License as published by 
 *     the Free Software Foundation, either version 3 of the License, or 
 *     (at your option) any later version. 
 * 
 *     Losung-Chokmah DataBasePool in the hope that it will be useful, 
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of 
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 *     GNU Affero General Public License for more details. 
 * 
 *     You should have received a copy of the GNU Affero General Public License 
 *     along with Losung-Chokmah DataBasePool. If not, see <http://www.gnu.org/licenses/>. 
 * 
 *     Copyright (c) 2016, Losung-Chokmah
 *
 */

package mx.com.losungchokmah.databasepool;
import java.io.InputStream;
import java.util.Properties;

/*
 * Clase con requerimientos de conexión SyBase
 *
 * @version 1.0.0
 * @author LosungChokmah
 */
public class ConfigSyBase implements BackEndConfiguration, SyBaseConfiguration {

    /**
     * Mínimo numero de conexiones a la base de datos
     */
    public static final int MIN_READ_CONNECTIONS_DATABASE = 2;
    /**
     * Tiempo de máxico de conexión
     */
    private static final long POOL_CONNECTION_TIMEOUT = 30L * 1000;

    /**
     * Tamaño de pool
     */
    private int connectionPoolSize = 5;

    /**
     * Usuario de la base de datos
     */
    private String username;

    /**
     * password de la base de datos
     */
    private String password;

    /**
     * Dirección de la base de datos
     */
    private String dbHost;

    /**
     * Nombre de la base de datos
     */
    private String dbName;

    /**
     * Puerto de la base de datos
     */
    private int dbPort;

    /**
     * Nombre de la aplciacion: sólo para SyBase
     */
    private String applicationName;
    
    
    private String dataSourceClassName;
    
    /**
     * Constructor de la clase
     * @param archivoProperties
     * @throws Exception 
     */

    public ConfigSyBase(String archivoProperties) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("SyBase.properties");
        Properties properties = new Properties();

        try {
            properties.load(input);
        } catch (Exception ex) {
            properties = null;
            throw new Exception("Error, no se pudieron teer las propiedades");
        }
        
        this.setApplicationName(properties.getProperty("dataSource.ApplicationName"));
        this.setDbName(properties.getProperty("dataSource.databaseName"));
        this.setDbHost(properties.getProperty("dataSource.serverName"));
        
        try {
            this.setDbPort(Integer.parseInt(properties.getProperty("dataSource.portNumber")));
        } catch (Exception e) {
            properties = null;
            throw new Exception("El puerto debe ser numérico");
        }
        
        this.setPassword(properties.getProperty("dataSource.password"));
        this.setUsername(properties.getProperty("dataSource.user"));
        this.setDataSourceClassName(properties.getProperty("dataSourceClassName"));
        
        try {
            this.setConnectionPoolSize(Integer.parseInt(properties.getProperty("dataSource.ConnectionPoolSize")));
        } catch (Exception e) {
            properties = null;
            throw new Exception("El numero de pools de conexión debe ser numérico");
        }
        
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public int getDbPort() {
        return dbPort;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public int getConnectionPoolSize() {
        return this.connectionPoolSize;
    }
    
    public void setDataSourceClassName(String dataSourceClassName) {
        this.dataSourceClassName = dataSourceClassName;
    }

    @Override
    public String getDataSourceClassName() {
        return dataSourceClassName;
    }

}
