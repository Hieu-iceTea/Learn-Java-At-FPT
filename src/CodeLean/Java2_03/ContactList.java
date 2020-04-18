package CodeLean.Java2_03;

import MyUtilities.Utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactList {
    private List<Contact> listContact;

    public ContactList() {
        this.listContact = new ArrayList<>();
    }

    public ContactList(List<Contact> listContact) {
        this.listContact = new ArrayList<>(listContact);
    }

    public List<Contact> getListContact() {
        return listContact;
    }

    private void setListContact(List<Contact> listContact) {
        this.listContact = listContact;
    }

    public int getSize() {
        return this.listContact.size();
    }

    public Contact getContactByIndex(int index) {
        return listContact.get(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContactList another = (ContactList) obj;
        if (this.getSize() != another.getSize()) {
            return false;
        }

        ContactList this_Clone = (ContactList) this.clone();
        ContactList another_Clone = (ContactList) another.clone();

        this_Clone.getListContact().sort(Comparator.comparing(Contact::getName));
        another_Clone.getListContact().sort(Comparator.comparing(Contact::getName));

        for (int i = 0; i < this.getSize(); ++i) {
            if (!this_Clone.getContactByIndex(i).equals(another_Clone.getContactByIndex(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected Object clone() {
        ContactList result = new ContactList();
        for (var item : this.getListContact()) {
            result.addContact(item);
        }
        return result;
    }

    /* Định nghĩa các phương thức */
    /**
     * Thêm mới contact <br>
     */
    public void addContact(Contact contact) {
        validate_duplicate(contact, null);
        this.listContact.add(contact);
    }

    private void validate_duplicate(Contact contact, Contact exclude) {
        ContactList this_clone = (ContactList) this.clone();
        if (exclude != null) {
            this_clone.removeContact(exclude);
        }
        String errorMesage = "";
        for (var item : this_clone.listContact) {
            if (item.getName().toLowerCase().equals(contact.getName().toLowerCase())) {
                errorMesage += "\nTên [" + contact.getName() + "] đã tồn tại.";
            }

            if (item.getPhone().toLowerCase().equals(contact.getPhone().toLowerCase())) {
                errorMesage += "\nSố điện thoại [" + contact.getPhone() + "] đã tồn tại.";
            }
        }
        if (!errorMesage.isEmpty()) {
            throw new IllegalArgumentException(errorMesage + "\nMọi thao tác của bạn sẽ bị hủy");
        }
    }

    /**
     * <b>Thay đổi đối tượng cũ bằng đối tượng mới.</b>
     * @param oldContact Đối tượng Contact <b>cũ</b>
     * @param newContact Đối tượng Contact <b>mới<b/>
     */
    public void updateContact(Contact oldContact, Contact newContact) {
        int index = this.listContact.indexOf(oldContact);
        validate_duplicate(newContact, oldContact);
        this.listContact.set(index, newContact);
    }

    /** xoá contact  */
    public void removeContact(Contact contact) {
        this.listContact.remove(contact);
    }

    /** tìm contact Theo tên, nếu có thì in ra */
    public void searchContact(String contactName) {
        List<Contact> listContact_found = new ArrayList<>();
        for (var item : this.listContact) {
            if (Utility.stripAccents(item.getName()).trim().toLowerCase()
                    .contains(Utility.stripAccents(contactName).trim().toLowerCase())) {
                listContact_found.add(item);
            }
        }
        if (listContact_found.isEmpty()) {
            System.out.println("Không tìm thấy kết quả.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            showListContact(listContact_found);
        }
    }

    /** hiển thị danh sách contact */
    public void printList() {
        if (this.listContact.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            showListContact(this.listContact);
        }
    }

    /** Common Method */
    private void showListContact(List<Contact> listContact) {
        for (int i = 0; i < listContact.size(); ++i) {
            System.out.println((i + 1) + ". " + listContact.get(i));
        }
    }
}
