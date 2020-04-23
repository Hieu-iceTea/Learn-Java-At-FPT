package CodeLean.Java2_06.GiftShop.GiftModel;

import java.util.Date;

/**
 * Class Gift.java có đủ thuộc tính id, name, price, qty, ...
 */
public class Gift {
    private int IDBook;
    private int IDAuthor;
    private int IDCategory;
    private int IDPublishCompany;
    private String Name;
    private Double Price;
    private int Qty;
    private Date DatePublish;
    private String Description;
    private String CreatedBy;
    private String UpdatedBy;
    private Date CreatedDate;
    private Date UpdatedDate;
    private boolean Enabled;

    public int getIDBook() {
        return IDBook;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public int getIDAuthor() {
        return IDAuthor;
    }

    public void setIDAuthor(int IDAuthor) {
        this.IDAuthor = IDAuthor;
    }

    public int getIDCategory() {
        return IDCategory;
    }

    public void setIDCategory(int IDCategory) {
        this.IDCategory = IDCategory;
    }

    public int getIDPublishCompany() {
        return IDPublishCompany;
    }

    public void setIDPublishCompany(int IDPublishCompany) {
        this.IDPublishCompany = IDPublishCompany;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public Date getDatePublish() {
        return DatePublish;
    }

    public void setDatePublish(Date datePublish) {
        DatePublish = datePublish;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-5s %-5s %-5s %-82s %-10s %-5s %-12s %-280s %-12s %-12s %-8s %-8s %-5s",
                IDBook, IDAuthor, IDCategory, IDPublishCompany, Name,
                Price, Qty, DatePublish, Description, CreatedBy,
                UpdatedBy, CreatedDate, UpdatedDate, Enabled);
    }
}
