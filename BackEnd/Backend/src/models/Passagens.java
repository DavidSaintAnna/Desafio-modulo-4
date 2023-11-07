package models;

import java.util.Date;

public class Passagens {

    private int id;
    private String nome;
    private Date dataDeChegada;
    private Date dataDeSaida;
    private Date dataDeRetorno;
    private Aeroportos aeroportos;
    private float preco;

    public Passagens() {

    }

    public Passagens(int id, String nome, Date dataDeChegada, Date dataDeSaida, Date dataDeRetorno,
            Aeroportos aeroportos, float preco) {
        this.id = id;
        this.nome = nome;
        this.dataDeChegada = dataDeChegada;
        this.dataDeSaida = dataDeSaida;
        this.dataDeRetorno = dataDeRetorno;
        this.aeroportos = aeroportos;
        this.preco = preco;
    }

    public Passagens(String nome, Date dataDeChegada, Date dataDeSaida, Date dataDeRetorno,
            Aeroportos aeroportos, float preco) {
        this.nome = nome;
        this.dataDeChegada = dataDeChegada;
        this.dataDeSaida = dataDeSaida;
        this.dataDeRetorno = dataDeRetorno;
        this.aeroportos = aeroportos;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeChegada() {
        return dataDeChegada;
    }

    public void setDataDeChegada(Date dataDeChegada) {
        this.dataDeChegada = dataDeChegada;
    }

    public Date getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(Date dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public Date getDataDeRetorno() {
        return dataDeRetorno;
    }

    public void setDataDeRetorno(Date dataDeRetorno) {
        this.dataDeRetorno = dataDeRetorno;
    }

    public Aeroportos getAeroportos() {
        return aeroportos;
    }

    public void setAeroportos(Aeroportos aeroportos) {
        this.aeroportos = aeroportos;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", nome='" + nome + "'" +
                ", dataDeChegada='" + dataDeChegada + "'" +
                ", dataDeSaida='" + dataDeSaida + "'" +
                ", dataDeRetorno='" + dataDeRetorno + "'" +
                ", aeroportos='" + aeroportos + "'" +
                ", preco='" + preco + "'" +
                "}";
    }
}
