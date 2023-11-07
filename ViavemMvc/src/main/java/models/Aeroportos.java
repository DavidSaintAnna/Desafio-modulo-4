package models;

public class Aeroportos {

    private int id;
    private String nome;
    private String cidade;
    private String pais;

    public Aeroportos() {

    }

    public Aeroportos(int id, String nome, String cidade, String pais) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
    }

    public Aeroportos(String nome, String cidade, String pais) {

        this.nome = nome;
        this.cidade = cidade;
        this.pais = pais;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", nome='" + nome + "'" +
                ", cidade='" + cidade + "'" +
                ", pais='" + pais + "'" +
                "}";
    }
}
