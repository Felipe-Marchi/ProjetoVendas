package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Pedido;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PedidoDAO implements IDAOT<Pedido> {

    @Override
    public String salvar(Pedido o) {
        String retornoConsulta = "";

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into pedido "
                    + "values"
                    + "(default, "
                    + "'" + o.getDataPedido() + "', "
                    + "" + o.getClienteId() + ") returning id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                retornoConsulta = retorno.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Erro ao inserir pedido: " + e);
            retornoConsulta = "ERRO:" + e.toString();
        }
        return retornoConsulta;
    }

    @Override
    public String atualizar(Pedido o) {
        String retornoConsulta = "";

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update pedido "
                    + "set data_pedido = '" + o.getDataPedido() + "', "
                    + "cliente_id = " + o.getClienteId() + " "
                    + "where id = " + o.getId();

            System.out.println("SQL: " + sql);

            int linhasAfetadas = st.executeUpdate(sql);

            if (linhasAfetadas > 0) {
                retornoConsulta = "Pedido atualizado com sucesso!";
            } else {
                retornoConsulta = "Nenhum pedido encontrado para atualização.";
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar pedido: " + e);
            retornoConsulta = "ERRO:" + e.toString();
        }
        return retornoConsulta;
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from item_pedido where pedido_id = " + id + "; delete from pedido where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir pedido: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Pedido> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Pedido> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Pedido> consultar(String dataInicio, String dataFim) {

        ArrayList<Pedido> pedidos = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select pedido.*, cliente.nome\n"
                    + "from pedido, cliente\n"
                    + "where\n"
                    + "pedido.cliente_id = cliente.id;";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Pedido pedido = new Pedido();

                pedido.setId(retorno.getInt("id"));
                pedido.setDataPedido(retorno.getString("data_pedido"));
                pedido.setClienteId(retorno.getInt("cliente_id"));

                pedidos.add(pedido);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar pedidos: " + e);
        }
        return pedidos;
    }

    public void popularTabela(JTable tabela) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabeçalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Data";
        cabecalho[2] = "Cliente Id";
        cabecalho[3] = "Cliente Nome";
        cabecalho[4] = "Valor total";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "select count(*) "
                    + "from pedido, cliente\n"
                    + "where\n"
                    + "pedido.cliente_id = cliente.id");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar tabela de pedidos: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(
                    "SELECT pedido.*, cliente.nome, (SELECT SUM(qtde * valor) AS total FROM item_pedido WHERE pedido_id = pedido.id) "
                    + "FROM pedido, cliente "
                    + "WHERE pedido.cliente_id = cliente.id "
                    + "ORDER BY pedido.data_pedido"
            );

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = Formatacao.ajustarDataDMA(resultadoQ.getString("data_pedido"));
                dadosTabela[lin][2] = resultadoQ.getString("cliente_id");
                dadosTabela[lin][3] = resultadoQ.getString("nome");
                dadosTabela[lin][4] = resultadoQ.getDouble("total");

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
                    column.setPreferredWidth(70);
                    break;
                case 2:
                    column.setPreferredWidth(30);
                    break;
                case 3:
                    column.setPreferredWidth(200);
                    break;
                case 4:
                    column.setPreferredWidth(60);
                    break;
                case 5:
                    column.setPreferredWidth(50);
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

    public void popularTabela(JTable tabela, String dataInicio, String dataFim) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabeçalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Data";
        cabecalho[2] = "Cliente Id";
        cabecalho[3] = "Cliente Nome";
        cabecalho[4] = "Valor total";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "select count(*) "
                    + "from pedido, cliente\n"
                    + "where\n"
                    + "pedido.cliente_id = cliente.id and\n"
                    + "pedido.data_pedido >= '" + dataInicio + "' and "
                    + "pedido.data_pedido <= '" + dataFim + "';");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar tabela de pedidos: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "select pedido.*, cliente.nome, (select sum (qtde * valor) as total from item_pedido where pedido_id = pedido.id) "
                    + "from pedido, cliente\n"
                    + "where\n"
                    + "pedido.cliente_id = cliente.id and\n"
                    + "pedido.data_pedido >= '" + dataInicio + "' and "
                    + "pedido.data_pedido <= '" + dataFim + "' "
                    + "order by pedido.id");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = Formatacao.ajustarDataDMA(resultadoQ.getString("data_pedido"));
                dadosTabela[lin][2] = resultadoQ.getString("cliente_id");
                dadosTabela[lin][3] = resultadoQ.getString("nome");
                dadosTabela[lin][4] = resultadoQ.getDouble("total");

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
                    column.setPreferredWidth(70);
                    break;
                case 2:
                    column.setPreferredWidth(30);
                    break;
                case 3:
                    column.setPreferredWidth(200);
                    break;
                case 4:
                    column.setPreferredWidth(60);
                    break;
                case 5:
                    column.setPreferredWidth(50);
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
