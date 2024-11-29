//FINALL
package log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login extends JDialog implements ActionListener {
    public JTextField txtUser,txtId;
    public JPasswordField txtPassword;
    public JButton btnLogin, btnExit;
   

    public Login(JFrame parent) {
        super(parent, "Login", true); // Login modal
        setSize(300, 200);
        setLocationRelativeTo(null);

        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        // Etiquetas y campos de texto
        JLabel lblUser = new JLabel("Usuario:");
        txtUser = new JTextField();

        JLabel lblPassword = new JLabel("Contraseña:");
        txtPassword = new JPasswordField();
        
        // Botones
        JLabel lblId = new JLabel("ID");
        txtId = new JTextField();
        
        ImageIcon iconLogin = new ImageIcon("src/IMAGENTOTA/ingresar.png");
        ImageIcon iconExit = new ImageIcon("src/IMAGENTOTA/salir.png");

        
        Image imgLogin = iconLogin.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Image imgExit = iconExit.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        
        ImageIcon scaledIconLogin = new ImageIcon(imgLogin);
        ImageIcon scaledIconExit = new ImageIcon(imgExit);

        
        btnLogin = new JButton("Ingresar", scaledIconLogin);
        btnLogin.setToolTipText("DA CLICK PARA INGRESAR"); 
        btnLogin.addActionListener(this);

        btnExit = new JButton("Salir", scaledIconExit);
        btnExit.setToolTipText("DA CLICK PARA SALIR"); 
        btnExit.addActionListener(this);

        // Agregar componentes al panel en orden
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblId);
        panel.add(txtId);
        panel.add(btnLogin);
        panel.add(btnExit);

        // Añadir el panel al contenido de la ventana
        add(panel);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnLogin) 
    {
        String user = txtUser.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();
        String id = txtId.getText();
        String nameBD = "bd_total";
        String nameTable = "usuarios";
        MySQL _sql = new MySQL();
        _sql.MySQLConnection("root", "", "");
        if (_sql.verificarBaseDeDatos(nameBD)) 
        {
            System.out.println("EXISTE"); 
            if (_sql.verificarTabla(nameBD,nameTable)) 
            {
            System.out.println("EXISTE");
            _sql.MySQLConnection("root", "", nameBD);
            _sql.insertData(nameTable, id, user, password);
            }
            else
            {
            _sql.MySQLConnection("root","", nameBD);
            _sql.createTable(nameTable);
            _sql.insertData(nameTable, id, user, password);                
            }

        }
        else
        {
            System.out.println("NO EXISTE");    
            _sql.crateDB(nameBD);
            _sql.createTable(nameTable);
            _sql.insertData(nameTable, id, user, password);
            
        }
        dispose();
}
}
}