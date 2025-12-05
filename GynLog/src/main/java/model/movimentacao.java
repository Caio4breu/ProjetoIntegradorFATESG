/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;



/**
 *
 * @author wylli
 */
public class movimentacao{
    
        private int idMovimentacao;
        private int idVeiculo;
        private int idTipoDespesa;
        private String descricao;
        private String data;
        private double valor;

        public movimentacao(int idMovimentacao, int idVeiculo, int idTipoDespesa, String descricao, String data, double valor) {
            this.idMovimentacao = idMovimentacao;
            this.idVeiculo = idVeiculo;
            this.idTipoDespesa = idTipoDespesa;
            this.descricao = descricao;
            this.data = data;
            this.valor = valor;
        }

        public int getIdMovimentacao() { 
            return idMovimentacao; 
        }
        public int getIdVeiculo() { 
            return idVeiculo; 
        }
        public int getIdTipoDespesa() {
            return idTipoDespesa; 
        }
        public String getDescricao() {
            return descricao; 
        }
        public String getData() {
            return data; 
        }
        public double getValor() {
            return valor; 
        }
        

        @Override
        public String toString() {
            return "\n" +"movimentaçao: "+idMovimentacao +" ⚫ "+ " id do veiculo: " + idVeiculo +" ⚫ "+ "id da despesa: " + idTipoDespesa +" ⚫ "+ " descrição: " + descricao +" ⚫ "+ " data: " + data +" ⚫ "+ " valor: " + valor;
        }

              
}
