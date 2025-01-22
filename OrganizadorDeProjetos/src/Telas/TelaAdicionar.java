package Telas;

import BancoDeDados.CrudBD;
import Entities.Tarefa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class TelaAdicionar extends JFrame{

    CrudBD cBD = new CrudBD();

    String[] statusList = {"A fazer", "Em andamento", "Concluído"};

    //Rotulos
    private JLabel lbResponsavel;
    private JLabel lbStatus;
    private JLabel lbDescricao;

    //campo texto
    private JTextField tfResponsavel;
    private JComboBox cbStatus;
    private JTextArea tfDescricao;

    //Botões
    private JButton btnVoltar;
    private JButton btnCriar;

    public TelaAdicionar(){
        GridBagConstraints gbc = new GridBagConstraints();

        this.setSize(500, 250);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel telaConsulta = new JPanel();
        telaConsulta.setLayout(new GridBagLayout());

        gbc.insets = new Insets(8, 2, 8, 2);
        telaConsulta.repaint();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;

        telaConsulta.setSize(200, 250);
        telaConsulta.setVisible(true);

        lbResponsavel = new JLabel("Reponsavel", SwingConstants.CENTER);
        lbStatus = new JLabel("Status", SwingConstants.CENTER);
        lbDescricao = new JLabel("Descrição", SwingConstants.CENTER);

        tfResponsavel = new JTextField();
        cbStatus = new JComboBox(statusList);
        tfDescricao = new JTextArea();
        tfDescricao.setLineWrap(true);

        btnVoltar = new JButton("Voltar");
        btnCriar = new JButton("Criar");


//Posicionando itens

//Adicionando Itens

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        telaConsulta.add(lbResponsavel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        telaConsulta.add(tfResponsavel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        telaConsulta.add(lbStatus, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        telaConsulta.add(cbStatus, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        telaConsulta.add(lbDescricao, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 3;
        telaConsulta.add(tfDescricao, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        telaConsulta.add(btnVoltar, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        telaConsulta.add(btnCriar, gbc);


        this.add(telaConsulta);
//programação

        btnVoltar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickVoltar();
                    }
                }
        );

        btnCriar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickCriar();
                    }
                });
    }


    private void onClickVoltar() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void onClickCriar() {
        if(tfResponsavel.getText() != null && cbStatus.getSelectedItem() != null && tfDescricao.getText() != null){
            Tarefa newTask = new Tarefa(tfResponsavel.getText(), cbStatus.getSelectedItem().toString(), tfDescricao.getText());
            cBD.incluirTask(newTask);
            System.out.println("Tarefa adicionada: "+newTask.toString());
        } else {
            System.out.println("Preencha todos os campos para adicionar a tarefa");
        }
    }
}