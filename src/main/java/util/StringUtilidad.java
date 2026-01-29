package util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtilidad {

    // Pre-compilamos el patrón Regex para mejorar el rendimiento
    private static final Pattern DIACRITICS_AND_FRIENDS = Pattern.compile("\\p{M}");

    /**
     * Normaliza un string: lo pasa a minúsculas, elimina espacios en los
     * extremos y remueve todas las tildes/acentos.
     *
     * * @param texto El texto original (ej: " Álbum de MÚSICA ")
     * @param texto
     * @return El texto normalizado (ej: "album de musica")
     */
    public static String normalizar(String texto) {
        if (texto == null) {
            return null;
        }

        // 1. Quitar espacios en blanco al inicio y final (TRIM)
        String procesado = texto.trim();

        // 2. Convertir a minúsculas para búsqueda Case-Insensitive
        procesado = procesado.toLowerCase();

        // 3. Normalización Unicode NFD (Canonical Decomposition)
        // Esto separa la 'Á' en dos partes: la letra 'A' y el símbolo del acento '´'
        procesado = Normalizer.normalize(procesado, Normalizer.Form.NFD);

        // 4. Eliminar todas las marcas diacríticas (acentos/tildes)
        // El patrón \\p{M} busca cualquier "Mark" en Unicode (los acentos separados en el paso anterior)
        procesado = DIACRITICS_AND_FRIENDS.matcher(procesado).replaceAll("");

        return procesado;
    }
}
