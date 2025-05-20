package in_class_exercises_CS202.exercise5;

public class DirectoryEntry {

    // Data Fields
    /**The name of the individual represented in the entry. */
    private final String name;
    /** The phone number for this individual. */
    private String number;

    // Constructor
    /**
     * Creates a new DirectoryEntry with the specified name and number
     * @param name The name of this individual
     * @param number The phone number for this indvidual
     */
    public DirectoryEntry(String name, String number) {
        this.name = name;
        this.number = number;
    }

    //Methods
    /**
     * Retrieves the name.
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the number.
     * @return The number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number to the specified value
     * @param number The new value for the number
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
