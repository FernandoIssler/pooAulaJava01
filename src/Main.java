//IMPORTAÇÕES NECESSÁRIAS
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    /**
     * Excpetion de idade negativa
     */
    public static class NegativeAgeException extends RuntimeException {
        public NegativeAgeException() {
            super("A idade não pode ser negativa.");
        }
    }

    /**
     * Essa função calcula a idade do usuário com base na data de nascimento fornecida por ele.
     * A função também faz uma validação da data, caso seja uma data inválida ele retorna uma Exception da classe SimpleDateFormat
     */
    public static int calculateAge(String birthDateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //Instancia a classe SimpleDateFormat atribuindo o formato desejado de data "dd/MM/yyyy"
        Date birthDate = dateFormat.parse(birthDateString); //Faz o parse (análise) da data informada pelo usuário. Caso a data seja inválida retorna uma Exception

        Calendar cal = Calendar.getInstance(); //Inicia a classe calendário que receberá a data informada pelo usuário
        cal.setTime(birthDate); //Faz o parse da data com base no objeto recebido pela classe SimpleDateFormat através da variável "Date birthDate"

        int birthYear = cal.get(Calendar.YEAR); //Pega o ano
        int birthMonth = cal.get(Calendar.MONTH); //Pega o mês
        int birthDay = cal.get(Calendar.DAY_OF_MONTH); //Pega o dia

        Calendar today = Calendar.getInstance(); //Inicia a classe calendário que receberá a data atual\
        int currentYear = today.get(Calendar.YEAR); //Pega o ano atual
        int currentMonth = today.get(Calendar.MONTH); //Pega o mês atual
        int currentDay = today.get(Calendar.DAY_OF_MONTH); //Pega o dia atual

        int age = currentYear - birthYear; //Calcula a diferença entre a data informada e  a data atual calculando assim a idade do usuário

        if ((birthMonth > currentMonth) || (birthMonth == currentMonth && birthDay > currentDay)) { //Verifica se a data de nascimento já ocorreu no ano atual
            age--; //Caso a data não tenha ocorrido no ano atual ele decrementa um ano
        }

        if (age < 0) { //Verifica se a idade é negativa e retorna uma Excpention
            throw new NegativeAgeException();
        }

        return age; //Retorno da função
    }


    public static void main(String[] args) throws ParseException {

        //Apenas cores de estilo
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";

        //Título da atividade
        System.out.println(green + " ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄                         ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄    ▄       ▄            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ ");
        System.out.println("▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌                       ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌     ▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
        System.out.println("▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌                       ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀ ▐░▌ ▐░▌      ▐░▌          ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌");
        System.out.println("▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌                       ▐░▌          ▐░▌       ▐░▌     ▐░▌     ▐░▌░▌        ▐░▌          ▐░▌       ▐░▌▐░▌          ▐░▌       ▐░▌");
        System.out.println("▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌       ▐░▌      ▄▄▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌░▌        ▐░▌          ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌");
        System.out.println("▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌     ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌     ▐░░▌         ▐░▌          ▐░░░░░░░░░░░▌▐░▌▐░░░░░░░░▌▐░▌       ▐░▌");
        System.out.println("▐░█▀▀▀▀▀▀▀▀▀ ▐░▌       ▐░▌▐░▌       ▐░▌                       ▐░▌          ▐░▌     ▐░▌       ▐░▌     ▐░▌▐░▌       ▐░▌          ▐░█▀▀▀▀▀▀▀█░▌▐░▌ ▀▀▀▀▀▀█░▌▐░▌       ▐░▌");
        System.out.println("▐░▌          ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌                       ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌  ▄▄▄▄█░█▄▄▄▄ ▐░▌ ▐░▌      ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌");
        System.out.println("▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌                       ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
        System.out.println(" ▀            ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀                         ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀    ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ ");

        //Instancia o Scanner que captará as informações digitadas pelo usuário
        Scanner scanner = new Scanner(System.in);

        //Primeira pergunta
        System.out.print(blue + "\nDigite seu nome: ");
        String name = scanner.nextLine();

        //Declara a variável age (idade) como int
        //A variável está sendo declarada como -1 para que seja feita avalidação no do while a seguir
        //Isso pq age nunca vai retornar -1 e ele continuará percorrendo o do while até que seja alterado o seu valor para a idade do usuário
        int age = -1;

        do {
            //Segunda pergunta que será feita enquanto não for satisfeita a condição de cálculo da idade com uma data válida informada
            System.out.print(blue + "Digite sua data de nascimento no formato 'dd/mm/aaaa': ");
            String birthDateString = scanner.nextLine();

            //Bloco try catch tentará executar a função calculateAge() até retornar a idade correta do usuário utilizando da data informada
            try {
                age = calculateAge(birthDateString); //Executa a função que pode retornar uma idade válida ou uma Exception
            } catch (ParseException e) {
                System.out.println(red + "Formato de data inválido. Use o formato dd/mm/yyyy." + reset); //Exception de data inválida
            }  catch (NegativeAgeException e) {
                System.out.println(red + e.getMessage() + reset); //Exception de idade negativa
            }
        } while (age == -1); //Enquanto age foi igual a -1 ele vai executar o loop

        //Terceira pergunta
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        //Exibe as informações na tela do usuário
        System.out.println(red + "\nDados Capturados:" + reset);
        System.out.println(blue + "Nome: " + green + name);
        System.out.println(blue + "Idade: " + green + age);
        System.out.println(blue + "E-mail: " + green + email);

        //Condição da exibição para a habilitação
        if(age >= 18) {
            System.out.println("██████╗  █████╗ ██████╗  █████╗ ██████╗ ███████╗███╗   ██╗███████╗");
            System.out.println("██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔════╝████╗  ██║██╔════╝");
            System.out.println("██████╔╝███████║██████╔╝███████║██████╔╝█████╗  ██╔██╗ ██║███████╗");
            System.out.println("██╔═══╝ ██╔══██║██╔══██╗██╔══██║██╔══██╗██╔══╝  ██║╚██╗██║╚════██║");
            System.out.println("██║     ██║  ██║██║  ██║██║  ██║██████╔╝███████╗██║ ╚████║███████║");
            System.out.println("╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═══╝╚══════╝");

            System.out.println(green + "PARABÉNS! " + yellow + "Você já pode tirar sua habilitação!!");
        } else {
            System.out.println(" ██████╗ ██╗   ██╗███████╗    ██████╗ ███████╗███╗   ██╗ █████╗ ");
            System.out.println("██╔═══██╗██║   ██║██╔════╝    ██╔══██╗██╔════╝████╗  ██║██╔══██╗");
            System.out.println("██║   ██║██║   ██║█████╗      ██████╔╝█████╗  ██╔██╗ ██║███████║");
            System.out.println("██║▄▄ ██║██║   ██║██╔══╝      ██╔═══╝ ██╔══╝  ██║╚██╗██║██╔══██║");
            System.out.println("╚██████╔╝╚██████╔╝███████╗    ██║     ███████╗██║ ╚████║██║  ██║");
            System.out.println(" ╚══▀▀═╝  ╚═════╝ ╚══════╝    ╚═╝     ╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝");

            System.out.println(yellow + "Você ainda" + red + " NÃO " + yellow + " pode tirar sua habilitação");
        }

        scanner.close();
    }
}