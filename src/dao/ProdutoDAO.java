package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Produto;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ProdutoDAO implements IDAOT<Produto> {

    @Override
    public String salvar(Produto o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into produto values "
                    + "(default,"
                    + " '" + o.getDescricao() + "',"
                    + " " + o.getValor() + ","
                    + " " + o.getQtde() + ")";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produto o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE produto "
                    + "SET descricao = '" + o.getDescricao()
                    + "', valor = " + o.getValor()
                    + ", qtde_estoque = " + o.getQtde()
                    + " WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from produto "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir produto: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produto consultarId(int id) {
        Produto produto = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * from produto "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                produto = new Produto();

                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("descricao"));
                produto.setValor(retorno.getString("valor"));
                produto.setQtde(retorno.getString("qtde_estoque"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return produto;
    }

    public boolean atualizarQuantidade(int idProduto, double quantidade) {
        Connection con = null;
        PreparedStatement stmtAtualizacao = null;

        try {
            con = ConexaoBD.getInstance().getConnection();

            // Atualiza a quantidade do produto
            String sql = "UPDATE produto SET qtde_estoque = qtde_estoque - ? WHERE id = ?";
            stmtAtualizacao = con.prepareStatement(sql);
            stmtAtualizacao.setDouble(1, quantidade);
            stmtAtualizacao.setInt(2, idProduto);

            // Imprimir a consulta SQL
            System.out.println("SQL: " + stmtAtualizacao.toString());

            stmtAtualizacao.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar quantidade do produto: " + e.getMessage());
            return false;
        }
    }

    public int obterEstoque(int produtoId) {
        int estoque = 0;

        try {
            // Consultar o estoque do produto no banco de dados
            String query = "SELECT qtde_estoque FROM produto WHERE id = ?";
            PreparedStatement statement = ConexaoBD.getInstance().getConnection().prepareStatement(query);
            statement.setInt(1, produtoId);

            // Imprimir a consulta SQL
            System.out.println("SQL: " + statement.toString());

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                estoque = resultado.getInt("qtde_estoque");
            }

            resultado.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao obter o estoque do produto: " + e);
        }

        return estoque;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabeçalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Valor R$";
        cabecalho[3] = "Qtde estoque";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM produto "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produtos: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM produto "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%'"
                    + "ORDER BY descricao");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getString("valor");
                dadosTabela[lin][3] = resultadoQ.getString("qtde_estoque");

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
                    column.setPreferredWidth(0);
                    break;
                case 1:
                    column.setPreferredWidth(50);
                    break;
                case 2:
                    column.setPreferredWidth(80);
                    break;
                case 3:
                    column.setPreferredWidth(50);
                    break;
                case 4:
                    column.setPreferredWidth(40);
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
