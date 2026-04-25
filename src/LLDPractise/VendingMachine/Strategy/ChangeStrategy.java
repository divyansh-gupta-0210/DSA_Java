package LLDPractise.VendingMachine.Strategy;

import LLDPractise.VendingMachine.Entites.Denomination;

import java.util.Map;

public interface ChangeStrategy {
    Map<Denomination, Integer> calculateChange(int amount);
}
