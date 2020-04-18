package CodeLean.Java2_03;

public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.phone;
        //return Utility.stripAccents(this.name) + ": " + Utility.stripAccents(this.phone);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Contact anotherContact = (Contact) obj;

        return this.name.equals(anotherContact.name) && this.phone.equals(anotherContact.phone);
    }
}
