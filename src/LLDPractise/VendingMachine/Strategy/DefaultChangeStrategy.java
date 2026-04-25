package LLDPractise.VendingMachine.Strategy;

import LLDPractise.VendingMachine.Entites.Denomination;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DefaultChangeStrategy implements ChangeStrategy {

    @Override
    public Map<Denomination, Integer> calculateChange(int amount) {

        Map<Denomination, Integer> result = new HashMap<>();
        Denomination[] values = Denomination.values();
        Arrays.sort(values, (a, b) -> b.getValue() - a.getValue());

        for(Denomination d : values){
            int count = amount / d.getValue();
            if(count > 0){
                result.put(d, count);
                amount = amount % d.getValue();
            }
        }
        return result;
    }
}
