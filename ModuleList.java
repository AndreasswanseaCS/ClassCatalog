
/**
 * Class to represent a list of modules from {@link Module}.
 *
 * @author 1906277
 *
 */
import java.util.ArrayList;

/**
 *
 * @author 1906277
 */
public class ModuleList {

    //fields for Module class
    private final ArrayList<Module> listOfModulas;

    /**
     * Creates a empty module array list
     */
    public ModuleList() {
        this.listOfModulas = new ArrayList<>();
    }

    /**
     * add value module to list
     *
     * @param module something
     * @return true if successful
     */
    public boolean addModuleToList(Module module) {

        if (!this.exists(module.getCode())) {
            this.listOfModulas.add(module);
            return true;
        }
        return false;
    }

    // returns true if the code already exists and false if it does not
    private boolean exists(int code) {
        for (Module elem : listOfModulas) {
            if (elem.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the list of all modules
     */
    public ArrayList<Module> getModules() {
        return listOfModulas;
    }
}
