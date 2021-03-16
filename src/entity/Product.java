package entity;

public class Product {
    // tạo model product tương ứng với các field trong database
    private int id;
    private String name,desc;
    //contructor

    public Product() {
    }

    public Product(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    //getter//setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
