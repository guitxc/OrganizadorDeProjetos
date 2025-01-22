package Telas;

import BancoDeDados.CrudBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicio {



    JLabel etiqueta;
    JFrame tela;

    public TelaInicio() {
        JFrame telaConsulta = new TelaEditar();
        JFrame telaExcluir = new TelaExcluir();
        JFrame telaAdicionar = new TelaAdicionar();

        tela = new JFrame();

        tela.setLayout(new FlowLayout());

        tela.setSize(700, 150);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);

        tela.setTitle("Organização de Tarefas");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(null);
        tela.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel title = new JLabel("Organização de Tarefas", SwingConstants.CENTER);
        title.setBounds(0, 0, 700, 50);
        title.setFont(new Font("Sans-Serif", Font.PLAIN, 24));

        // Painel lateral para o menu
        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new GridLayout(1, 5)); // Layout em grade com uma coluna
        menuLateral.setBounds(0, 80, 700, 20); // Definir posição e tamanho do menu lateral

        // Adicionar botões ao painel lateral
        JButton btnIncluir = new JButton("Adicionar Tarefa");
        JButton btnAlterar = new JButton("Alterar Tarefa");
        JButton btnExcluir = new JButton("Excluir Tarefa");
        JButton btnListar = new JButton("Todas as Tarefas");
        JButton btnSair = new JButton("Sair");

        // Botão de Sair
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adicionar ActionListener aos botões
        btnIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAdicionar.setVisible(true);
            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaConsulta.setVisible(true);
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExcluir.setVisible(true);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrudBD cbd = new CrudBD();
                cbd.listarTarefas();
            }
        });

        tela.add(title);
        menuLateral.add(btnIncluir);
        menuLateral.add(btnAlterar);
        menuLateral.add(btnExcluir);
        menuLateral.add(btnListar);
        menuLateral.add(btnSair);

        tela.add(menuLateral);
        tela.setVisible(true);
    }
}