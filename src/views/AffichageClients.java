/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DataAccesObject.ClientDAO;
import control.ClientTableModel;
import javax.swing.JOptionPane;
import model.Client;

/**
 *
 * @author lenovo
 */
public class AffichageClients extends javax.swing.JPanel {

    /**
     * Creates new form AffichageClients
     */
    public AffichageClients() {
        initComponents();
        jTable1.setModel(new ClientTableModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modifier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 int column = 0;
int row = jTable1.getSelectedRow();
String value = jTable1.getModel().getValueAt(row, column++).toString();
new ClientDAO().deleteClient(Integer.parseInt(value));
jTable1.notify();
JOptionPane d = new JOptionPane();
d.showMessageDialog( null, "Client Supprimer", 
      "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try{
    int cmt=0;
int row = jTable1.getSelectedRow();
String id = jTable1.getModel().getValueAt(row, cmt++).toString();
String nom = jTable1.getModel().getValueAt(row, cmt++).toString();
String prenom = jTable1.getModel().getValueAt(row, cmt++).toString();
String email = jTable1.getModel().getValueAt(row, cmt++).toString();
String tel = jTable1.getModel().getValueAt(row, cmt++).toString();
String nvnom = JOptionPane.showInputDialog("Entrer le noveau nom");
String nvprenom = JOptionPane.showInputDialog("Entrer le noveau prenom");
String nvemail = JOptionPane.showInputDialog("Entrer le noveau email");
String nvtel = JOptionPane.showInputDialog("Entrer le noveau num tel");
    //System.err.println(nvnom);
  //  System.err.println(nvtel);
if(nvnom==null){nvnom=nom;}
if(nvprenom==null){nvprenom=prenom;}
if(nvemail==null){nvemail=email;}
if(nvtel==null){nvtel=tel;}

Client c = new Client(Integer.parseInt(id),nvnom,nvprenom,nvemail,Integer.parseInt(nvtel));
new ClientDAO().updateClient(c,Integer.parseInt(id));
jTable1.notify();
JOptionPane.showMessageDialog(null, "Modification effectuer");
    }catch(Exception e){
        System.err.println(e);
    }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}