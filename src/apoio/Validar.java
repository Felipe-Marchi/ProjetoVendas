package apoio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validar {

    public static boolean validarCPF(String cpf) {
        // Remove caracteres especiais do CPF (pontos e traço)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (CPF inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Verifica a fórmula de validação do CPF
        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpf.substring(i, i + 1));
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }

        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        if (digitos[9] != digitoVerificador1) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }

        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        return (digitos[10] == digitoVerificador2);
    }

    public static boolean validarCNPJ(String cnpj) {
        // Remove caracteres especiais do CNPJ (pontos, traço e barra)
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (CNPJ inválido)
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Verifica a fórmula de validação do CNPJ
        int[] digitos = new int[14];
        for (int i = 0; i < 14; i++) {
            digitos[i] = Integer.parseInt(cnpj.substring(i, i + 1));
        }

        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            soma += digitos[i] * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }

        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        if (digitos[12] != digitoVerificador1) {
            return false;
        }

        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            soma += digitos[i] * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }

        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        return (digitos[13] == digitoVerificador2);
    }

    public static boolean validarCelular(String celular) {
        // Remove caracteres especiais do telefone (espaços, traços, parênteses)
        celular = celular.replaceAll("[\\s\\-()]", "");

        // Verifica se o telefone possui exatamente 11 dígitos
        if (celular.length() != 11) {
            return false;
        }

        // Verifica se todos os caracteres são dígitos numéricos
        for (int i = 0; i < celular.length(); i++) {
            if (!Character.isDigit(celular.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean validarEmail(String email) {
        String formatoEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(formatoEmail);
    }

    public static boolean validarNome(String nome) {
        // Verifica se o nome contém apenas caracteres alfabéticos, espaços e acentos
        String formatoNome = "^[\\p{L}\\s]+$";
        Pattern pattern = Pattern.compile(formatoNome);
        return pattern.matcher(nome).matches();
    }

    public static boolean validarCep(String cep) {
        // Remove caracteres especiais do CEP (espaços, traços)
        cep = cep.replaceAll("[\\s-]", "");

        // Verifica o formato do CEP usando uma expressão regular
        // Nesse exemplo, estamos aceitando CEPs no formato 99999-999 ou 99999999
        String formatoCep = "^\\d{5}-?\\d{3}$";
        return cep.matches(formatoCep);
    }

    public static boolean validarDescricao(String descricao) {

        // Verifica se a descrição do é vazia ou nula
        return !(descricao == null || descricao.trim().isEmpty());
    }

    public static boolean validarValor(Double valor) {
        // Verifica se o valor é nulo ou menor que zero
        if (valor == null || valor <= 0) {
            return false;
        }
        return true;
    }

    public static boolean validarNumero(String numero) {

        try {
            double n = Double.parseDouble(numero);
            if (n <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean validarData(String data) {
        // Verifica o formato da data usando uma expressão regular
        // Nesse exemplo, estamos aceitando datas no formato dd/MM/yyyy
        String formatoData = "^\\d{2}/\\d{2}/\\d{4}$";

        // Verifica se a data está no formato válido
        if (data.matches(formatoData)) {
            // Define o formato desejado para a data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false); // Não permite datas inválidas, como 30 de fevereiro

            try {
                // Faz o parsing da data para verificar se é válida
                sdf.parse(data);
                return true; // A data é válida
            } catch (ParseException e) {
                return false; // A data é inválida
            }
        } else {
            return false; // A data não está no formato válido
        }
    }

    public static boolean validarDataHora(String data_hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setLenient(false); // Desativa a tolerância a datas inválidas

        try {
            Date dataHora = sdf.parse(data_hora);
            // Verifica se a data e hora fornecidas correspondem ao valor parseado
            return data_hora.equals(sdf.format(dataHora));
        } catch (ParseException e) {
            // Ocorreu uma exceção durante o parsing da data e hora
            return false;
        }
    }

}
