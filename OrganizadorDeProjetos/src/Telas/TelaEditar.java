package Telas;

import BancoDeDados.CrudBD;
import Entities.Tarefa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class TelaEditar extends JFrame{

    CrudBD cBD = new CrudBD();

    String[] statusList = {"A fazer", "Em andamento", "Concluído"};

    int id;

    //Rotulos
    private JLabel lbConsulta;
    private JLabel lbResponsavel;
    private JLabel lbStatus;
    private JLabel lbDescricao;

    //campo texto
    private JTextField tfConsulta;
    private JTextField tfResponsavel;
    private JComboBox cbStatus;
    private JTextArea tfDescricao;

    //Botões
    private JButton btnConsulta;
    private JButton btnAlteraResponsavel;
    private JButton btnAlteraStatus;
    private JButton btnAlteraDescricao;

    public TelaEditar(){
        GridBagConstraints gbc = new GridBagConstraints();

        this.setSize(500, 300);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel telaConsulta = new JPanel();
        telaConsulta.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;

        telaConsulta.setSize(400, 300);
        telaConsulta.setVisible(true);

        gbc.insets = new Insets(8, 2, 8, 2);
        telaConsulta.repaint();

        lbConsulta = new JLabel("Id:", SwingConstants.CENTER);
        lbResponsavel = new JLabel("Reponsavel", SwingConstants.CENTER);
        lbStatus = new JLabel("Status", SwingConstants.CENTER);
        lbDescricao = new JLabel("Descrição", SwingConstants.CENTER);

        tfConsulta = new JTextField();
        tfResponsavel = new JTextField();
        cbStatus = new JComboBox(statusList);
        tfDescricao = new JTextArea();
        tfDescricao.setLineWrap(true);

        btnConsulta = new JButton("Consultar");
        btnAlteraResponsavel = new JButton("Alterar");
        btnAlteraStatus = new JButton("Alterar ");
        btnAlteraDescricao = new JButton("Alterar ");

//Posicionando itens

//Adicionando Itens

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        telaConsulta.add(lbConsulta, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx  = 2;
        telaConsulta.add(tfConsulta, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        telaConsulta.add(btnConsulta, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        telaConsulta.add(lbResponsavel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 2;
        telaConsulta.add(tfResponsavel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        telaConsulta.add(btnAlteraResponsavel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        telaConsulta.add(lbStatus, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 2;
        telaConsulta.add(cbStatus, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0.2;
        telaConsulta.add(btnAlteraStatus, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        telaConsulta.add(lbDescricao, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weighty = 1.5;
        telaConsulta.add(tfDescricao, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 0.2;
        telaConsulta.add(btnAlteraDescricao, gbc);


        this.add(telaConsulta);
//programação
//
        btnConsulta.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickConsulta();
                    }
                }
        );

        btnAlteraStatus.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAlterarStatus();
                    }
                }
        );


        btnAlteraResponsavel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAlterarResponsavel();
                    }
                }
        );

        btnAlteraDescricao.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAlterarDescricao();
                    }
                });


    }

    private void onClickConsulta() {
        if(!Objects.equals(tfConsulta.getText(), "")) {
            id = Integer.parseInt(tfConsulta.getText());
            try {
                Tarefa consulta = cBD.consultarTask(id);
                System.out.println("Tarefa localizada: " + consulta.toString());
            } catch (Exception e) {
                System.out.println("Não foi possível localizar a tarefa");
            }
        } else {
            System.out.println("Insira o Id para consultar");
        }
    }

    private void onClickAlterarStatus() {
        if(id != 0) {
            cBD.updateTarefa(cbStatus.getSelectedItem().toString(), id, "responsavel");
            System.out.println("Status da Tarefa alterado");
        } else {
            System.out.println("Consulte Id para editar o campo \"status\"");
        }
    }


    private void onClickAlterarResponsavel() {
        if(id != 0) {
            cBD.updateTarefa(tfResponsavel.getText(), id, "responsavel");
            System.out.println("Status da Tarefa alterado");
        } else {
            System.out.println("Consulte Id para editar o campo \"responsável\"");
        }
    }

    private void onClickAlterarDescricao() {
        if(id != 0) {
            cBD.updateTarefa(tfDescricao.getText(), id, "descricao");
            System.out.println("Descrição da Tarefa alterado");
        } else {
            System.out.println("Consulte Id para editar o campo \"descrição\"");
        }
    }
}