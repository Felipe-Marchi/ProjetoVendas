package tela;

import apoio.Formatacao;
import apoio.IItemPesquisa;
import apoio.Validar;
import dao.ItemPedidoDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import entidade.ItemPedido;
import entidade.Pedido;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author felip
 */
public class IfrPedido extends javax.swing.JInternalFrame implements IItemPesquisa {

    int idPedido = 0;
    double total = 0.0;

    Border erro = BorderFactory.createEtchedBorder(Color.red, Color.red);
    Border normal = BorderFactory.createEtchedBorder(null, null);

    /**
     * Creates new form IfrPedido
     */
    public IfrPedido() {
        initComponents();

        setTitle("Pedidos");

        this.getContentPane().setBackground(new Color(245, 255, 250));
        jPanel1.setBackground(new Color(240, 248, 255));
        jPanel2.setBackground(new Color(240, 248, 255));

        new PedidoDAO().popularTabela(tblPedido);
        new ItemPedidoDAO().popularTabela(tblItemPedido);

        Formatacao.formatarData(tffDataInicio);
        Formatacao.formatarData(tffDataFim);
        Formatacao.formatarData(tffDataPedido);
        tffDataPedido.setText(Formatacao.obterDataAtual());

        Formatacao.formatarValor(tffQtde);

        tfdIdCliente.setEditable(false);
        tfdNomeCliente.setEditable(false);
        tfdIdProduto.setEditable(false);
        tfdProduto.setEditable(false);
        tffQtde.setEditable(false);
        tfdValor.setEditable(false);
        tfdTotal.setEditable(false);

        btnLocalizarProduto.setEnabled(false);
        btnRemover.setEnabled(false);
        btnInserir.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tffDataInicio = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tffDataFim = new javax.swing.JFormattedTextField();
        btnPesquisar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdIdCliente = new javax.swing.JTextField();
        tffDataPedido = new javax.swing.JFormattedTextField();
        btnLocalizarCliente = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tffQtde = new javax.swing.JFormattedTextField();
        tfdIdProduto = new javax.swing.JTextField();
        tfdProduto = new javax.swing.JTextField();
        btnLocalizarProduto = new javax.swing.JButton();
        tfdValor = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemPedido = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tfdTotal = new javax.swing.JTextField();
        tfdNomeCliente = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        jLabel1.setText("Data início:");

        tffDataInicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tffDataInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel2.setText("Data fim:");

        tffDataFim.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tffDataFim.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPedido);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tffDataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tffDataFim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tffDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tffDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jLabel3.setText("Data:");

        jLabel4.setText("Cliente:");

        tfdIdCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tffDataPedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tffDataPedido.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        btnLocalizarCliente.setText("Localizar");
        btnLocalizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarClienteActionPerformed(evt);
            }
        });

        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        jLabel5.setText("Produto:");

        jLabel6.setText("Quantidade:");

        tffQtde.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tffQtde.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        tfdIdProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfdProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLocalizarProduto.setText("Localizar");
        btnLocalizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarProdutoActionPerformed(evt);
            }
        });

        tfdValor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblItemPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblItemPedido);

        jLabel7.setText("TOTAL:");

        tfdTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfdNomeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tffDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfdIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdNomeCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLocalizarCliente)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFinalizar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tffQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfdIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdProduto)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnRemover)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfdValor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLocalizarProduto)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tffDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarCliente)
                    .addComponent(tfdNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCriar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tffQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserir)
                    .addComponent(btnRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLocalizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarClienteActionPerformed
        new DlgLocalizar(null, true, this, "cliente").setVisible(true);
    }//GEN-LAST:event_btnLocalizarClienteActionPerformed

    private void btnLocalizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarProdutoActionPerformed
        new DlgLocalizar(null, true, this, "produto").setVisible(true);
    }//GEN-LAST:event_btnLocalizarProdutoActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        if (!Validar.validarData(tffDataPedido.getText())) {
            JOptionPane.showMessageDialog(this, "Data inválida!");
            tffDataPedido.setBorder(erro);
            return;
        } else {
            tffDataPedido.setBorder(normal);
        }

        if (tfdNomeCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha um cliente!");
            return;
        }

        Pedido pedido = new Pedido();

        total = 0.0;
        
        pedido.setDataPedido(tffDataPedido.getText());
        pedido.setClienteId(Integer.parseInt(tfdIdCliente.getText()));

        String retorno = new PedidoDAO().salvar(pedido);

        System.out.println("Id Pedido retorno: " + retorno);

        if (!retorno.contains("ERRO")) {
            idPedido = Integer.parseInt(retorno);

            btnCriar.setEnabled(false);
            btnLocalizarCliente.setEnabled(false);
            btnLocalizarProduto.setEnabled(true);
            btnRemover.setEnabled(true);
            btnInserir.setEnabled(true);
            tffQtde.setEditable(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao criar Pedido: " + retorno);
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (!Validar.validarNumero(tffQtde.getText())) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida");
            return;
        }

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setQtde(tffQtde.getText());
        itemPedido.setValor(tfdValor.getText());
        itemPedido.setPedidoId(idPedido);
        itemPedido.setProdutoId(Integer.parseInt(tfdIdProduto.getText()));

        // Verificar se a quantidade é maior que o estoque atual
        ProdutoDAO produtoDAO = new ProdutoDAO();
        int estoqueAtual = produtoDAO.obterEstoque(itemPedido.getProdutoId());

        if (Double.parseDouble(itemPedido.getQtde()) > estoqueAtual) {
            JOptionPane.showMessageDialog(this, "Quantidade insuficiente em estoque.");
            return; // Retorna sem executar o restante do código
        }

        if (new ItemPedidoDAO().salvar(itemPedido) == null) {
            JOptionPane.showMessageDialog(this, "Venda inserida.");

            new ItemPedidoDAO().popularTabela(tblItemPedido, "", idPedido);

            total += (Double.parseDouble(itemPedido.getValor()) * Double.parseDouble(itemPedido.getQtde()));

            tfdTotal.setText(Formatacao.formatarDecimal(total));

            tfdIdProduto.setText("");
            tfdProduto.setText("");
            tfdValor.setText("");
            tffQtde.setText("");

            // Atualizar a quantidade do produto vendido
            produtoDAO.atualizarQuantidade(itemPedido.getProdutoId(), Double.parseDouble(itemPedido.getQtde()));
        } else {
            JOptionPane.showMessageDialog(null, "Erro na inserção.");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblItemPedido.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro.");
        } else {
            //Atualizar a quantidade do produto no estoque
            int idProd = Integer.parseInt(String.valueOf(tblItemPedido.getValueAt(tblItemPedido.getSelectedRow(), 1)));
            int qtdeProd = Integer.parseInt(String.valueOf(tblItemPedido.getValueAt(tblItemPedido.getSelectedRow(), 3)));
            
            ProdutoDAO produtoDao = new ProdutoDAO();
            int estoqueAtual = produtoDao.obterEstoque(idProd);
            int estoqueNovo = estoqueAtual + qtdeProd;
            produtoDao.atualizarQuantidade(idProd, estoqueAtual - estoqueNovo);
            
            //excluir item do pedido
            int idPIt = Integer.parseInt(String.valueOf(tblItemPedido.getValueAt(tblItemPedido.getSelectedRow(), 0)));
            System.out.println("Pedido Item: " + idPIt);

            String retorno = new ItemPedidoDAO().excluir(idPIt);

            if (retorno == null) {
                JOptionPane.showMessageDialog(this, "Registro removido.");
                
                //atualizar valor total do pedido
                double qtde = Double.parseDouble(String.valueOf(tblItemPedido.getValueAt(tblItemPedido.getSelectedRow(), 3)));
                double valor = Double.parseDouble(String.valueOf(tblItemPedido.getValueAt(tblItemPedido.getSelectedRow(), 4)));

                total -= (qtde * valor);

                tfdTotal.setText(Formatacao.formatarDecimal(total));

                new ItemPedidoDAO().popularTabela(tblItemPedido, "", idPedido);

            } else {
                JOptionPane.showMessageDialog(null, "Erro: Problemas ao remover registro.\n\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        new ItemPedidoDAO().popularTabela(tblItemPedido);

        tffDataPedido.setText(Formatacao.obterDataAtual());

        tfdIdCliente.setText("");
        tfdNomeCliente.setText("");

        tfdTotal.setText("");

        btnLocalizarCliente.setEnabled(true);
        btnCriar.setEnabled(true);

        btnLocalizarProduto.setEnabled(false);
        btnRemover.setEnabled(false);
        btnInserir.setEnabled(false);
        tffQtde.setEditable(false);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String dataInicio = tffDataInicio.getText();
        String dataFim = tffDataFim.getText();

        if (dataInicio.equals("  /  /    ") && dataFim.equals("  /  /    ")) {
            new PedidoDAO().popularTabela(tblPedido);
            return;
        }

        if (!Validar.validarData(dataInicio)) {
            JOptionPane.showMessageDialog(this, "Data inválida!");
            tffDataInicio.setBorder(erro);
            return;
        } else {
            tffDataInicio.setBorder(normal);
        }

        if (!Validar.validarData(dataFim)) {
            JOptionPane.showMessageDialog(this, "Data inválida!");
            tffDataFim.setBorder(erro);
            return;
        } else {
            tffDataFim.setBorder(normal);
        }

        new PedidoDAO().popularTabela(tblPedido, tffDataInicio.getText(), tffDataFim.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idTabela = String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 0));

        idPedido = Integer.parseInt(idTabela);

        int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro selecionado?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Caso o usuário confirme a exclusão
            if (new PedidoDAO().excluir(idPedido) == null) {
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");

                new PedidoDAO().popularTabela(tblPedido);
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
            }
        }

        idPedido = 0;
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblPedido.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro.");
        } else {
            idPedido = Integer.parseInt(String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 0)));

            System.out.println("Pedido Item: " + idPedido);

            jTabbedPane1.setSelectedIndex(1);

            tffDataPedido.setText(String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 1)));
            tfdIdCliente.setText(String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 2)));
            tfdNomeCliente.setText(String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 3)));
            tfdTotal.setText(String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 4)));

            total = Double.parseDouble(String.valueOf(tblPedido.getValueAt(tblPedido.getSelectedRow(), 4)));

            new ItemPedidoDAO().popularTabela(tblItemPedido, "", idPedido);

            btnCriar.setEnabled(false);
            btnLocalizarCliente.setEnabled(false);
            btnLocalizarProduto.setEnabled(true);
            btnRemover.setEnabled(true);
            btnInserir.setEnabled(true);
            tffQtde.setEditable(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseEntered
        btnFechar.setBackground(new Color(255, 100, 100));
    }//GEN-LAST:event_btnFecharMouseEntered

    private void btnFecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseExited
        Color corPadrao = UIManager.getColor("Button.background");
        btnFechar.setBackground(corPadrao);
    }//GEN-LAST:event_btnFecharMouseExited

    @Override
    public void definirValor(String[] valores, String itemPesquisa) {
        if (itemPesquisa.equalsIgnoreCase("cliente")) {
            tfdIdCliente.setText(valores[0]);
            tfdNomeCliente.setText(valores[1]);
        } else if (itemPesquisa.equalsIgnoreCase("produto")) {
            tfdIdProduto.setText(valores[0]);
            tfdProduto.setText(valores[1]);
            tfdValor.setText(valores[2]);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLocalizarCliente;
    private javax.swing.JButton btnLocalizarProduto;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblItemPedido;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField tfdIdCliente;
    private javax.swing.JTextField tfdIdProduto;
    private javax.swing.JTextField tfdNomeCliente;
    private javax.swing.JTextField tfdProduto;
    private javax.swing.JTextField tfdTotal;
    private javax.swing.JTextField tfdValor;
    private javax.swing.JFormattedTextField tffDataFim;
    private javax.swing.JFormattedTextField tffDataInicio;
    private javax.swing.JFormattedTextField tffDataPedido;
    private javax.swing.JFormattedTextField tffQtde;
    // End of variables declaration//GEN-END:variables
}