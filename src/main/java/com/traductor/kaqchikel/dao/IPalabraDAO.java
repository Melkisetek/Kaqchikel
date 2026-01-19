
package com.traductor.kaqchikel.dao;

import com.traductor.kaqchikel.model.Palabra;
import java.util.List;

public interface IPalabraDAO {
    Palabra buscarTermino(Palabra palabra);
    List<Palabra> listarPalabra();
    List<Palabra> filtrarListaPorLetra(Palabra filtrarPalabra);
    
}
