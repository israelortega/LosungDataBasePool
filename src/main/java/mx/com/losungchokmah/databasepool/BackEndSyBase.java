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

import com.google.common.base.Preconditions;
import java.util.Properties;

/**
 * Interface para conectarse a base de datos SyBase
 * @version 1.0.0
 * @author LosungChokmah
 * 
 */
public class BackEndSyBase extends AbstractBackEnd {

    protected ConfigSyBase config;
    
    public BackEndSyBase(ConfigSyBase config) {
        super(config);
        this.config = config;
        
        // Debemos tener el nombre de la aplicación de acuerdo a Sybase
        Preconditions.checkNotNull(
                config.getApplicationName(), 
                "Establezca el Nombre de la aplicación antes de continuar");
    }
    
    public Properties getProperties(){
        Properties properties = new Properties();
        properties.setProperty("dataSource.databaseName", this.config.getDbHost());
        properties.setProperty("dataSourceClassName", this.config.getDataSourceClassName());
        properties.setProperty("dataSource.user", this.config.getUsername());
        properties.setProperty("dataSource.password", this.config.getPassword());
        properties.setProperty("dataSource.portNumber", String.valueOf(this.config.getDbPort()));
        properties.setProperty("dataSource.serverName", String.valueOf(this.config.getDbHost()));
        properties.setProperty("dataSource.ApplicationName", this.config.getApplicationName());
        return properties;
    }
    
}

