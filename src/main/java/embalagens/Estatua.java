package embalagens;

import java.util.Objects;

public class Estatua implements ItemASerEmbaladoIF {
    private String material;
    private int base;
    private int altura;
    private int peso;

    public Estatua(String material, int base, int altura, int peso) throws Exception{
        super();
        testaEntrada(material, base, altura, peso);
        this.material = material;
        this.base = base;
        this.altura = altura;
        this.peso = peso;
    }
    private void testaEntrada(String material, int base, int altura, int peso) throws Exception{
        if(material == null || material == (""))
            throw new Exception("Material tem que ser informado");
        if(base <= 0)
            throw new Exception("Base/altura tem que ser maior que zero");
        if(altura <= 0)
            throw new Exception("Base/altura tem que ser maior que zero");
        if(peso <= 0)
            throw new Exception("Peso tem que ser maior que zero");

    }

    public int getBase(){
        return base;
    }
    public int getAltura(){
        return altura;
    }
    @Override
    public double getArea() {
        return (base * altura)/2;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estatua estatua = (Estatua) o;
        return base == estatua.base
                && material == estatua.material
                && altura == estatua.altura
                && peso == estatua.peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, altura, peso);
    }
    public String toString(){
        return "Estatua de " + material + ", com área " + getArea() + " e peso de " + getPeso() + " gramas.";
    }
}
