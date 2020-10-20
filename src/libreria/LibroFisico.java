package libreria;

/**
 * Clase que representa un producto de tipo Libro Físico para la gestión de productos en una tienda.
 * 
 * @author Adrian Romero Ramirez
 */
public class LibroFisico extends Libro{
    
    protected int numPaginas; // Número de pagina del libro físico.
    
    public static final int MIN_PAGINAS = 20; // Mínimo de paginas del libro físico
    public static final int MAX_PAGINAS = 5000; // Máximo de paginas del libro físico

    // Metodo getters
    
    /**
     * Devuelve el número de páginas del libro
     * @return número depáginas del libro
     */
    public int getNumPaginas() {
        return numPaginas;
    }
    
    // Constructor de objetos LibrosFisicos

    /**
     * Crea un objeto LibroFisico con un nombre, precio, texto de descripción, autor, año de edición y número de páginas.
     * @param nombre Título del libro
     * @param precio Precio del libro
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param numPaginas Número de páginas del libro
     * @throws IllegalArgumentException  si alguno de los parámetros no es válido
     */
    public LibroFisico(String nombre, double precio, String descripcion, String autor, int year, int numPaginas) throws IllegalArgumentException {
        super(nombre, precio, descripcion, autor, year);
        if (numPaginas>=MIN_PAGINAS && numPaginas<=MAX_PAGINAS){
            this.numPaginas = numPaginas;
        }else{
            throw new IllegalArgumentException("Error: Parámetros de creación del libro físico inválidos. El número de páginas ("+numPaginas+") no está en el rango permitido");
        }
    }
    
    // Sobrecargo los metodos heredados de Libro con la información adicional de LibroFisico
    
    @Override
    public String[] toArrayAtribNames(){
        String[] nombres = new String[6];
        String[] nombresLibro = super.toArrayAtribNames();
        int i;
        for (i=0; i<nombresLibro.length; i++){
            nombres[i] = nombresLibro[i];
        }
        nombres[i] = "numPaginas";
        return nombres;
    }
    
    @Override       
    public String[] toArrayAtribValues(){
        String[] valores = new String[6];
        String[] valoresLibro = super.toArrayAtribValues();
        String yearString = Integer.toString(numPaginas);
        int i;
        for (i=0; i<valoresLibro.length; i++){
            valores[i] = valoresLibro[i];
        }
        valores[i] = yearString;
        return valores;
    }
    
    
    
}
