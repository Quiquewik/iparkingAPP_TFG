package servidor.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import servidor.IparkingApplication;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class FrmStart extends JFrame {

	private final String[] args;
 	
	public FrmStart(String[] args) throws IOException {
		this.args = args;
		createForm();
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void createForm() throws IOException {
		setTitle("iParking - Inicio Servidor");
		setIconImage(new ImageIcon(ImageIO.read(new File("src/main/resources/aparcamiento.png"))).getImage());
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
		btnNewButton.setBounds(10, 121, 169, 69);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Servidor iParking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 24, 378, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnCerrarServidor = new JButton("Cerrar servidor");
		btnCerrarServidor.addActionListener(e -> {
			if (JOptionPane.showConfirmDialog(null, "Se cerrará el servidor si sale.", "Cuidado",
JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
} else {
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
}
		});
		btnCerrarServidor.setBounds(209, 121, 169, 69);
		contentPane.add(btnCerrarServidor);
	}
}
