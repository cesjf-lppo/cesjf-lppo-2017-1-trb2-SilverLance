package br.cesjf.lppo.classes;

import java.util.Date;

/**
 *
 * @author Adriano
 */
public class Leitura {
    private int id;
    private int coleta;
    private String local;
    private double leitura;
    private String unidade;
    private Date atualizacao;
    
    public Leitura(){
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the coleta
     */
    public int getColeta() {
        return coleta;
    }

    /**
     * @param coleta the coleta to set
     */
    public void setColeta(int coleta) {
        this.coleta = coleta;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the leitura
     */
    public double getLeitura() {
        return leitura;
    }

    /**
     * @param leitura the leitura to set
     */
    public void setLeitura(double leitura) {
        this.leitura = leitura;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the atualizacao
     */
    public Date getAtualizacao() {
        return atualizacao;
    }

    /**
     * @param atualizacao the atualizacao to set
     */
    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }
}
