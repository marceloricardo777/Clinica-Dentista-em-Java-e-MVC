/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.controler.dao;


public class ExceptionCreateDados extends RuntimeException {

    public ExceptionCreateDados() {
    super();
    }

    public ExceptionCreateDados(String message) {
        super(message);
    }

    public ExceptionCreateDados(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionCreateDados(Throwable cause) {
        super(cause);
    }
    
}
