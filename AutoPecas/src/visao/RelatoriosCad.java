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
public class RelatoriosCad extends javax.swing.JFrame {

    /**
     * Creates new form CadPecas
     */
    public RelatoriosCad() {
        initComponents();
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
        jlTitulo = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jbGerar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jCBTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(99, 113, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlTitulo.setText("Relatórios");
        jPanel1.add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jlNome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlNome.setText("Relação de:");
        jPanel1.add(jlNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jbGerar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbGerar.setText("Gerar relatório");
        jbGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerarActionPerformed(evt);
            }
        });
        jPanel1.add(jbGerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jCBTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 190, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarActionPerformed
        JFileChooser escolheDiretorio = new JFileChooser();              
        escolheDiretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int i = escolheDiretorio.showSaveDialog(null);           
        String caminho = escolheDiretorio.getSelectedFile().getAbsolutePath();           
        caminho = caminho.replace("\\", "/");
            
            
        if(jCBTipo.getSelectedItem().toString().equals("Clientes")){
            try {
                Document relatorio = new Document();

                FileOutputStream arquivoPDF = new FileOutputStream(caminho+"/"+"relatorioCadastroCliente"+".pdf");

                PdfWriter escritor = PdfWriter.getInstance(relatorio, arquivoPDF);

                relatorio.open();

                relatorio.setPageSize(PageSize.A4);

                Font fonteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

                Paragraph titulo = new Paragraph("Cadastro Realizado", fonteTitulo);

                titulo.setAlignment(Element.ALIGN_CENTER);

                relatorio.add(titulo);
                
                relatorio.add(new Paragraph("\n\n"));

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas", "root", "");

                String sql = "SELECT * from cliente";

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet resultado = stmt.executeQuery();

                PdfPTable tabela = new PdfPTable(5);

                tabela.addCell("Código");
                tabela.addCell("Nome");
                tabela.addCell("Endereço");
                tabela.addCell("CPF");
                tabela.addCell("Telefone");

                while(resultado.next()){
                    tabela.addCell(resultado.getString("idcliente"));
                    tabela.addCell(resultado.getString("nomeCliente"));
                    tabela.addCell(resultado.getString("endCliente"));
                    tabela.addCell(resultado.getString("cpfCliente"));
                    tabela.addCell(resultado.getString("telefoneCliente"));
                }

                relatorio.add(tabela);            

                conn.close();
                stmt.close();
                relatorio.close();

                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                Desktop.getDesktop().open(new File(caminho+"/"+"relatorioCadastroCliente"+".pdf"));

            } catch (DocumentException docEx) {
                JOptionPane.showMessageDialog(null, "Erro no relatório!"+docEx);
            } catch (IOException ioEx){
                JOptionPane.showMessageDialog(null, "Erro de IO:"+ioEx);
            } catch (SQLException sqlEx){
                JOptionPane.showMessageDialog(null, "Erro de SQL:"+sqlEx);
            } catch (ClassNotFoundException cEx){
                JOptionPane.showMessageDialog(null, "Classe Driver não econtrada!");
            }
        }else if(jCBTipo.getSelectedItem().toString().equals("Fornecedores")){
            try {
                Document relatorio = new Document();

                FileOutputStream arquivoPDF = new FileOutputStream(caminho+"/"+"relatorioCadastroFornecedor"+".pdf");

                PdfWriter escritor = PdfWriter.getInstance(relatorio, arquivoPDF);

                relatorio.open();

                relatorio.setPageSize(PageSize.A4);

                Font fonteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

                Paragraph titulo = new Paragraph("Cadastro Realizado", fonteTitulo);

                titulo.setAlignment(Element.ALIGN_CENTER);

                relatorio.add(titulo);
                
                relatorio.add(new Paragraph("\n\n"));

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas", "root", "");

                String sql = "SELECT * from fornecedor";

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet resultado = stmt.executeQuery();

                PdfPTable tabela = new PdfPTable(4);

                tabela.addCell("Código");
                tabela.addCell("Nome");
                tabela.addCell("Telefone");
                tabela.addCell("E-mail");

                while(resultado.next()){
                    tabela.addCell(resultado.getString("idfornecedor"));
                    tabela.addCell(resultado.getString("nomeFornecedor"));
                    tabela.addCell(resultado.getString("telefoneFornecedor"));
                    tabela.addCell(resultado.getString("emailFornecedor"));
                }

                relatorio.add(tabela);            

                conn.close();
                stmt.close();
                relatorio.close();

                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                Desktop.getDesktop().open(new File(caminho+"/"+"relatorioCadastroFornecedor"+".pdf"));

            } catch (DocumentException docEx) {
                JOptionPane.showMessageDialog(null, "Erro no relatório!"+docEx);
            } catch (IOException ioEx){
                JOptionPane.showMessageDialog(null, "Erro de IO:"+ioEx);
            } catch (SQLException sqlEx){
                JOptionPane.showMessageDialog(null, "Erro de SQL:"+sqlEx);
            } catch (ClassNotFoundException cEx){
                JOptionPane.showMessageDialog(null, "Classe Driver não econtrada!");
            }
        }else if(jCBTipo.getSelectedItem().toString().equals("Funcionarios")){
            try {
                Document relatorio = new Document();

                FileOutputStream arquivoPDF = new FileOutputStream(caminho+"/"+"relatorioCadastroFuncionario"+".pdf");

                PdfWriter escritor = PdfWriter.getInstance(relatorio, arquivoPDF);

                relatorio.open();

                relatorio.setPageSize(PageSize.A4);

                Font fonteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

                Paragraph titulo = new Paragraph("Cadastro Realizado", fonteTitulo);

                titulo.setAlignment(Element.ALIGN_CENTER);

                relatorio.add(titulo);
                
                relatorio.add(new Paragraph("\n\n"));

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas", "root", "");

                String sql = "SELECT * from funcionario";

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet resultado = stmt.executeQuery();

                PdfPTable tabela = new PdfPTable(8);

                tabela.addCell("Código");
                tabela.addCell("Nome");
                tabela.addCell("Endereço");
                tabela.addCell("CPF");
                tabela.addCell("Telefone");
                tabela.addCell("Salário");
                tabela.addCell("Data");
                tabela.addCell("E-mail");

                while(resultado.next()){
                    tabela.addCell(resultado.getString("idfuncionario"));
                    tabela.addCell(resultado.getString("nomeFuncionario"));
                    tabela.addCell(resultado.getString("endFuncionario"));
                    tabela.addCell(resultado.getString("cpfFuncionario"));
                    tabela.addCell(resultado.getString("telefoneFuncionario"));
                    tabela.addCell(resultado.getString("salarioFuncionario"));
                    tabela.addCell(resultado.getString("dataFuncionario"));
                    tabela.addCell(resultado.getString("emailFuncionario"));
                }

                relatorio.add(tabela);            

                conn.close();
                stmt.close();
                relatorio.close();

                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                Desktop.getDesktop().open(new File(caminho+"/"+"relatorioCadastroFuncionario"+".pdf"));

            } catch (DocumentException docEx) {
                JOptionPane.showMessageDialog(null, "Erro no relatório!"+docEx);
            } catch (IOException ioEx){
                JOptionPane.showMessageDialog(null, "Erro de IO:"+ioEx);
            } catch (SQLException sqlEx){
                JOptionPane.showMessageDialog(null, "Erro de SQL:"+sqlEx);
            } catch (ClassNotFoundException cEx){
                JOptionPane.showMessageDialog(null, "Classe Driver não econtrada!");
            }
        }else{
            try {
                Document relatorio = new Document();

                FileOutputStream arquivoPDF = new FileOutputStream(caminho+"/"+"relatorioCadastroPecas"+".pdf");

                PdfWriter escritor = PdfWriter.getInstance(relatorio, arquivoPDF);

                relatorio.open();

                relatorio.setPageSize(PageSize.A4);

                Font fonteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

                Paragraph titulo = new Paragraph("Cadastro Realizado", fonteTitulo);

                titulo.setAlignment(Element.ALIGN_CENTER);

                relatorio.add(titulo);
                
                relatorio.add(new Paragraph("\n\n"));

                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbautopecas", "root", "");

                String sql = "SELECT * from pecas";

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet resultado = stmt.executeQuery();

                PdfPTable tabela = new PdfPTable(6);

                tabela.addCell("Código");
                tabela.addCell("Nome");
                tabela.addCell("Preço");
                tabela.addCell("Quantidade");
                tabela.addCell("Descrição");
                tabela.addCell("Fornecedor");

                while(resultado.next()){
                    tabela.addCell(resultado.getString("idpecas"));
                    tabela.addCell(resultado.getString("nomePeca"));
                    tabela.addCell(resultado.getString("precoPeca"));
                    tabela.addCell(resultado.getString("qtdeEstoque"));
                    tabela.addCell(resultado.getString("descricao"));
                    tabela.addCell(resultado.getString("fornecedor_idfornecedor"));
                }

                relatorio.add(tabela);            

                conn.close();
                stmt.close();
                relatorio.close();

                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                Desktop.getDesktop().open(new File(caminho+"/"+"relatorioCadastroPecas"+".pdf"));

            } catch (DocumentException docEx) {
                JOptionPane.showMessageDialog(null, "Erro no relatório!"+docEx);
            } catch (IOException ioEx){
                JOptionPane.showMessageDialog(null, "Erro de IO:"+ioEx);
            } catch (SQLException sqlEx){
                JOptionPane.showMessageDialog(null, "Erro de SQL:"+sqlEx);
            } catch (ClassNotFoundException cEx){
                JOptionPane.showMessageDialog(null, "Classe Driver não econtrada!");
            }
        }
        this.dispose();
    }//GEN-LAST:event_jbGerarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBTipoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                jCBTipo.addItem("Clientes");
                jCBTipo.addItem("Fornecedores");
                jCBTipo.addItem("Funcionarios");
                jCBTipo.addItem("Pecas");
    }//GEN-LAST:event_formWindowOpened

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jbGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarRelatorioActionPerformed
           
    }//GEN-LAST:event_jbGerarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(RelatoriosCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosCad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCBTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGerar;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlTitulo;
    // End of variables declaration//GEN-END:variables
}
