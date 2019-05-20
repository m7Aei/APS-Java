package models.bean;

public class informacoesCarro {
    private String modelo;
    private String dono;
    private String cor;
    private int anoDoCarro;
    private String placa;
    private int ID_Carro;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoDoCarro() {
        return anoDoCarro;
    }

    public void setAnoDoCarro(int anoDoCarro) {
        this.anoDoCarro = anoDoCarro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getID_Carro() {
        return ID_Carro;
    }

    public void setID_Carro(int ID_Carro) {
        this.ID_Carro = ID_Carro;
    }
}
