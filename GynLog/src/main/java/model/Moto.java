/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class Moto extends Veiculo {

    private int Cilindradas; // atributo específico extra//

    public Moto(int idVeiculo, String placa, String marca, String modelo, int anoFabricacao, boolean ativo, int Cilindradas) { //costrutor que recebe os dados da classe Veiculo(mae)//
        
        super(idVeiculo, placa, marca, modelo, anoFabricacao, ativo);

        this.Cilindradas = Cilindradas;
    }
    
    public int getCilindradas() { 
        return Cilindradas;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.Cilindradas = Cilindradas;
    }

    @Override
    public String toString() { //poliformismo//
        return "Caminhão: " + getmodelo() + 
               " - ID: " + getIdVeiculo() +
               " - Placa: " + getplaca() + 
               " - Ano: " + getanoFabricacao() + 
               " - Cilindradas: " + Cilindradas + " cc";
    }
}