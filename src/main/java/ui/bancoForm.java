package ui;

import model.Usuario;
import model.Cuenta;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static service.BancoService.retirarBD;
import static service.BancoService.eliminarBD;
import static service.LoginService.buscarDestinatario;
import static service.BancoService.mandarBD;
import static service.BancoService.saldoCuenta;
import static service.BancoService.transfeririDestinatario;
import static service.LoginService.nombreCuenta;




public class bancoForm extends JFrame {
    private JLabel lblSaldo;
    private JPanel mainPanel;
    private JButton btnDeposito;
    private JButton SALIRButton;
    private JButton btnRetiro;
    private JButton btnTransferencia;
    private JTextArea txtHistorial;
    private JScrollPane scroll;
    private JLabel icon;
    private JButton ELIMINARCUENTAButton;
    private JLabel saldoLB;
    private JLabel nombreLB;
    private ArrayList<String> listaTransacciones = new ArrayList<>();


    public bancoForm() {
        setTitle("Banco");
        setSize(700, 500);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        txtHistorial.setBorder(BorderFactory.createEmptyBorder());
        scroll.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon logotipo = new ImageIcon(getClass().getResource("/img/logo.png"));
        icon.setIcon(logotipo);
        saldoLB.setText(saldoCuenta());
        nombreLB.setText(nombreCuenta());


        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String deposito = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                    mandarBD(deposito);
                    saldoLB.setText(saldoCuenta());
                    JOptionPane.showMessageDialog(null, "Depósito exitoso.");
                    String dep = "Deposito realizado --> " + deposito + " $ -->  Cuenta Personal \n";
                    listaTransacciones.add(dep);
                    txtHistorial.setText(String.valueOf(listaTransacciones));
                }catch (IllegalArgumentException iae){
                    JOptionPane.showMessageDialog(null,iae.getMessage());
                }
            }
        });
        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String retiro = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
                    retirarBD(retiro);
                    saldoLB.setText(saldoCuenta());
                    JOptionPane.showMessageDialog(null, "Retiro exitoso.");
                    String dep = "Retiro realizado --> " + retiro + " $ -->  Cuenta Personal \n";
                    listaTransacciones.add(dep);
                    txtHistorial.setText(String.valueOf(listaTransacciones));
                }catch (IllegalArgumentException iae){
                    JOptionPane.showMessageDialog(null,iae.getMessage());
                }
            }
        });
        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaTransacciones.clear();
                JOptionPane.showMessageDialog(null, "La sesión ha sido cerrada");
                dispose();
                new loginForm();
            }
        });
        ELIMINARCUENTAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    eliminarBD();
                    listaTransacciones.clear();
                    JOptionPane.showMessageDialog(null,"La cuenta ha sido eliminada");
                    dispose();
                    new loginForm();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnTransferencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del destinatario:");
                    buscarDestinatario(nombre);
                    JOptionPane.showMessageDialog(null, "Cuenta Encontrada");
                    String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad a depositar:");
                    retirarBD(cantidad);
                    saldoLB.setText(saldoCuenta());
                    transfeririDestinatario(nombre,cantidad);
                    JOptionPane.showMessageDialog(null, "Transferencia exitosa.");
                    String dep = "Tranferencia  realizada  --> " + cantidad + " $ -->  "+ nombre + "\n";
                    listaTransacciones.add(dep);
                    txtHistorial.setText(String.valueOf(listaTransacciones));
                }catch (IllegalArgumentException iae){
                    JOptionPane.showMessageDialog(null,iae.getMessage());
                }
            }
        });
    }
}
