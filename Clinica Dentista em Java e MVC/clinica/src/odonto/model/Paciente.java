package odonto.model;

import java.util.Objects;

public class Paciente {

    private long id;
    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String telefone;
    private String datanascimento;
    private String sexo;

    public Paciente() {

    }

    public Paciente(long id, String nome, String rg, String cpf, String endereco, String telefone, String datanascimento, String sexo) {

        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
        this.sexo = sexo;

    }

    public Paciente(String nome, String rg, String cpf, String endereco, String telefone, String datanascimento, String sexo) {

        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.rg);
        hash = 23 * hash + Objects.hashCode(this.cpf);
        hash = 23 * hash + Objects.hashCode(this.endereco);
        hash = 23 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + Objects.hashCode(this.datanascimento);
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
        final Paciente other = (Paciente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.datanascimento, other.datanascimento)) {
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
                .append(", telefone=").append(telefone).append(", datanascimento=").append(datanascimento).append(", sexo=").append(sexo)
                .append("]");

        return builder.toString();
    }

}
