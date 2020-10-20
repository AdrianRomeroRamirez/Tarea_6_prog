package libreria;

/**
 * Clase que representa un producto de tipo Libro Electrónico para la gestión de productos en una tienda.
 * 
 * @author Adrian Romero Ramirez
 */
public class LibroElectronico extends Libro implements Downloadable{
    
    protected int size; // Tamaño del archivo en Kbytes
    protected int numDescargas; // Número de descargas del libro
    
    public static final int MIN_SIZE = 20; // Mínimo tamaño permitido para el archivo
    public static final int MAX_SIZE = 65535; // Máximo tamaño permitido para el archivo
    
    // Métodos getters

    /**
     * Devuelve el tamaño en Kb del archivo EBook
     * @return Tamaño en Kb del EBook
     */
    public int getSize() {
        return size;
    }

    /**
     * Devuelve el número de descargas del archivo EBook hasta el momento
     * @return número de descargas del archivo EBook hasta el momento
     */
    public int getNumDescargas() {
        return numDescargas;
    }
    
    // Costructor de objetos LibroElectronico

    /**
     * Crea un objeto LibroElectronico con un nombre, precio, texto de descripción, autor, año de edición y tamaño en Kbytes.
     * @param nombre Título del libro
     * @param precio Precio del libro
     * @param descripcion Descripción del libro
     * @param autor Autor del libro
     * @param year Año de edición del libro
     * @param size Tamaño del archivo del libro electrónico
     * @throws IllegalArgumentException  si alguno de los parámetros no es válido
     */
    public LibroElectronico(String nombre, double precio, String descripcion, String autor, int year, int size) throws IllegalArgumentException {
        super(nombre, precio, descripcion, autor, year);
        if(size>=MIN_SIZE && size<=MAX_SIZE){
            this.size = size;
        }else{
            throw new IllegalArgumentException("Error: Parámetros de creación del libro físico inválidos. El tamaño ("+size+") no está en el rango permitido");
        }
    }
    
    // Sobrecargo los metodos heredados de Libro con la información adicional de LibroElectronico
    
    @Override
    public String[] toArrayAtribNames(){
        String[] nombres = new String[7];
        String[] nombresLibro = super.toArrayAtribNames();
        int i;
        for (i=0; i<nombresLibro.length; i++){
            nombres[i] = nombresLibro[i];
        }
        nombres[i] = "size";
        nombres[i+1] = "descargas";
        return nombres;
    }
    
    @Override       
    public String[] toArrayAtribValues(){
        String[] valores = new String[7];
        String[] valoresLibro = super.toArrayAtribValues();
        String sizeString = Integer.toString(size);
        String descargasString = Integer.toString(numDescargas);
        int i;
        for (i=0; i<valoresLibro.length; i++){
            valores[i] = valoresLibro[i];
        }
        valores[i] = sizeString;
        valores[i+1] = descargasString;
        return valores;
    }
    
    // Sobrecargo el metodo de la interfaz Downloadable
    
    @Override
    public double descargar(double anchoBanda) throws IllegalArgumentException{
        double tiempoDescarga = 0;
        if (anchoBanda>0){
            tiempoDescarga = size/anchoBanda;
            numDescargas++;
        }else{
            throw new IllegalArgumentException("Error: Parámetro de descarga inválido. Ancho de banda incompatible ("+anchoBanda+")");
        }
        return tiempoDescarga;
    }
}
