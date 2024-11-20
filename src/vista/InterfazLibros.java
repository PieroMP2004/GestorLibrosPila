import javax.swing.table.DefaultTableModel;

public class InterfazLibros extends javax.swing.JFrame {
    private PilaLibros pilaLibros;
    private DefaultTableModel modelo;

    public InterfazLibros() {
        initComponents();
        pilaLibros = new PilaLibros();
        configurarTabla();
    }

    private void configurarTabla() {
        String[] columnas = {"Código", "Título", "Autor", "Precio"};
        modelo = new DefaultTableModel(columnas, 0);
        tablaLibros.setModel(modelo);
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtPrecio.setText("");
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (Libro libro : pilaLibros.obtenerLibros()) {
            Object[] fila = {
                libro.getCodigo(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getPrecio()
            };
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Componentes Swing
        // (Código generado por NetBeans Form Designer)
    }

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            Libro nuevoLibro = new Libro(codigo, titulo, autor, precio);
            pilaLibros.insertar(nuevoLibro);
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Datos inválidos");
        }
    }                                           

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            Libro libro = pilaLibros.buscarPorCodigo(codigo);
            
            if (libro != null) {
                txtTitulo.setText(libro.getTitulo());
                txtAutor.setText(libro.getAutor());
                txtPrecio.setText(String.valueOf(libro.getPrecio()));
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Libro no encontrado");
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Código inválido");
        }
    }                                         

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            boolean eliminado = pilaLibros.eliminarPorCodigo(codigo);
            
            if (eliminado) {
                actualizarTabla();
                limpiarCampos();
                javax.swing.JOptionPane.showMessageDialog(this, "Libro eliminado");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Libro no encontrado");
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Código inválido");
        }
    }                                           

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        pilaLibros.ordenarPorAutorDescendente();
        actualizarTabla();
    }                                          

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        actualizarTabla();
    }                                          

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazLibros().setVisible(true);
            }
        });
    }
}
