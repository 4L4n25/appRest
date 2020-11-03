package apprest

class Precio {
    def Producto producto1
    static belongsTo = [Producto]
    int numeroPrecio
    double precio

    static constraints = {
        numeroPrecio = 0
        precio = 0.0
    }
}
