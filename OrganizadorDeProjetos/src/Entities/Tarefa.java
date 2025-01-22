package Entities;

public class Tarefa {
    private String responsavel;
    private String status;
    private String  descricao;
    
    public  Tarefa(){};

    public  Tarefa (String responsavel, String status, String descricao) {
        this.responsavel = responsavel;
        this.status = status;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Reponsavel: %s - Status: %s - Descricao: %s", this.responsavel, this.status, this.descricao);
    }

    public  String getResponsavel() {
        return  responsavel;
    }
    public  void setResponsavel(String responsavel) {   
        this.responsavel = responsavel;
    }

    public  String getStatus() {   
        return  status;
    }
    public  void setStatus(String status) {   
        this.status = status;
    }

    public  String getDescicao() {   
        return descricao;
    }
    public  void setDescricao(String descricao) {   
        this.descricao = descricao;
    }

}
