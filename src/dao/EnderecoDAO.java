package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Endereco;
import java.awt.Color;
import java.awt.Component;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class EnderecoDAO implements IDAOT<Endereco> {

    @Override
    public String salvar(Endereco o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into endereco values"
                    + " (default,"
                    + " '" + o.getDescricao() + "', '"
                    + o.getCep() + "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir endereço: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Endereco o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update endereco "
                    + "set descricao = '" + o.getDescricao()
                    + "', cep = '" + o.getCep()
                    + "' where id = " + o.getId();

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar endereço: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from endereco "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir endereço: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Endereco> consultarTodos() {

        ArrayList<Endereco> enderecos = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * from endereco "
                    + "order by descricao";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(retorno.getInt("id"));
                endereco.setDescricao(retorno.getString("descricao"));
                endereco.setCep(retorno.getString("cep"));

                enderecos.add(endereco);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar endereços: " + e);
        }
        return enderecos;
    }

    @Override
    public ArrayList<Endereco> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Endereco consultarId(int id) {

        Endereco endereco = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * from endereco "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                endereco = new Endereco();

                endereco.setId(retorno.getInt("id"));
                endereco.setDescricao(retorno.getString("descricao"));
                endereco.setCep(retorno.getString("cep"));

            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar endereço: " + e);
        }

        return endereco;

    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabeçalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "CEP";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM endereco "
                    + "WHERE "
                    + "DESCRICAO ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar endereços: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM endereco "
                    + "WHERE "
                    + "DESCRICAO ILIKE '%" + criterio + "%'"
                    + "ORDER BY descricao");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getString("cep");

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
                    column.setPreferredWidth(5);
                    break;
                case 1:
                    column.setPreferredWidth(170);
                    break;
                case 2:
                    column.setPreferredWidth(40);
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
