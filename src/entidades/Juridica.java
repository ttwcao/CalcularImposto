package entidades;

public class Juridica extends Pessoa{

    private Integer numeroFuncionarios;


    public Juridica(){
    }

    public Juridica(String nome, Double renda, Integer numeroFuncionarios) {
        super(nome, renda);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double imposto() {
        double taxa = 0.0;
        if(getNumeroFuncionarios() >=10) {
            taxa = 0.14;
        } else {
            taxa = 0.16;
        }
        return getRenda() * taxa;
    }
}
