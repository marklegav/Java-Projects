package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;


public class Collaborator extends Collaborators implements Serializable {
    /**
     * build a a intace of collaborators that receve thr name of the collaborators and the email of collaborators
     *
     * @param name  name of collaborators
     * @param email email of manager
     */
    public Collaborator(String name, String email) {
        super(name, email);
    }

}
