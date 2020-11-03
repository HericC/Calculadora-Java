package View;

import calculadora.ControllerHistoric;
import calculadora.ModelHistoric;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Heric
 */
public final class ListHistoric extends javax.swing.JFrame {
    private final ControllerHistoric controllerHistoric;
    private ModelHistoric[] listHistoric;

    /**
     * Creates new form ListHistoric
     */
    public ListHistoric() {
        initComponents();
        this.controllerHistoric = ControllerHistoric.getInstance();
        this.update();
    }
    
    public void update() {
        this.listHistoric = this.controllerHistoric.getListInstance();
        
        DefaultListModel model = new DefaultListModel();
        
        if (this.listHistoric != null && this.listHistoric.length != 0) {
            for (ModelHistoric historic : this.listHistoric) {
                model.addElement(
                        historic.getExpression()
                        + " = "
                        + historic.getResult()
                );
            }
        } else {
            model.addElement("Histórico Vazio!");
        }
        this.jList1.setModel(model);
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
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        generateFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        clearHistoric = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico");
        setPreferredSize(new java.awt.Dimension(278, 412));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 400));

        jList1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jList1.setEnabled(false);
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);

        jMenuBar1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jMenu2.setText("File");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        generateFile.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        generateFile.setText("Gerar Arquivo");
        generateFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generateFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateFileActionPerformed(evt);
            }
        });
        jMenu2.add(generateFile);
        jMenu2.add(jSeparator1);

        clearHistoric.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        clearHistoric.setText("Limpar Histórico");
        clearHistoric.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearHistoric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHistoricActionPerformed(evt);
            }
        });
        jMenu2.add(clearHistoric);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearHistoricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearHistoricActionPerformed
        // TODO add your handling code here:
        this.controllerHistoric.truncate();
        this.update();
    }//GEN-LAST:event_clearHistoricActionPerformed

    private void generateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateFileActionPerformed
        // TODO add your handling code here:
        String str = "";
        
        if (this.listHistoric != null && this.listHistoric.length != 0) {
            for (ModelHistoric historic : this.listHistoric) {
                str += historic.getExpression() + " = " + historic.getResult() + "\n";
            }
        } else {
            str = "Histórico Vazio!";
        }
        
        try {
            File file = new File("Histórico.txt");
            
            if (!file.exists()) file.createNewFile();
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(str);
                JOptionPane.showMessageDialog(null, "Histórico Gerado com Sucesso!", "Sucesso!", 1);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falhar ao Gerado o Histórico!", "Sucesso!", 0);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_generateFileActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListHistoric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListHistoric().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clearHistoric;
    private javax.swing.JMenuItem generateFile;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}