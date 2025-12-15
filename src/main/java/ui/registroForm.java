package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.RegistroService;

public class registroForm extends JFrame {
    private JPanel registroPane;
    private JLabel icon;
    private JTextField textField1;
    private JTextField textField2;
    private JButton registrarseButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;

    public registroForm(){
        setTitle("Registro");
        setVisible(true);
        setSize(250, 550);
        setLocationRelativeTo(null);
        setContentPane(registroPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logotipo = new ImageIcon(getClass().getResource("/img/logo.png"));
        icon.setIcon(logotipo);
        registrarseButton.setBorder(BorderFactory.createEmptyBorder());
        passwordField1.setBorder(BorderFactory.createEmptyBorder());
        passwordField2.setBorder(BorderFactory.createEmptyBorder());
        textField1.setBorder(BorderFactory.createEmptyBorder());
        textField2.setBorder(BorderFactory.createEmptyBorder());


        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                String correo = textField2.getText();
                String clave = new String(passwordField1.getPassword());
                String clave2 = new String(passwordField2.getPassword());
                try{
                    RegistroService.registrar(nombre,correo,clave,clave2);
                    JOptionPane.showMessageDialog(null, "Registrado correctamente");
                    setVisible(false);
                }catch (IllegalArgumentException iae){
                    JOptionPane.showMessageDialog(null,iae.getMessage());
                }


            }
        });
    }
}
