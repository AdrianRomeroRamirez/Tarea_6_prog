package libreria;

/**
 * Clase que representa un producto de tipo EReader para la gestión de productos en una tienda.
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la información 
 * relativa a un producto de tipo EReader (lector de libros electrónicos) en una tienda. 
 * Además de los atributos propios de un producto, deberá contener los específicos 
 * de un EReader, que son:
 * -Fabricante del EReader (Amazon, BQ, Sony, Onyx, ICARUS, etc.).
 * @author Adrian Romero Ramirez
 */
public class EReader extends Producto{
    
    protected String fabricante; // Nombre del fabricante

    /**
     * Devuelve el nombre del fabricante del dispositivo
     * @return descripción del producto
     */
    public String getFabricante() {
        return fabricante;
    }

    // Constructor de objetos EReader
    
    /**
     * Crea un objeto ERreader con un nombre, precio, texto de descripción y fabricante.
     * @param nombre Nombre del dispostivo
     * @param precio Precio del dispostivo
     * @param descripcion Descripción del dispostivo
     * @param fabricante fabricante del dispostivo
     * @throws IllegalArgumentException  si alguno de los parámetros no es válido
     */
    public EReader(String nombre, double precio, String descripcion, String fabricante) throws IllegalArgumentException {
        super(nombre, precio, descripcion);
        this.fabricante = fabricante;
    }
    
     // Sobrecargo los metodos heredados de Producto con la información adicional de EReader
    
    @Override
    public String[] toArrayAtribNames(){
        String[] nombres = new String[4];
        String[] nombresProducto = super.toArrayAtribNames();
        int i;
        for (i=0; i<nombresProducto.length; i++){
            nombres[i] = nombresProducto[i];
        }
        nombres[i] = "fabricante";
        return nombres;
    } 
    
    @Override       
    public String[] toArrayAtribValues(){
        String[] valores = new String[4];
        String[] valoresProducto = super.toArrayAtribValues();
        int i;
        for (i=0; i<valoresProducto.length; i++){
            valores[i] = valoresProducto[i];
        }
        valores[i] = fabricante;
        return valores;
    }
    
}
