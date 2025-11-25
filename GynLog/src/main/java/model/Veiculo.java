/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class Veiculo {

    private String placa, marca, modelo;  //atributos dados no enunciado//
    private int anoFabricacao, idVeiculo;
    private boolean ativo;

    public Veiculo(int idVeiculo, String placa, String marca, String modelo, int anoFabricacao, boolean ativo){ //construtor//
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.ativo = true;
    }
    public int getIdVeiculo(){ //get e set para acessar os atributos private//
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo){
        this.idVeiculo = idVeiculo;
    }
    public int getmarca(){ 
        return idVeiculo;
    }
    public void setmarca(String marca){
        this.marca = marca;
    }
    public String getmodelo(){ 
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo = modelo;
    }
    public String getplaca(){ 
        return placa;
    }
    public void setplaca(String placa){
        this.placa = placa;
    }
    public int getanoFabricacao(){ 
        return anoFabricacao;
    }
    public void anoFabricaca(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }
    public boolean isAtivo(){ //acessar e modificar a disponibilidade do veículo//
        return ativo;
    }
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
}


   
    

    
