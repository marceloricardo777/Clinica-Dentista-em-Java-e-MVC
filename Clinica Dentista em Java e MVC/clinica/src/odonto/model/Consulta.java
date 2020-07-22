/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odonto.model;

import java.util.Objects;

public class Consulta {

    private long id;

    private String dentista;

    private String paciente;

    private String valor;
    private String datadaconsulta;
    private String situacaopag;

    public Consulta(long id, String dentista, String paciente,
            String valor, String datadaconsulta, String situacaopag
    ) {
        super();

        this.id = id;
        this.dentista = dentista;
        this.paciente = paciente;
        this.valor = valor;
        this.datadaconsulta = datadaconsulta;
        this.situacaopag = situacaopag;
    }

    public Consulta(String dentista, String paciente, String valor, String datadaconsulta, String situacaopag) {

        this.dentista = dentista;
        this.paciente = paciente;
        this.valor = valor;
        this.datadaconsulta = datadaconsulta;
        this.situacaopag = situacaopag;
    }

    public Consulta() {
        super();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDentista() {
        return dentista;
    }

    public void setDentista(String dentista) {
        this.dentista = dentista;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDatadaconsulta() {
        return datadaconsulta;
    }

    public void setDatadaconsulta(String datadaconsulta) {
        this.datadaconsulta = datadaconsulta;
    }

    public String getSituacaopag() {
        return situacaopag;
    }

    public void setSituacaopag(String situacaopag) {
        this.situacaopag = situacaopag;
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
        final Consulta other = (Consulta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dentista, other.dentista)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.datadaconsulta, other.datadaconsulta)) {
            return false;
        }
        if (!Objects.equals(this.situacaopag, other.situacaopag)) {
            return false;
        }
        return true;
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 73 * hash + Objects.hashCode(this.dentista);
        hash = 73 * hash + Objects.hashCode(this.paciente);
        hash = 73 * hash + Objects.hashCode(this.valor);
        hash = 73 * hash + Objects.hashCode(this.datadaconsulta);
        hash = 73 * hash + Objects.hashCode(this.situacaopag);
        return hash;
    }
}
