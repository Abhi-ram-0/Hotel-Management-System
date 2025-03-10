public class Guest {
    private String name;
    private String contact;

    public Guest(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Guest: " + name + " | Contact: " + contact;
    }
}
