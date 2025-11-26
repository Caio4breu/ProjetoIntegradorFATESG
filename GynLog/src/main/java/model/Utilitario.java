/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class Utilitario extends Veiculo {

    private double capacidadeCargakg; // atributo específico extra//

    public Utilitario(int idVeiculo, String placa, String marca, String modelo, int anoFabricacao, boolean ativo, double capacidadeCargakg) { //costrutor que recebe os dados da classe Veiculo(mae)//
        
        super(idVeiculo, placa, marca, modelo, anoFabricacao, ativo);

        this.capacidadeCargakg = capacidadeCargakg;
    }
    
    public double getCapacidadeCargakg() { 
        return capacidadeCargakg;
    }

    public void setCapacidadeCargakg(double capacidadeCargakg) {
        this.capacidadeCargakg = capacidadeCargakg;
    }

    @Override
    public String toString() { //poliformismo//
        return "Caminhão: " + getmodelo() + 
               " - ID: " + getIdVeiculo() +
               " - Placa: " + getplaca() + 
               " - Ano: " + getanoFabricacao() + 
               " - Carga Máx: " + capacidadeCargakg+ " kg.";
    }
}


