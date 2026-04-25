package LLDPractise.VendingMachine;

import LLDPractise.VendingMachine.Entites.Denomination;
import LLDPractise.VendingMachine.Entites.Product;

public class VendingMachineMain {
    public static void main(String[] args) {

        VendingMachine machine = VendingMachine.getInstance();
        machine.restock(1, new Product("Coke", 25), 5);
        machine.restock(2, new Product("pepsi", 20), 10);

        machine.insertMoney(Denomination.TWENTY);
        machine.insertMoney(Denomination.HUNDRED);
        machine.selectProduct(1);
        machine.dispense();

        machine.insertMoney(Denomination.TWENTY);
        machine.selectProduct(2);
        machine.dispense();

        System.out.println(machine.collectCash());
    }
}
