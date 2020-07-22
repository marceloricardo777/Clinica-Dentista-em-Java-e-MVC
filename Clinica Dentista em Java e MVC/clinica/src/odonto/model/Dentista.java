/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model;

import java.util.Objects;

public class Dentista {

    private long id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String endereco;
    private String sexo;
 public Dentista() {
		
	}
    public Dentista(int id, String nome, String cpf, String rg, String endereco, String telefone, String sexo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 63));

        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.rg);
        hash = 89 * hash + Objects.hashCode(this.endereco);
        hash = 89 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + Objects.hashCode(this.sexo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dentista other = (Dentista) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Paciente [id=").append(id).append(", nome=")
                .append(nome).append(", rg=").append(rg).append(", cpf=")
                .append(cpf).append(", endereco=").append(endereco)
                .append(", telefone=").append(telefone).append(", sexo=").append(sexo)
                .append("]");

        return builder.toString();
    }

}
