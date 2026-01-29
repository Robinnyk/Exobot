package trApp.trDesktopApp.trForms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import trApp.trDesktopApp.trCustomControl.PatButton;
import trApp.trDesktopApp.trCustomControl.PatLabel;
import trBusinessLogic.FactoryBL;
import trDataAccess.trDAO.trExoBotDAO;
import trDataAccess.trDTO.trExoBotDTO;
import trInfrastructure.AppException;
import trInfrastructure.AppMSG;
import trInfrastructure.Tools.ExoMunisionHelper;
import trInfrastructure.Tools.ExoTracer;

public class PExoTrooper extends JPanel {
    private static final String[] TR_TIPOS = {"ExoMedico", "ExoAsalto", "ExoExplorador", "ExoInfanteria", "ExoComando"};

    private FactoryBL<trExoBotDTO> trBl = new FactoryBL<>(trExoBotDAO.class);
    private trExoBotDAO trDAO;
    private List<trExoBotDTO> trLista;
    private trExoBotDTO trSeleccionado;

    private PatLabel lblTitulo = new PatLabel("ExoTrooper");
    private PatLabel lblAlumno = new PatLabel("Alumno");
    private PatLabel lblCedula = new PatLabel("Cédula:");
    private PatLabel lblNombres = new PatLabel("Nombres completos:");
    private PatLabel txtCedula = new PatLabel("175129211-9");
    private PatLabel txtNombres = new PatLabel("Robinson Alessandro Tandazo Reyes");
    private JComboBox<String> trComboTipo = new JComboBox<>();
    private PatButton btnAgregar = new PatButton("Agregar");
    private PatButton btnBuscar = new PatButton("Buscar");
    private JPanel trPanelTabla = new JPanel();
    private PatButton btnEntrenarDisparar = new PatButton("Entrenar 'disparar'");
    private PatButton btnDispararLaser = new PatButton("'disparar_Laser'");

    public PExoTrooper() {
        try {
            trDAO = new trExoBotDAO();
            trComboTipo.addItem("Todos");
            for (String t : TR_TIPOS) trComboTipo.addItem(t);
            initComponents();
            trRefreshTable();
        } catch (Exception e) {
            AppMSG.showError("Error al iniciar ExoTrooper: " + e.getMessage());
        }
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        add(lblTitulo, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1;
        add(lblAlumno, gbc);

        gbc.gridy = 2; add(lblCedula, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        add(txtCedula, gbc);
        gbc.gridx = 0; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;

        gbc.gridy = 3; gbc.gridx = 0;
        add(lblNombres, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        add(txtNombres, gbc);
        gbc.gridx = 0; gbc.weightx = 0; gbc.fill = GridBagConstraints.NONE;

        gbc.gridy = 4; gbc.gridx = 0;
        add(new JLabel("TipoExobot:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        add(trComboTipo, gbc);
        gbc.gridx = 2; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0;
        JPanel pnlAb = new JPanel(); pnlAb.add(btnAgregar); pnlAb.add(btnBuscar);
        add(pnlAb, gbc);

        gbc.gridy = 5; gbc.gridx = 0; gbc.gridwidth = 3; gbc.weighty = 1; gbc.fill = GridBagConstraints.BOTH; gbc.ipady = 120; gbc.ipadx = 400;
        trPanelTabla.setLayout(new BorderLayout());
        trPanelTabla.add(new JLabel("Cargando..."), BorderLayout.CENTER);
        add(trPanelTabla, gbc);
        gbc.ipady = 0; gbc.ipadx = 0; gbc.weighty = 0;

        gbc.gridy = 6; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel pnlBtns = new JPanel();
        pnlBtns.add(btnEntrenarDisparar);
        pnlBtns.add(btnDispararLaser);
        add(pnlBtns, gbc);

        btnAgregar.addActionListener(e -> trAgregar());
        btnBuscar.addActionListener(e -> trBuscar());
        btnEntrenarDisparar.addActionListener(e -> trEntrenarDisparar());
        btnDispararLaser.addActionListener(e -> trDispararLaser());
    }

    private void mjBuildTable(List<trExoBotDTO> lista) {
        String[] header = {"IdExobot", "TipoExobot", "Entreno"};
        Object[][] data = new Object[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            trExoBotDTO d = lista.get(i);
            data[i][0] = d.getTrIdExoBot();
            data[i][1] = d.getTrNombre();
            data[i][2] = d.getTrEntreno() != null ? d.getTrEntreno() : "NO";
        }
        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setRowSelectionAllowed(true);
        table.setGridColor(Color.lightGray);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() || lista.isEmpty()) return;
                int i = table.getSelectedRow();
                if (i >= 0 && i < lista.size()) trSeleccionado = lista.get(i);
            }
        });
        trPanelTabla.removeAll();
        trPanelTabla.add(new JScrollPane(table), BorderLayout.CENTER);
        trPanelTabla.revalidate();
        trPanelTabla.repaint();
    }

    private void trRefreshTable() {
        try {
            String sel = (String) trComboTipo.getSelectedItem();
            if (sel == null || "Todos".equals(sel)) trLista = trBl.getAll();
            else trLista = trDAO.trReadByTipoExobot(sel);
            mjBuildTable(trLista);
        } catch (AppException ex) { AppMSG.showError(ex.getMessage()); }
    }

    private void trAgregar() {
        try {
            String tipo = (String) trComboTipo.getSelectedItem();
            if (tipo == null || "Todos".equals(tipo)) { AppMSG.show("Seleccione un TipoExobot para agregar."); return; }
            trExoBotDTO dto = new trExoBotDTO(1, tipo, "Serie-Exo" + (System.currentTimeMillis() % 100000));
            if (!trBl.add(dto)) throw new AppException("No se pudo agregar.", null, getClass(), "trAgregar");
            trComboTipo.setSelectedIndex(0);
            trRefreshTable();
            AppMSG.show("Exobot agregado.");
        } catch (Exception e) { AppMSG.showError(e.getMessage()); }
    }

    private void trBuscar() {
        trRefreshTable();
    }

    private void trEntrenarDisparar() {
        if (trSeleccionado == null) { AppMSG.show("Seleccione una fila en la grilla."); return; }
        String trSoldado = txtNombres.getText().trim().isEmpty() ? "N/A" : txtNombres.getText().trim();
        String[] ta = ExoMunisionHelper.trGetTipoArmaAccion(trSeleccionado.getTrNombre());
        String tipoArma = ta[0], accion = ta[1];
        try {
            trSeleccionado.setTrEntreno("SI");
            if (trBl.upd(trSeleccionado)) ExoTracer.trGood(trSoldado + " " + tipoArma + " " + accion);
            else ExoTracer.trError(trSoldado + " " + tipoArma + " " + accion);
        } catch (Exception e) { ExoTracer.trError(trSoldado + " " + tipoArma + " " + accion); }
        trRefreshTable();
    }

    private void trDispararLaser() {
        if (trSeleccionado == null) { AppMSG.show("Seleccione una fila en la grilla."); return; }
        String[] info = ExoMunisionHelper.trGetForTipoExobot(trSeleccionado.getTrNombre());
        if (info == null) info = new String[]{ ExoMunisionHelper.trGetTipoArmaAccion(trSeleccionado.getTrNombre())[0],
            ExoMunisionHelper.trGetTipoArmaAccion(trSeleccionado.getTrNombre())[1], "?" };
        try {
            Integer n = trSeleccionado.getTrInmovil();
            trSeleccionado.setTrInmovil((n == null ? 0 : n) + 1);
            if (trBl.upd(trSeleccionado)) ExoTracer.trGood(info[0] + " " + info[1] + " " + info[2]);
            else ExoTracer.trError(info[0] + " " + info[1] + " " + info[2]);
        } catch (Exception e) { ExoTracer.trError(info[0] + " " + info[1] + " " + info[2]); }
        trRefreshTable();
    }
}
