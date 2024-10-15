public class Guest {
    private String name;
    private String dateOfBirth;

    public Guest(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getInfo() {
        return name + " (" + dateOfBirth + ")";
    }
}
