package Telas;

import BancoDeDados.CrudBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class TelaExcluir extends JFrame {

    private JLabel rotuloid ;


    //Botão
    private JButton btnExcluir ;
    private JButton btnVoltar ;
    //Campo Texto
    private JTextField campoId;

    CrudBD cBD = new CrudBD();

    public TelaExcluir() {

    //criando a tela
        setSize(400, 180);
        setVisible(false);
        setLocationRelativeTo(null);

        JPanel telaExcluir = new JPanel();
        telaExcluir.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        telaExcluir.setSize(400, 400);
        telaExcluir.setVisible(true);

        rotuloid = new JLabel("Id: ", SwingConstants.CENTER);
        btnExcluir = new JButton("Excluir");
        btnVoltar = new JButton("Voltar");
        campoId = new JTextField();


     //adicionando coisas na tela
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        telaExcluir.add(rotuloid, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        telaExcluir.add(campoId, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        telaExcluir.add(btnExcluir, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        telaExcluir.add(btnVoltar, gbc);

        this.add(telaExcluir);

    //programação

    btnExcluir.addActionListener(
        new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        onClickExcluir();}});


    btnVoltar.addActionListener(
        new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
        onClickVoltar(); }});
    }

    private void onClickExcluir() {
        if(campoId.getText() != null) {
            int id = Integer.parseInt(campoId.getText());
            cBD.excluirTarefa(id);
            System.out.println("Tarefa de Id: " + id + " Excluida");
        } else {
            System.out.println("Insira o Id para excluir");
        }
    }

    private void onClickVoltar(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
