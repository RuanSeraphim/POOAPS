package br.com.unicarioca.megasena.view;

import br.com.unicarioca.megasena.controller.*;

/**
 * Trabalho de APS de Conceitos de Orientação a Objetos. 
 * Professor: Júlio Silveira
 * Período: 2015/1
 * 
 * @author Rafael Mello <merorafael@gmail.com>
 * @author Allan Rocha <allan.rocha.7@gmail.com>
 * @author Ruan Seraphim <ruanseraphim@yahoo.com.br>
 * @author Vagner Cerqueira <vagner.cerqueira@live.com>
 * @author Franklin Marques <franklinmarques1@gmail.com>
 */
public class Megasena {
    
    public static void main(String[] args) {
        CadastroController cadastro = new CadastroController("cadastro.txt");
        ApostasController apostas = new ApostasController("apostas.txt", cadastro);
        SorteioController sorteio = new SorteioController("sorteio.txt");
        
        apostas.ApuraResultado(sorteio);
        apostas.SalvaResultado("resultado.txt");
    }
    
}
