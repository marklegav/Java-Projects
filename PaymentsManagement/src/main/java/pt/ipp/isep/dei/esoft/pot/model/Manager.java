package pt.ipp.isep.dei.esoft.pot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class for representatin the manager of the Organisation
 */
public class Manager extends Collaborators  implements Serializable{


    public Manager(String strNome, String strEmail) {
        super(strNome, strEmail);
    }

    @Override
    public String toString() {

        return "Manager \n"+
                super.toString();
    }
}
