/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class Caminhao extends Veiculo {

    private double capacidadeCarga; // atributo específico extra//

    public Caminhao(int idVeiculo, String placa, String marca, String modelo, int anoFabricacao, boolean ativo, double capacidadeCarga) { //costrutor que recebe os dados da classe Veiculo(mae)//
        
        super(idVeiculo, placa, marca, modelo, anoFabricacao, ativo);

        this.capacidadeCarga = capacidadeCarga;
    }
    
    public double getCapacidadeCarga() { 
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString() { //poliformismo//
        return "Caminhão: " + getmodelo() + 
               " - ID: " + getIdVeiculo() +
               " - Placa: " + getplaca() + 
               " - Ano: " + getanoFabricacao() + 
               " - Carga Máx: " + capacidadeCarga + " ton.";
    }
}
