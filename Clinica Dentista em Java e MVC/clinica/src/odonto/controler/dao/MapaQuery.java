/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.controler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MapaQuery <T> {
    void mapping ( ResultSet rs) throws SQLException;
    
        
    
}
