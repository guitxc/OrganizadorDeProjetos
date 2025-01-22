package BancoDeDados;

import Entities.Tarefa;

import  java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.sql.SQLException;

public class CrudBD {

    public void incluirTask(Tarefa tk) {
        String sqlInsert = "INSERT INTO tarefas(responsavel, status, descricao) VALUES(?, ?, ?)";

        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try { 
            stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, tk.getResponsavel());
            stmt.setString(2, tk.getStatus());
            stmt.setString(3, tk.getDescicao());
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Erro ao incluir os dados : "+e);
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }   

    public Tarefa consultarTask(int id) throws Exception{
        String idConsulta = String.valueOf(id);
        Tarefa tkConsulta = new Tarefa();

        Connection conn = ConnFactory.getConn();
        String comando = ("Select * from tarefas where id =  ?");
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(comando);
            stmt.setString(1,idConsulta);
            ResultSet result = stmt.executeQuery();
            if (!result.isBeforeFirst() ){
                System.out.println("Id não encontrado");
                throw (new Exception("Id não encontrado"));
            } else {
                while(result.next()){
                    String resp = result.getString("responsavel");
                    String stat = result.getString("status");
                    String desc = result.getString("descricao");
                    tkConsulta.setDescricao(desc);
                    tkConsulta.setResponsavel(resp);
                    tkConsulta.setStatus(stat);
                }
                return tkConsulta;
            }
        } catch(SQLException e) {
            throw (new Exception("Erro ao consultar dados"));
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void updateTarefa(String dadoAlterado, Integer id, String campo){
        if (id != null){
            String sqlUpdate = String.format("UPDATE tarefas SET %s = ? WHERE id = ?", campo);

            Connection conn = ConnFactory.getConn();
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(sqlUpdate);
                stmt.setString(1, dadoAlterado);
                stmt.setString(2, String.valueOf(id));
                stmt.executeUpdate();
            } catch(SQLException e) {
                System.out.println("Erro ao atualizar os dados : "+e);
            } finally {
                ConnFactory.closeConn(conn, stmt);
            }
        } else {
            System.out.println("Insira um Id válido");
        }

    }

    public void excluirTarefa(int id ) {
        String sqlDelete = "DELETE from tarefas WHERE id = ?";
        Connection  conn = ConnFactory.getConn();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sqlDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Erro ao incluir os dados" + e);
        } finally {
            ConnFactory.closeConn(conn);
        }
    }

    public void listarTarefas(){
        Connection conn = ConnFactory.getConn();
        String comando = ("Select * from tarefas");
        PreparedStatement stmt = null;
        String id, resp, stat, desc;
        System.out.print("-".repeat(30) + "\n");
        System.out.println("Tarefas do Projeto:");
        System.out.print("-".repeat(30) + "\n");

        try {
            stmt = conn.prepareStatement(comando);
            ResultSet result = stmt.executeQuery();
            if (!result.isBeforeFirst() ){
                System.out.println("-- Não foi possível listar as tarefas");
            } else {
                while(result.next()){

                    id = result.getString("id");
                    resp = result.getString("responsavel");
                    stat = result.getString("status");
                    desc = result.getString("descricao");

                    System.out.print("-".repeat(30) + "\n");
                    System.out.println("Id: "+id);
                    System.out.println("Responsável: "+resp);
                    System.out.println("Status: "+stat);
                    System.out.println("Descrição: ");
                    System.out.println(desc);
                    System.out.print("-".repeat(30) + "\n");
                }
            }
        } catch(SQLException e) {
            System.out.println("Erro ao consultar : "+e);
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }
}
