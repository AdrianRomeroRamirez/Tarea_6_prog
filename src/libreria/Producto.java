package libreria;

/**
 * Clase abastracta que representa un producto genérico para una tienda online.
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar la mínima 
 * información necesaria de un producto para ser comercializado en la tienda:
 * -Nombre del producto.
 * -Precio del producto (valor real en el rango 0.01-10000.00 euros).
 * -Descripción del producto.
 * @author Adrian Romero Ramirez
 */
public abstract class Producto implements Arrayable {
    
    // Declaro los atributos minimos que tendran todos los productos
    
    protected String nombre; // Nombre del producto
    protected double precio; // Precio del producto
    protected String descripcion; // Descripción del producto
    
    public static final double MIN_PRECIO = 0.01; // Precio mínimo del producto
    public static final double MAX_PRECIO = 10000; // Precio máximo del producto

    // Costructor del objeto Producto
    
    /**
     * Crea un objeto Producto con un nombre, un precio y un texto de descripción.
     * @param nombre Nombre del producto
     * @param precio Precio del priducto
     * @param descripcion Descripción del producto
     * @throws IllegalArgumentException Si alguno de los parámetros no es valido
     */
    public Producto(String nombre, double precio, String descripcion) throws  IllegalArgumentException {
        if (precio>=MIN_PRECIO && precio<=MAX_PRECIO){
            this.nombre = nombre;
            this.precio = precio;
            this.descripcion = descripcion;
        }else{
            throw new  IllegalArgumentException("Error: Parámetros de creación del producto inválidos. El precio ("+precio+") no está en el rango permitido.");
        }
    }
    
    // Métodos getters

    /**
     * Devuelve el nombre del producto
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio actual del producto
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve la descripción del producto
     * @return Descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    // Sobrecargo los metodos de la interfaz Arrayable con la información de Producto
    
    @Override
    public String[] toArrayAtribNames(){
        String[] nombres = new String[3];
        nombres[0] = "nombre";
        nombres[1] = "descripcion";
        nombres[2] = "precio";
        return nombres;
    }
    @Override       
    public String[] toArrayAtribValues(){
        String[] valores = new String[3];
        String precioString = Double.toString(precio);
        valores[0] = nombre ;
        valores[1] = descripcion;
        valores[2] = precioString;
        return valores;
    }
    
    
    
}
