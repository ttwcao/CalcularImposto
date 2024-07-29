import entidades.Fisica;
import entidades.Juridica;
import entidades.Pessoa;

import javax.print.Doc;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaIR {

    public static void main(String[] args) {

        Locale locale = new Locale("pt","BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        Scanner sc =  new Scanner(System.in);
        List<Pessoa> listaPessoa = new ArrayList<>();

        System.out.println("Digite o número contribuintes: ");
        int nrC = sc.nextInt();

        for(int i=1; i<=nrC; i++){
            System.out.println("Dados do contribuinte #" +i);
            System.out.println("Pessoa Física ou Jurídica (f/j)? ");
            char p = sc.next().charAt(0);
            sc.nextLine();

            if(p =='f'){
                System.out.println("Nome: ");
                String nome = sc.nextLine();

                System.out.println("Renda anual: ");
                Double renda = sc.nextDouble();

                System.out.println("Gastos com saúde: ");
                Double saude = sc.nextDouble();
                listaPessoa.add(new Fisica(nome, renda, saude));

            } if( p =='j'){
                System.out.println("Nome: ");
                String nome = sc.nextLine();

                System.out.println("Renda anual: ");
                Double renda = sc.nextDouble();

                System.out.println("Número de empregados: ");
                Integer empregados = sc.nextInt();
                listaPessoa.add(new Juridica(nome, renda, empregados));
            }
        }

        System.out.println("TAXAS PAGAS:");
        Double soma=0.0;

        for(Pessoa p : listaPessoa){
            System.out.println(p.getNome() + ": " + (numberFormat.format(p.imposto())));
             soma += p.imposto();
        }

        sc.close();

    }
}
