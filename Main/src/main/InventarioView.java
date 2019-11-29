/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import main.controlador.ConexionBD;
import com.sun.javafx.image.impl.IntArgb;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Manuel Arreola
 */
public class InventarioView extends javax.swing.JFrame {

    //MODELO DE LA TABLA
    DefaultTableModel dtm= new DefaultTableModel();
    /** Creates new form InventarioView */
    public InventarioView() throws SQLException {
        initComponents();
        String[] tituloTabla = new String[]{"ID","ARTICULO","CANTIDAD","COSTO","IDSUCURSAL","ESTATUS"};
        dtm.setColumnIdentifiers(tituloTabla);
        tableInventario.setModel(dtm);
        cargarData();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idArticuloInventario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombreInventario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidadInventario = new javax.swing.JTextField();
        costoInventario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        idSucursalInventario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        estatusInventario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInventario = new javax.swing.JTable();
        insertarInventario = new javax.swing.JButton();
        actualizarInventario = new javax.swing.JButton();
        eliminarInventario = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");

        jLabel1.setText("idArticulo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Costo");

        costoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoInventarioActionPerformed(evt);
            }
        });

        jLabel5.setText("idSucursal");

        jLabel6.setText("Estatus");

        tableInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableInventario);

        insertarInventario.setText("INSERTAR");
        insertarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarInventarioActionPerformed(evt);
            }
        });

        actualizarInventario.setText("ACTUALIZAR");

        eliminarInventario.setText("ELIMINAR");

        jComboBox1.setModel(jComboBox1.getModel());
        jComboBox1.setSelectedItem("select nombre from Sucursal");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idArticuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantidadInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(costoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(nombreInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(idSucursalInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estatusInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(actualizarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idArticuloInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(idSucursalInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(insertarInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(estatusInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cantidadInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(costoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(actualizarInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarInventario)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void costoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costoInventarioActionPerformed

    private void insertarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarInventarioActionPerformed
        // TODO add your handling code here:
        try{
            Statement stm=ConexionBD.getConnection().createStatement();
            //String sqlQuery = "insert into Inventario values('"+Integer.parseInt(idArticuloInventario.getText())+"','"+ nombreInventario.getText()+"','"+Integer.parseInt(cantidadInventario.getText())+"','"+Float.parseFloat(costoInventario.getText())+"','"+Integer.parseInt(idSucursalInventario.getText())+"','"+estatusInventario.getText()+"')";
            //stm.execute();
            String sqlQuery = "insert into Inventario(articulo,cantidad,costo,idSucursal,estatus) values('"+nombreInventario.getText()+"','"+Integer.parseInt(cantidadInventario.getText())+"','"+Float.parseFloat(costoInventario.getText())+"','"+idSucursalInventario.getText()+"','"+estatusInventario.getText()+"')";
            System.out.println(sqlQuery);
            
            cargarData();
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }//GEN-LAST:event_insertarInventarioActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        try{
            Statement stm=ConexionBD.getConnection().createStatement();
            ResultSet rst = stm.executeQuery("SELECT nombre FROM Sucursal");
            //stm.execute("SELECT nombre FROM Sucursal");
            jComboBox1.addItem("Seleccione sucursal");
            cargarDataCombo();
            while(rst.next()){
                jComboBox1.addItem(rst.getString("nombre"));
            }
            //Llenar combobox
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InventarioView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InventarioView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarInventario;
    private javax.swing.JTextField cantidadInventario;
    private javax.swing.JTextField costoInventario;
    private javax.swing.JButton eliminarInventario;
    private javax.swing.JTextField estatusInventario;
    private javax.swing.JTextField idArticuloInventario;
    private javax.swing.JTextField idSucursalInventario;
    private javax.swing.JButton insertarInventario;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreInventario;
    private javax.swing.JTable tableInventario;
    // End of variables declaration//GEN-END:variables

    private void cargarData() throws SQLException {
        
        Statement stm = new ConexionBD().getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select * from Inventario");
        limpiarBuffer();
        
        while (rst.next()) {
            dtm.addRow(new Object[]{
                rst.getInt(1),
                rst.getString(2),
                rst.getInt(3),
                rst.getFloat(4),
                rst.getInt(5),
                rst.getString(6)
            });
        }
    }
    
    private void limpiarBuffer() {
        int filas = dtm.getRowCount();
        for (int i = 0; i < filas; i++) {
            dtm.removeRow(0);
        }
    }
    
    private void cargarDataCombo() throws SQLException{
         Statement stm = new ConexionBD().getConnection().createStatement();
         ResultSet rst = stm.executeQuery("SELECT * FROM Sucursal");
         
         while (rst.next()) {
            dtm.addRow(new Object[]{
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
            });
        }
    }

}
