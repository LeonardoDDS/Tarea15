package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblGnero;
    private JLabel lblPeso;
    private JLabel lblPlataforma;
    private JLabel lblDesarrollador;
    private JTextField txtId;
    private JTextField txtPlataforma;
    private JTextField txtnombre;
    private JTextField txtGenero;
    private JTextField txtPeso;
    private JTextField txtDesarrollador;
    private JButton btnAgregar;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private ModeloTablaJuego modelo;
    private ArrayList<Videojuego> info;
    private JScrollPane scroll;
    private JTable tblTabla;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(500, 700);
        layout = new GridLayout(2, 1);
        this.setLayout(layout);
        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(188, 227, 166));
        lblId = new JLabel("Id: ");
        txtId = new JTextField(4);
        panel1.add(lblId);
        panel1.add(txtId);
        lblNombre = new JLabel("Nombre: ");
        txtnombre = new JTextField(30);
        panel1.add(lblNombre);
        panel1.add(txtnombre);
        lblGnero = new JLabel("Genero: ");
        txtGenero = new JTextField(15);
        panel1.add(lblGnero);
        panel1.add(txtGenero);
        lblPeso = new JLabel("Peso (GB): ");
        txtPeso = new JTextField(5);
        panel1.add(lblPeso);
        panel1.add(txtPeso);
        lblPlataforma = new JLabel("Plataforma: ");
        txtPlataforma = new JTextField(15);
        panel1.add(lblPlataforma);
        panel1.add(txtPlataforma);
        lblDesarrollador = new JLabel("Desarrollador: ");
        txtDesarrollador = new JTextField(25);
        panel1.add(lblDesarrollador);
        panel1.add(txtDesarrollador);
        btnAgregar = new JButton("Agregar juego");
        panel1.add(btnAgregar);

        this.getContentPane().add(panel1, 0);

        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(201, 195, 241));
        info = new ArrayList<>();
        info.add(new Videojuego(1, "LoL", "MOBA", 4.5, "Windows y Mac",
                "Riot Games"));
        modelo = new ModeloTablaJuego(info);
        tblTabla = new JTable(modelo);
        scroll = new JScrollPane(tblTabla);
        panel2.add(scroll);

        this.getContentPane().add(panel2, 1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Videojuego nuevo = new Videojuego();
                    nuevo.setId(Integer.parseInt(txtId.getText()));
                    nuevo.setNombre(txtnombre.getText());
                    nuevo.setGenero(txtGenero.getText());
                    nuevo.setPesoEnGB(Double.parseDouble(txtPeso.getText()));
                    nuevo.setPlataforma(txtPlataforma.getText());
                    nuevo.setDesarrollador(txtDesarrollador.getText());
                    //info.add(nuevo);
                    modelo.agregarJuego(nuevo);
                    tblTabla.updateUI();
            }
        });
        this.setVisible(true);
    }
}
