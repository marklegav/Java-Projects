package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Objects;
/**
 * This class represents the organization's employees
 * @author arccenio
 */
public class Collaborators implements Serializable {

    /**
     * name of the manager
     */
    private String name;
    /**
     * email of the manager
     */
    private String email;

    /**
     * build a a intace of collaborators that receve thr name of the collaborators and the email of collaborators
     * @param name name of collaborators
     * @param email email of collaborators
     */
    public Collaborators(String name, String email) {
        if ( (name == null) || (email == null) ||
                (name.isEmpty())|| (email.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.name = name;
        this.email = email;
    }
    public boolean hasId(String strId)
    {
        return this.email.equalsIgnoreCase(strId);
    }

    /**
     *name advisor and returns the name
     * @return nome do manager
     */
    public String getName() {
        return name;
    }

    /**
     * email advisor and returns the email
     * @return
     */
    public String getEmail() {
        return email;
    }
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     * equal method inspired by the project in paulo main's ESOF code
     * @param o object
     * @return caparation of the instance
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        return (Objects.equals(email, email));
    }
    /**
     * Text descrition of colaborator
     * @return  colaborator 
     */
    @Override
    public String toString()
    {
        return String.format(" -%s - %s", this.name,  this.email);
    }
}
