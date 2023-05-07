package embalagens;

import java.util.Objects;

public class MalaRetangular implements ItemASerEmbaladoIF{

    private double lado1;
    private double lado2;
    private String material;
    private double peso;

    public MalaRetangular(String material, double lado1, double lado2, double peso) throws Exception {
        super();
        testaEntrada(material, lado1, lado2, peso);
        this.material = material;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.peso = peso;

    }
    private void testaEntrada(String material, double lado1, double lado2, double peso) throws Exception{
        if(material == null || material.equals(""))
            throw new Exception("Material que tem que ser informado");
        if (lado1 <= 0)
            throw new Exception("O lado tem que ser maior que zero");
        if (lado2 <= 0)
            throw new Exception("O lado tem que ser maior que zero");
        if(peso <= 0)
            throw new Exception("O peso tem que ser maior que zero");


    }



    public double getLado1() {
        return lado1;
    }

    public double getLado2() {
        return lado2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MalaRetangular that = (MalaRetangular) o;
        return Double.compare(that.lado1, lado1) == 0
            && Double.compare(that.lado2, lado2) == 0
            && Double.compare(that.peso, peso) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lado1, lado2, peso);
    }

    public String toString(){
        return "Mala retangular de: " + material + ", com área" + getArea() + "e peso de " + getPeso() + "gramas.";
    }

    @Override
    public double getArea() {
        return lado1 * lado2;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
