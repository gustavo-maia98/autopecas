/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author 13151000014
 */
public class CadPecas extends javax.swing.JFrame {

    /**
     * Creates new form CadPecas
     */
    public CadPecas() {
        initComponents();
    }
    
    public CadPecas(String nome, String preco, String qtdeEstoque, String descricao, String codFornecedor) {
        initComponents();
        this.jtfNome.setText(nome);
        this.jtfPreco.setText(preco);
        this.jtfQtdeEstoque.setText(qtdeEstoque);
        this.jTextArea1.setText(descricao);
        this.jTFCodFornecedor.setText(codFornecedor);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlCadastroPecas = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlPreco = new javax.swing.JLabel();
        jlFornecedor = new javax.swing.JLabel();
        jlDescricao = new javax.swing.JLabel();
        jtfPreco = new javax.swing.JTextField();
        jtfQtdeEstoque = new javax.swing.JTextField();
        jspDescricao = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jbCadastrar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jlQtdeEstoque = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jCBFornecedor = new javax.swing.JComboBox();
        jTFCodFornecedor = new javax.swing.JTextField();
        jlCodFornecedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(99, 113, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlCadastroPecas.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlCadastroPecas.setText("Cadastro de Peças");
        jPanel1.add(jlCadastroPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jlNome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlNome.setText("Nome:");
        jPanel1.add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jlPreco.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlPreco.setText("Preço:");
        jPanel1.add(jlPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jlFornecedor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlFornecedor.setText("Fornecedores:");
        jPanel1.add(jlFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jlDescricao.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlDescricao.setText("Descrição:");
        jPanel1.add(jlDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        jPanel1.add(jtfPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 200, -1));
        jPanel1.add(jtfQtdeEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jspDescricao.setViewportView(jTextArea1);

        jPanel1.add(jspDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, 70));

        jbCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        jlQtdeEstoque.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlQtdeEstoque.setText("Qtd. em Estoque: ");
        jPanel1.add(jlQtdeEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jPanel1.add(jtfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, -1));

        jCBFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(jCBFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 190, -1));
        jPanel1.add(jTFCodFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 50, -1));

        jlCodFornecedor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlCodFornecedor.setText("Codigo do Fornecedor:");
        jPanel1.add(jlCodFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        if(FramePrincipal.CodAlterar!=0){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn;
                conn = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas", "root", "");               
                String query = "UPDATE pecas SET nomePeca = ?, precoPeca = ?, qtdeEstoque = ?, descricao = ?, fornecedor_idfornecedor = ? WHERE idpecas = ?";
                PreparedStatement comando = conn.prepareStatement(query);
                comando.setString(1 , jtfNome.getText());
                comando.setString(2 , jtfPreco.getText());
                comando.setString(3, jtfQtdeEstoque.getText());
                comando.setString(4, jTextArea1.getText());
                comando.setString(5, jTFCodFornecedor.getText());
                
                
                comando.setInt(6 , FramePrincipal.CodAlterar);

                comando.executeUpdate();
                
                comando.close();
                conn.close();
                
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
                jtfNome.setText("");
                jtfPreco.setText("");
                jtfQtdeEstoque.setText("");
                jTextArea1.setText("");
                jTFCodFornecedor.setText("");
                
            }catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "Não foi possível encontrar a classe Driver!");
            } catch (SQLException ex2) {
             JOptionPane.showMessageDialog(null, "Ocorreu um erro interno de SQL!"+ex2);
            }
            FramePrincipal.CodAlterar = 0;
        }else{
            try{

                Class.forName("com.mysql.jdbc.Driver"); 

                Connection conexao;

                conexao = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas","root","");

                String comando = "INSERT into pecas (nomePeca, precoPeca, qtdeEstoque, descricao, fornecedor_idfornecedor) VALUES (?,?,?,?,?)";

                java.sql.PreparedStatement stmt = conexao.prepareStatement(comando);

                stmt.setString(1, jtfNome.getText());
                stmt.setString(2, jtfPreco.getText());
                stmt.setString(3, jtfQtdeEstoque.getText());
                stmt.setString(4, jTextArea1.getText());
                stmt.setString(5, jTFCodFornecedor.getText());

                stmt.executeUpdate();

                stmt.close();
                conexao.close();

                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                jtfNome.setText("");
                jtfPreco.setText("");
                jtfQtdeEstoque.setText("");
                jTextArea1.setText("");            

            }
            catch(ClassNotFoundException exClass){
                JOptionPane.showMessageDialog(null, "A classe Driver não foi encontrada!"+exClass);
            }catch(SQLException exSQL){
                JOptionPane.showMessageDialog(null, "Erro de SQL!"+exSQL);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jCBFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBFornecedorActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            
            Connection conexao;
       
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas","root","");
            
            String buscaFornecedores = "SELECT nomeFornecedor, idfornecedor from fornecedor";
            
            PreparedStatement stmt = conexao.prepareStatement(buscaFornecedores);
            
        
            ResultSet resultadoConsulta = stmt.executeQuery();
            
            while(resultadoConsulta.next()){
                jCBFornecedor.addItem(resultadoConsulta.getString("idfornecedor")+" - "+resultadoConsulta.getString("nomeFornecedor"));
            }
            
        
        }catch(ClassNotFoundException exClass){
            JOptionPane.showMessageDialog(null, "A classe Driver não foi encontrada!"+exClass);
        }catch(SQLException exSQL){
            JOptionPane.showMessageDialog(null, "Erro de SQL!"+exSQL);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

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
            java.util.logging.Logger.getLogger(CadPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPecas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCBFornecedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFCodFornecedor;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlCadastroPecas;
    private javax.swing.JLabel jlCodFornecedor;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlFornecedor;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPreco;
    private javax.swing.JLabel jlQtdeEstoque;
    private javax.swing.JScrollPane jspDescricao;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JTextField jtfQtdeEstoque;
    // End of variables declaration//GEN-END:variables
}
