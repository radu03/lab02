package ro.ase.cts.lab02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OShop o = new OShop("Emag", "logo.jpg", new ArrayList<Prod>());

        Prod p1 = new Prod("Laptop", 3200.5, 1,1, 1123, "");
        Prod p2 = new Prod("Frigider", 207.95, 1,2, 1245, "");

        Prod p3 = new Prod(p1);

        p3.setQty(5);
        p3.setProdName("Paine");

        o.modifyProductsList(1,p1);
        o.modifyProductsList(1,p2);

        o.modifyProductsList(2, p1);
        System.out.println(p1.equals(p2));
    }
}

class OShop {
    private String onlineShopName;
    private String i;
    private ArrayList<Prod> products;

    OShop(String name, String img, ArrayList<Prod> products)
    {
        this.products = new ArrayList<Prod>();
        this.i = img;
        this.onlineShopName = name;
    }

    public void modifyProductsList(int what, Prod p)
    {
        if(what == 1)
        {
            this.products.add(p);
        }
        else
            this.products.remove(p);
    }

    public String getOnlineShopName() {
        return onlineShopName;
    }

    public void setOnlineShopName(String onlineShopName) {
        this.onlineShopName = onlineShopName;
    }

    public String getI() {
        return i;
    }

    public void setImg(String img) {
        this.i = img;
    }
}

class Product
{
    private int id;
    private String name;
    private double price;
    private enum category {};
    private int quantity;
    private String details;

    public Product(int id, String name, double price, int quantity, String details) throws Exception {
        this.id = id;

        if(name!=null || name.length()>=5)
        { this.name = name; }
        else { throw new Exception(); }

        if(price > 0){
        this.price = price;}
        else {throw new Exception();}

        if(quantity > 0)
        {this.quantity = quantity;}

        this.details = details;
    }

    public void applyDiscount(double discount) throws Exception {
        if(!(discount >= 0 || discount < 1 ))
            this.price = this.price * discount;
        else if(discount>=1) {
            this.price = this.price - discount;
        } else throw new Exception();
    }

    public void raisePrice(double extraAmount)
    {
        this.price = this.price + extraAmount;
    }

    public Product(Product p) throws Exception {

        this(p.id, p.name, p.price, p.quantity, p.details);

    }
}

class User
{
    private String usn;
    private String userId;
    private ArrayList<Order> o;
    private ArrayList<Order> c;

    public User(String usn, String userId)
    {
        this.usn = usn;
        this.userId = userId;
        o=new ArrayList<Order>();
        c=new ArrayList<Order>();
    }

    public void addO1(Order o)
    {
        this.o.add(o);
    }

    public void addO2(Order o)
    {
        this.c.add(o);
    }
}

class Order
{
    private ArrayList<Prod> l;
    private String addr;

    public Order()
    {
        l = new ArrayList<Prod>();
    }
    public void add(Prod p)
    {
        if(l.size() > 99)
            return;

        l.add(p);
    }

    public void remove(Prod p)
    {
        l.remove(p);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

class InventoryP
{
    private Prod p;
    private int q;

    public InventoryP(Prod p, int q)
    {
        this.p = new Prod(p);
        this.q = q;
    }
    public Prod getP() {
        return p;
    }

    public void setP(Prod p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}


