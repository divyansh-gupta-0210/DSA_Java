package LLDPractise.Zomato.Strategy;

public class UPIPaymentStrategy implements PaymentStrategy{
    private String mobileNumber;
    public UPIPaymentStrategy(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(int amount){
        System.out.println("Paid via UPI");
    }

}
