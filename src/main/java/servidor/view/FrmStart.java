package servidor.view;

import servidor.IparkingApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmStart extends JFrame {

    private final String[] args;

    public FrmStart(String[] args) {
        this.args = args;
        createForm();
        setVisible(true);
    }

    /**
     * Create the frame.
     */
    public void createForm() {
        setTitle("iParking - Inicio Servidor");
        //setIconImage(new ImageIcon("src/main/resources/aparcamiento.png").getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Se cerrará el servidor si sale.", "Cuidado",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 402, 258);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Iniciar servidor");
        btnNewButton.addActionListener(e -> IparkingApplication.lanzarServidor(args));
        btnNewButton.setBounds(106, 123, 169, 69);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Servidor iParking");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 24, 378, 49);
        contentPane.add(lblNewLabel);
    }
}
