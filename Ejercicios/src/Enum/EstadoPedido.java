package Enum;

import java.security.DrbgParameters.Capability;

public enum EstadoPedido {
    PENDIENTE("Pedido registrado, esperando procesamiento", false, 1),
    PROCESANDO("Pedido siendo preparado", false, 2),
    ENVIADO("Pedido camino al cliente", false, 3),
    ENTREGADO("Pedido entregado", true, 0),
    CANCELADO("Pedido cancelado", true, 0);

    private final String descripcion;
    private final boolean esFinal; // si permite cambios
    private final int diasEstimados; // tiempo que dura el estado

    EstadoPedido(String descripcion, boolean esFinal, int dias) {
        this.descripcion = descripcion;
        this.esFinal = esFinal;
        this.diasEstimados = dias;
    }

    public boolean isesFinal(){
        return esFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean transicionarA(EstadoPedido nuevoEstado) {
        if (this.esFinal) {
            return false;
        }
        
        boolean valido = false;

        switch (this) {
            case PENDIENTE:
                if (nuevoEstado == PROCESANDO || nuevoEstado == CANCELADO) {
                    valido = true;
                }
                break;
            case PROCESANDO:
                if (nuevoEstado == ENVIADO || nuevoEstado == CANCELADO) {
                    valido = true;
                }
                break;
            case ENVIADO:
                if (nuevoEstado == ENTREGADO) {
                    valido = true;
                }
                break;
            default:
                valido = false;
                break;
        }
        return valido;
    }
}
