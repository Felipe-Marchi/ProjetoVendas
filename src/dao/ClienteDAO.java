package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.awt.Color;
import java.awt.Component;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ClienteDAO implements IDAOT<Cliente> {

    @Override
    public String salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into cliente values "
                    + "(default,"
                    + " '" + o.getNome() + "',"
                    + " '" + o.getEmail() + "',"
                    + " '" + o.getTelefone() + "',"
                    + " '" + o.getCpf() + "',"
                    + o.getEndereco_id() + ")";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE cliente "
                    + "SET nome = '" + o.getNome()
                    + "', email = '" + o.getEmail()
                    + "', telefone = '" + o.getTelefone()
                    + "', cpf = '" + o.getCpf()
                    + "', endereco_id = " + o.getEndereco_id()
                    + " WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from cliente "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarId(int id) {

        Cliente cliente = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * from cliente "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                cliente = new Cliente();

                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
                cliente.setEmail(retorno.getString("email"));
                cliente.setTelefone(retorno.getString("telefone"));
                cliente.setCpf(retorno.getString("cpf"));
                cliente.setEndereco_id(retorno.getInt("endereco_id"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar cliente: " + e);
        }

        return cliente;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabeçalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "E-mail";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "CPF";
        cabecalho[5] = "Endereço";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM cliente "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar clientes: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT c.*, e.descricao "
                    + "FROM cliente c "
                    + "JOIN endereco e ON c.endereco_id = e.id "
                    + "WHERE c.nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY c.nome");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("cpf");
                dadosTabela[lin][5] = resultadoQ.getString("descricao");

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
