package prueba

class DatosUsuario {

    int numTel
    String nombre
    int edad
    static constraints = {
        numTel
        nombre[40]
        edad
    }
}
