package ui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;
import service.LoginService;
public class loginForm extends JFrame {
    private JPanel loginPanel;
    private JLabel icon;
    private JLabel logo;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JPasswordField passwordField1;
    private JButton registrateAquiButton;

    public loginForm(){
        setTitle("loginForm");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(loginPanel);
        setLocationRelativeTo(null);
        textField1.setBorder(BorderFactory.createEmptyBorder());
        passwordField1.setBorder(BorderFactory.createEmptyBorder());
        button1.setBorder(BorderFactory.createEmptyBorder());
        registrateAquiButton.setBorder(BorderFactory.createEmptyBorder());

        ImageIcon icono = new ImageIcon(getClass().getResource("/img/icon.png"));
        ImageIcon logotipo = new ImageIcon(getClass().getResource("/img/logo.png"));
        logo.setIcon(logotipo);
        icon.setIcon(icono);


        button1.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                String clave = new String(passwordField1.getPassword());
                try {
                    Usuario usuario = LoginService.verificarLogin(nombre, clave);
                    JOptionPane.showMessageDialog(null, "Bienvenido " + usuario.getNombre());
                    new bancoForm();
                    dispose();
                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(null, iae.getMessage());
                }
            }
        });
        registrateAquiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registroForm();
            }
        });
    }

}
