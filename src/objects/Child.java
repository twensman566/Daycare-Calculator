package objects;

import java.time.LocalDate;

public class Child {

    private LocalDate birthDate;
    private String firstName;
    private String lastName;

    public Child() {
    }

    public Child(LocalDate birthDate, String firstName, String lastName) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
