package LLDPractise.ATM.Entities;

import LLDPractise.ATM.chainOfResponsibility.DispenseChain;

public class CashDispenser {

    public final DispenseChain chain;

    public CashDispenser(DispenseChain chain){
        this.chain = chain;
    }

    public synchronized void dispenseChain(int amount){
        chain.dispense(amount);
    }

    public synchronized boolean canDispenseCash(int amount){
        if(amount % 10 != 0){
            return false;
        }
        return chain.canDispense(amount);
    }

}
