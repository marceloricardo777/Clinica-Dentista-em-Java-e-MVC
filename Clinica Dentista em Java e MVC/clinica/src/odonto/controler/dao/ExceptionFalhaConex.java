/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.controler.dao;

public class ExceptionFalhaConex extends RuntimeException{

    public ExceptionFalhaConex() {
    }

    public ExceptionFalhaConex(String message) {
        super(message );
    }

    public ExceptionFalhaConex(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionFalhaConex(Throwable cause) {
        super(cause);
    }
    
}
