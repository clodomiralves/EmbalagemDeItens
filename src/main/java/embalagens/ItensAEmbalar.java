package embalagens;

import java.util.ArrayList;
import java.util.List;

public class ItensAEmbalar {
    List<ItemASerEmbaladoIF> itens = new ArrayList<>();

    public int adicionaItem(ItemASerEmbaladoIF item){
        itens.add(item);
        return itens.indexOf(item)+1;
    }
    public double calculaQtdeDeEmbalar(int posicao){

        ItemASerEmbaladoIF receptor = itens.get(itens.indexOf(posicao-1));
        return receptor.getArea() * receptor.getPeso();
    }
    public double calculaQtdeTotalDeEmbalar(){
        double total = 0.0;
        for (ItemASerEmbaladoIF totalItens: itens) {
            double blackhole = totalItens.getArea() * totalItens.getPeso();
            total += blackhole;
        }
        return total;
    }
}