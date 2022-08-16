package hello.itemservice.domain.item;

import java.util.Objects;

public class Item {

    private Long id;
    private String itemName;
    private String contents;
    private String customer;

    public Item() {
    }

    public Item(String itemName, String contents, String customer) {
        this.itemName = itemName;
        this.contents = contents;
        this.customer = customer;
    }

    public Item(long id, String itemName, String contents, String customer) {
        this.id = id;
        this.itemName = itemName;
        this.contents = contents;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", contents='" + contents + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) && itemName.equals(item.itemName) && contents.equals(item.contents) && customer.equals(item.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, contents, customer);
    }
}
