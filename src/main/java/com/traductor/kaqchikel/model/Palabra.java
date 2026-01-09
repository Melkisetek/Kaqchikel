package com.traductor.kaqchikel.model;

import java.util.Objects;

public class Palabra {

    private int id;
    private String español;
    private String kaqchikel;

    public Palabra() {
    }

    public Palabra(String español) {
        this.español = español;
    }
    
// listar todo
    public Palabra(int id, String español, String kaqchikel) {
        this.id = id;
        this.español = español;
        this.kaqchikel = kaqchikel;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getEspañol() {
        return this.español;
    }

    public void setEspañol(String español) {
        this.español = español;
    }

    public String getKaqchikel() {
        return this.kaqchikel;
    }

    public void setKaqchikel(String kaqchikel) {
        this.kaqchikel = kaqchikel;
    }

    @Override
    public String toString() {
        return "Palabra{" + "Espa\u00f1ol=" + español + ", Kaqchikel=" + kaqchikel + '}';
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.español);
        hash = 89 * hash + Objects.hashCode(this.kaqchikel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palabra other = (Palabra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.español, other.español)) {
            return false;
        }
        return Objects.equals(this.kaqchikel, other.kaqchikel);
    }

}
