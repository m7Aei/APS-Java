package models.bean;

public class multasCarros {
    private int ID_Multa;
    private float valorMulta;
    private String nome;
    private String cpf;
    private String tipoMulta;
    private String placaVeiculo;

    public int getID_Multa() {
        return ID_Multa;
    }

    public void setID_Multa(int ID_Multa) {
        this.ID_Multa = ID_Multa;
    }

    public float getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(String tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}