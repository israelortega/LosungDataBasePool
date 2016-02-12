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

/*
 * Interface con requerimientos adicionales MySql
 * @version 1.0.0
 * @author LosungChokmah
 */
public interface MySqlConfiguration {

    /**
     * Atributos, sólo para MySQL, en nombre dela aplciación debe ser
     * program_name:NOMBRE_APLICACION
     */
    public String getConnectionAttributes();

}
