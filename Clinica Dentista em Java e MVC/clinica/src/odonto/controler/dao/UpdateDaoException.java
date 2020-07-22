/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.controler.dao;

public class UpdateDaoException extends RuntimeException{

    public UpdateDaoException() {
    }

    public UpdateDaoException(String message) {
        super(message );
    }

    public UpdateDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateDaoException(Throwable cause) {
        super(cause);
    }
    
}
