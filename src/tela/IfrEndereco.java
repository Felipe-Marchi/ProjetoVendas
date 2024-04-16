package tela;

import apoio.Formatacao;
import apoio.Validar;
import dao.EnderecoDAO;
import entidade.Endereco;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author felip
 */
public class IfrEndereco extends javax.swing.JInternalFrame {

    int idEndereco = 0;

    Border erro = BorderFactory.createEtchedBorder(Color.red, Color.red);
    Border normal = BorderFactory.createEtchedBorder(null, null);

    /**
     * Creates new form IfrEndereco
     */
    public IfrEndereco() {
        initComponents();
        setTitle("Endereços");

        new EnderecoDAO().popularTabela(tblEndereco, "");

        Formatacao.formatarCep(tffCepEndereco);

        this.getContentPane().setBackground(new Color(245, 255, 250));
        jPanel1.setBackground(new Color(240, 248, 255));
        jPanel2.setBackground(new Color(240, 248, 255));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEndereco = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tfdPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdDescricaoEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tffCepEndereco = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        btnFechar.setText("Fechar");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFecharMouseExited(evt);
            }
        });
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tblEndereco.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblEndereco);

        jLabel3.setText("Busca");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfdPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jLabel1.setText("Descrição:");

        tfdDescricaoEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfdDescricaoEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdDescricaoEnderecoFocusLost(evt);
            }
        });

        jLabel2.setText("CEP:");

        tffCepEndereco.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tffCepEndereco.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tffCepEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tffCepEnderecoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdDescricaoEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(tffCepEndereco))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDescricaoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tffCepEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 122, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String descricaoEndereco = tfdDescricaoEndereco.getText();
        String cepEndereco = tffCepEndereco.getText();

        if (!Validar.validarDescricao(descricaoEndereco)) {
            JOptionPane.showMessageDialog(this, "Descrição inválida!");
            return; // Sai do método sem salvar
        }

        if (!Validar.validarCep(cepEndereco)) {
            JOptionPane.showMessageDialog(this, "CEP inválido!");
            return; // Sai do método sem salvar
        }

        Endereco endereco = new Endereco();
        endereco.setId(idEndereco);
        endereco.setDescricao(descricaoEndereco);
        endereco.setCep(cepEndereco);

        EnderecoDAO enderecoDao = new EnderecoDAO();

        if (idEndereco == 0) {
            if (enderecoDao.salvar(endereco) == null) {
                tfdDescricaoEndereco.setText("");
                tffCepEndereco.setText("");

                JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
                new EnderecoDAO().popularTabela(tblEndereco, "");

                tfdDescricaoEndereco.requestFocus();

            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar registro!");
            }
        } else {
            if (enderecoDao.atualizar(endereco) == null) {
                tfdDescricaoEndereco.setText("");
                tffCepEndereco.setText("");

                JOptionPane.showMessageDialog(this, "Registro editado com sucesso!");
                new EnderecoDAO().popularTabela(tblEndereco, "");

                tfdDescricaoEndereco.requestFocus();

            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao editar registro!");
            }
        }

        idEndereco = 0;
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new EnderecoDAO().popularTabela(tblEndereco, tfdPesquisar.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idTabela = String.valueOf(tblEndereco.getValueAt(tblEndereco.getSelectedRow(), 0));

        idEndereco = Integer.parseInt(idTabela);

        Endereco endereco = new EnderecoDAO().consultarId(idEndereco);

        if (endereco != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdDescricaoEndereco.setText(endereco.getDescricao());
            tffCepEndereco.setText(endereco.getCep());

            tfdDescricaoEndereco.requestFocus();

        } else {
            JOptionPane.showMessageDialog(this, "Id do endereço não encontrado! ");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idTabela = String.valueOf(tblEndereco.getValueAt(tblEndereco.getSelectedRow(), 0));

        idEndereco = Integer.parseInt(idTabela);

        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro selecionado?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Caso o usuário confirme a exclusão
            if (new EnderecoDAO().excluir(idEndereco) == null) {
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");

                new EnderecoDAO().popularTabela(tblEndereco, "");
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
            }
        }

        idEndereco = 0;
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseEntered
        btnFechar.setBackground(new Color(255, 100, 100));
    }//GEN-LAST:event_btnFecharMouseEntered

    private void btnFecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseExited
        Color corPadrao = UIManager.getColor("Button.background");
        btnFechar.setBackground(corPadrao);
    }//GEN-LAST:event_btnFecharMouseExited

    private void tffCepEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tffCepEnderecoFocusLost

        if (!Validar.validarCep(tffCepEndereco.getText())) {
            tffCepEndereco.setBorder(erro);
        } else {
            tffCepEndereco.setBorder(normal);
        }
    }//GEN-LAST:event_tffCepEnderecoFocusLost

    private void tfdDescricaoEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdDescricaoEnderecoFocusLost

        if (!Validar.validarDescricao(tfdDescricaoEndereco.getText())) {
            tfdDescricaoEndereco.setBorder(erro);
        } else {
            tfdDescricaoEndereco.setBorder(normal);
        }
    }//GEN-LAST:event_tfdDescricaoEnderecoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEndereco;
    private javax.swing.JTextField tfdDescricaoEndereco;
    private javax.swing.JTextField tfdPesquisar;
    private javax.swing.JFormattedTextField tffCepEndereco;
    // End of variables declaration//GEN-END:variables
}
