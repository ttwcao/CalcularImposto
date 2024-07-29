package entidades;

public class Fisica extends Pessoa{

    private Double gastoSaude;

    public Fisica(String nome, Double renda, Double gastoSaude) {
        super(nome, renda);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public Double imposto() {
        double taxaPagamento = 0.0;
        if(getGastoSaude() >= 1.0 || getRenda() <= 20.000){
            taxaPagamento = getRenda() * 0.15 - getGastoSaude()/2;
        } if(getGastoSaude() >= 1.0 || getRenda() >= 20.000 ){
            taxaPagamento = getRenda() * 0.25 - getGastoSaude()/2;
        }
        return taxaPagamento;
    }
}
