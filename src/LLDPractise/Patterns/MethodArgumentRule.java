package LLDPractise.Patterns;

class Parent{
    public void print(String msg){
        System.out.println("Parent " + msg);
    }
}

class Child extends Parent{

    @Override
    public void print(String msg){
        System.out.println("Child " + msg);
    }
}

class Client{
    private Parent p;
    public Client(Parent p){
        this.p = p;
    }
    public void printMsg(){
        p.print("Hello: ");
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child = new Child(); 
        Client client = new Client(child);
        client.printMsg();
    }
}
