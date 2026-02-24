package LLDPractise.Zomato.models;

public class MenuItem {
    private String id;
    private String name;
    private int price;

    public MenuItem(String id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getCode(){
        return id;
    }

    public void setCode(String idc){
        id = idc;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        name = name;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        price = price;
    }

}
