package Enum;

public class GestorPedidos {
    private final Pedido pedidos[];
    private int cantidad;
    
    public GestorPedidos(int size){
        pedidos = new Pedido[size];
        cantidad = 0;
    }

    public void AgregarPedido(Pedido dato) throws CapacidadException{
        
    }
}
