package libreria;

/**
 * Interfaz que incorpora la capacidad de ser descargado de la red.
 * @author Adrian Romero Ramirez
 */
public interface Downloadable {
    
    /**
     * Descarga el elemento por la red.
     * @param anchoBanda ancho de banda del sistema (en Kb/seg)
     * @return tiempo necesario para descargar el elemento (en segundos)
     * @throws IllegalArgumentException si el ancho de banda no es mayor que cero
     */
    double descargar(double anchoBanda) throws IllegalArgumentException;
}
