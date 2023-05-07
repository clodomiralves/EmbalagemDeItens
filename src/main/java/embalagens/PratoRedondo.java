package embalagens;

import java.util.Objects;

public class PratoRedondo implements ItemASerEmbaladoIF {

    private String material;
    private double raio;
    private double peso;

    public PratoRedondo(String material, double raio, double peso) throws Exception {
        super();
        testaEntrada(material, raio, peso);
        this.material = material;
        this.raio = raio;
        this.peso = peso;
    }

    private void testaEntrada(String material, double raio, double peso) throws Exception {
        if(material == null || material.equals(""))
            throw new Exception("Material tem que ser informado");

        if(raio <= 0)
            throw new Exception("Raio tem que ser maior que zero");

        if(peso <= 0)
            throw new Exception("Peso tem que ser maior que zero");
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public String toString() {
        return "Prato redondo de " + material + ", com área " + getArea() + " e peso de " + getPeso() + " gramas.";
    }

}