package Enum;

public abstract class Pedido {
    protected final int id;
    protected final String cliente;
    protected final double monto;
    protected EstadoPedido estado;

    Pedido(int id, String cliente, double monto){
        this.id=id;
        this.cliente=cliente;
        this.monto=monto;
        this.estado=EstadoPedido.PENDIENTE;

    }
    
    public int getId(){
        return id;
    }

    public double getMonto(){
        return monto;
    }

    public EstadoPedido getEstado(){
        return estado;
    }

    public void setEstado(){
        this.estado=estado;
    }

    public abstract double calcularCostoEnvio();
    public abstract String getTipo();

    @Override
    public String toString(){
        return "Pedido#"+id+"["+getTipo()+", "+cliente+", $"+monto+", envio: $"+calcularCostoEnvio()
        +", "+estado+" - "+estado.getDescripcion()+"]";    }
}
