/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.controler.dao;

public class DeleteDaoException extends RuntimeException{

    public DeleteDaoException() {
    }

    public DeleteDaoException(String message) {
        super(message );
    }

    public DeleteDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteDaoException(Throwable cause) {
        super(cause);
    }
    
}
