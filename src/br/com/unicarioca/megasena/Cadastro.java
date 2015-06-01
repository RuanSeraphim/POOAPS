package br.com.unicarioca.megasena;

import java.io.*;

public class Cadastro {
    
    private FileReader file;
    
    public Cadastro(String filename) {
        try {
            this.file = new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    
}
