package libreria;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un producto de tipo Libro para la gestión de productos en una tienda.
 * 
 * Los objetos de esta clase contienen atributos que permiten almacenar la información 
 * relativa a un producto de tipo Libro en una tienda. Además de los atributos propios 
 * de un producto, deberá contener los específicos de un libro, que son:
 * -Autor del libro.
 * -Año de edición del libro.
 * 
 * Se trata de una clase abastracta que contiene la información mínima sobre el libro pero 
 * no contiene información que depende de su formato físico (si se trata de un libro en papel 
 * o un libro electrónico). Para eso existen otras clases especializadas que heredarán de ésta.
 * @author Adrian Romero Ramirez
 */
public abstract class Libro extends Producto {
    
    protected String autor; // Autor del libro
    protected int year; // Año de publicación del libro
    
    public static final int MIN_YEAR = 1500; // Año mínimo de publicación del libro
    
    // Constructor del objeto Libro    

    /**
     * Crea un objeto Libro con un nombre, precio, un texto de descripción y autor.
     * @param nombre Título del libro
     * @param precio Precio del libro
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @throws IllegalArgumentException si alguno de los parámetros no es válido
     */
    public Libro(String nombre, double precio, String descripcion, String autor, int year) throws IllegalArgumentException {
        super(nombre, precio, descripcion);
        if(year>=MIN_YEAR && year<=LocalDate.now().getYear()){
            this.autor = autor;
            this.year = year;
        }else{
            throw new IllegalArgumentException ("Error: Parámetros de creación del libro inválidos. El año de edición ("+year+") no está en el rango permitido");
        }
    }
    
    // Métodos getters

    /**
     * Devuelve el nombre del autor del libro
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devuelve el año de publicación del libro
     * @return año de publicación
     */
    public int getYear() {
        return year;
    }
    
    // Sobrecargo los metodos heredados de Producto con la información adicional de Libro
    
    @Override
    public String[] toArrayAtribNames(){
        String[] nombres = new String[5];
        String[] nombresProducto = super.toArrayAtribNames();
        int i;
        for (i=0; i<nombresProducto.length; i++){
            nombres[i] = nombresProducto[i];
        }
        nombres[i] = "autor";
        nombres[i+1] = "year";
        return nombres;
    }
    
    @Override       
    public String[] toArrayAtribValues(){
        String[] valores = new String[5];
        String[] valoresProductos = super.toArrayAtribValues();
        String yearString = Integer.toString(year);
        int i;
        for (i=0; i<valoresProductos.length; i++){
            valores[i] = valoresProductos[i];
        }
        valores[i] = autor;
        valores[i+1] = yearString;
        return valores;
    }
    
}
