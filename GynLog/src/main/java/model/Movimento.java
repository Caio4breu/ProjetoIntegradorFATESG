package model;

public class Movimento extends TipoDespesa {
    private int idMovimento;
    private int idVeiculo;
    private int dia;
    private int mes;
    private int ano;
    private String dataText;
    private double valor;
    
    private String DataText;
    
    public Movimento(int idMovimento, int idVeiculo, int idTipoDespesa, double valor, String descricao, String dataText) {
        super(idTipoDespesa, descricao);
        this.idMovimento = idMovimento;
        this.idVeiculo = idVeiculo;
        this.valor = valor;
        this.dataText = dataText;
        
        // Converter a string d/m/a em dia, mes, ano
        String[] partes = dataText.split("/");
        this.dia = Integer.parseInt(partes[0]);
        this.mes = Integer.parseInt(partes[1]);
        this.ano = Integer.parseInt(partes[2]);
    }
    
    // Getters e Setters -------------------------------------------------------
    public int getIdMovimento() { return idMovimento; } // Id do Movimento -----
    public void setIdMovimento(int IdMovimento) { this.idMovimento = idMovimento; }
    
    public int GetIdVeiculo() { return idVeiculo; } // Id do Veiculo -----------
    public void SetIdVeiculo(int idVeiculo) { this.idVeiculo = idVeiculo;}
    
    public int GetDia() { return dia; } // Dia ---------------------------------
    public void SetDia(int dia) { this.dia = dia;}
    
    public int GetMes() { return mes; } // Mês ---------------------------------
    public void SetMes(int dia) { this.mes = mes;}
    
    public int GetAno() { return ano; } // Ano ---------------------------------
    public void SetAno(int ano) { this.ano = ano;}
    
    public double GetValor() { return valor; } // Valor ------------------------
    public void SetValor(int valor) { this.valor = valor;}
    
    public String GetData() { // Modelo Dia/Mes/Ano ----------------------------
        String dataRegist = null;
        String[] dataPartes = dataRegist.split("/");
                
        int D = Integer.parseInt(dataPartes[0]);
        int M = Integer.parseInt(dataPartes[1]);
        int A = Integer.parseInt(dataPartes[2]);
        
        return dataRegist;
    }
}
