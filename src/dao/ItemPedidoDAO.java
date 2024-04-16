package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.ItemPedido;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ItemPedidoDAO implements IDAOT<ItemPedido> {

    @Override
    public String salvar(ItemPedido o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into item_pedido "
                    + "values"
                    + "(default, "
                    + "" + o.getQtde() + ", "
                    + "" + o.getValor() + ", "
                    + "" + o.getPedidoId() + ", "
                    + "" + o.getProdutoId() + ")";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Item no pedido: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(ItemPedido o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete "
                    + "from item_pedido "
                    + "where "
                    + "id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Item pedido: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<ItemPedido> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ItemPedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemPedido consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void popularTabela(JTable tabela) {
        // Cabeçalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Id Produto";
        cabecalho[2] = "Descrição";
        cabecalho[3] = "Quantidade";
        cabecalho[4] = "Valor";

        // Configurações adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(null, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
                return Object.class;
            }
        });

        // Redimensiona as colunas da tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }

        // Permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

    }

    public void popularTabela(JTable tabela, String criterio, int idPedido) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabeçalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Id Produto";
        cabecalho[2] = "Descrição";
        cabecalho[3] = "Quantidade";
        cabecalho[4] = "Valor";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "select count(*)\n"
                    + "from produto, item_pedido\n"
                    + "where\n"
                    + "item_pedido.produto_id = produto.id and\n"
                    + "item_pedido.pedido_id = " + idPedido);

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Item pedido: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "select item_pedido.id as iditem_pedido, item_pedido.produto_id as produto_id, item_pedido.qtde, item_pedido.valor, produto.descricao\n"
                    + "from produto, item_pedido\n"
                    + "where\n"
                    + "item_pedido.produto_id = produto.id and\n"
                    + "item_pedido.pedido_id = " + idPedido);

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("iditem_pedido");
                dadosTabela[lin][1] = resultadoQ.getString("produto_id");
                dadosTabela[lin][2] = resultadoQ.getString("descricao");
                dadosTabela[lin][3] = resultadoQ.getString("qtde");
                dadosTabela[lin][4] = resultadoQ.getString("valor");

                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configurações adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editável
            public boolean isCellEditable(int row, int column) {
                return false;

            }

            // alteração no método que determina a coluna em que o objeto ImageIcon deverá aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
                case 2:
                    column.setPreferredWidth(14);
                    break;
            }
        }
        // renderização das linhas da tabela = mudar a cor
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(new Color(211, 211, 211));
                } else {
                    setBackground(new Color(220, 220, 220));
                }
                return this;
            }
        });
    }

}
