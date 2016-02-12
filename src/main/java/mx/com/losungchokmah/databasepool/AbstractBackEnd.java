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

/**
 * Clase abstracta para el control del Pool de conexiones
 * Abstract Class for connection pool control
 *
 * @version 1.0.0
 * @author LosungChokmah
 * 
 */
public abstract class AbstractBackEnd {

    /**
     * Controla la clase en forma estática
     */
    static private AbstractBackEnd adbBackEnd = null;

    /**
     * Mínimo numero de conexiones a la base de datos
     */
    public static final int MIN_READ_CONNECTIONS_DATABASE = 1;
    /**
     * Tiempo de máxico de conexión
     */
    private static final long POOL_CONNECTION_TIMEOUT = 30L * 1000;
    
   
    
    public AbstractBackEnd(BackEndConfiguration config) {
        int connectionPoolSize = config.getConnectionPoolSize();

        Preconditions.checkState(
                connectionPoolSize >= MIN_READ_CONNECTIONS_DATABASE,
                "Se requiere al menos " + MIN_READ_CONNECTIONS_DATABASE + " conexion(es)"
        );
                
        Preconditions.checkState(
                config.getDbPort() > 0 && config.getDbPort() < 65535, 
                "Se requiere un número de puerto válido" 
        );
        
        Preconditions.checkNotNull(
                config.getDbName(),
                "Se requiere establecer el nombre de la base de datos");
        
        Preconditions.checkNotNull(
                config.getDbHost(),
                "Se requiere establecer la ubicación de la base de datos");
        
        Preconditions.checkNotNull(
                config.getDataSourceClassName(),
                "Se requiere establecer la clase del origen de datos");

    }

}

