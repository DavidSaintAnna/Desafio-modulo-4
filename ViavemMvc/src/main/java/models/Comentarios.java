package models;

import java.util.Date;

public class Comentarios {
	private int id;
    private String comentario;
    private Date data_de_publicacao;
    private Usuarios usuarios;

    public Comentarios() {
    }

    public Comentarios(int id, String comentario, Date data_de_publicacao, Usuarios usuarios) {
        this.id = id;
        this.comentario = comentario;
        this.data_de_publicacao = data_de_publicacao;
        this.usuarios = usuarios;
    }

    public Comentarios(String comentario, Date data_de_publicacao, Usuarios usuarios) {
        this.comentario = comentario;
        this.data_de_publicacao = data_de_publicacao;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData_de_publicacao() {
        return data_de_publicacao;
    }

    public void setData_de_publicacao(Date data_de_publicacao) {
        this.data_de_publicacao = data_de_publicacao;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + id + "'" +
                ", comentario='" + comentario + "'" +
                ", data_de_publicacao='" + data_de_publicacao + "'" +
                ", usuarios='" + usuarios + "'" +
                "}";
    }
}
