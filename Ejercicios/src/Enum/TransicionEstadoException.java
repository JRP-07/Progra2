package Enum;

public class TransicionEstadoException extends Exception{
    public TransicionEstadoException(EstadoPedido actual, EstadoPedido nuevo){
        super("No se puede pasar de " + actual + " a " + nuevo + " (estado actual final: " + actual.isesFinal() + ") ");
    }
}
