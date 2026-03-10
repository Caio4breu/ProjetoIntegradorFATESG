package grupoaravia.gynlog.model;

/**
 * Grupo Aravia
 *
 * @author <a href="https://github.com/Alexsanei">Alexsanei</a>
 * @author <a href="https://github.com/Caio4breu">Caio4breu</a>
 * @author <a href="https://github.com/Nomscodes">Nomscodes</a>
 * @author <a href="https://github.com/GabrielNaokiUT">GabrielNaokiUT</a>
 * @author <a href="https://github.com/wyllianmn">wyllianmn</a>
 */

public class TipoDespesa {
    private int idTipoDespesa;
    private String descricao;
    
    public TipoDespesa(int idTipoDespesa, String descricao) {
        this.idTipoDespesa = idTipoDespesa;
        this.descricao = descricao;
    }
    
    public int getIdTipoDespesa() { return idTipoDespesa; }
    public void setIdTipoDespesa(int idTipoDespesa) { this.idTipoDespesa = idTipoDespesa; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
}