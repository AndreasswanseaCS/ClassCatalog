/*
feedback:
Below is my respons t the feedback.
1)Requested for me to use a correct use of Final Variables (Constants)
               -i have put finals for all possible cases that prevetns me
                from failing the checkstyle file

2)Requested for me to use standard Java indenting and {} position style,
and one style is consistently chosen.- i used checkfile to ensure that there is
                                        a correct style

3)Requested for me to add a comment at the start for each class.
                             - i have added comments at the start of each class

4)Requested for me to add more methods inorder for there to be methods
that do one thing which has been completed to the best of my knowledge
 */

/**
 * ModuleCatalog stores valid objects (modules) into moduleList and displays
 * objects to the user by level and department code as well as the entire list
 * of valid objects
 *
 * @author 1906277
 */
public class ModuleCatalog {

    private final ModuleList catalog;

    /**
     * Creates an object that will hold all the valid module objects.
     */
    public ModuleCatalog() {
        this.catalog = new ModuleList();
    }

    /**
     * Creates module by setting the values in the class and then adds the
     * module to the Catalog object.
     *
     * @param level is the level of the module
     * @param code is the module code of the module
     * @param name is the name of the module
     * @param deptCode is the department code for th
     * @return true if object is created. Or false if the parameters past to the
     * addModule are invalid
     */
    public boolean addModule(int level, int code,
                             String name, String deptCode) {

        Module module = new Module();

        if (module.setDeptCode(deptCode) && module.setCode(code)
                && module.setName(name) && module.setLevel(level)) {

            catalog.addModuleToList(module);
            return true;
        }
        return false;
    }

    /**
     *
     * @return list Of all Modules from ModuleList to parse to
     * formatCatalogList()
     */
    public ModuleList getAllModules() {
        return catalog;
    }

    /**
     * creates an array which stores each modules that have the matching 'level'
     *
     * @param level is the level of the module
     * @return array list to parse to formatCatalogList()
     */
    public ModuleList getModulesByLevel(int level) {
        ModuleList list = new ModuleList();
        for (Module elem : catalog.getModules()) {
            if (level == elem.getLevel()) {
                list.addModuleToList(elem);
            }
        }
        return list;
    }

    /**
     * creates an list which stores each modules that have the matching
     * 'deptCode'
     *
     * @param deptCode is the department code for the module
     * @return array list of
     */
    public ModuleList getModulesByDeptCode(String deptCode) {
        ModuleList list = new ModuleList();
        for (Module elem : catalog.getModules()) {
            if (deptCode.equals(elem.getDeptCode())) {
                list.addModuleToList(elem);
            }
        }
        return list;
    }

    /**
     * Formats the catalog in a readable manner for displaying
     *
     * @param list of all modules that have been requested to be formated into a
     * string
     * @return a formated string of all the module list passed in
     */
    public String formatCatalogList(ModuleList list) {
        String eachObject = "";
        for (Module elem : list.getModules()) {
            eachObject += elem;
        }
        return eachObject;
    }
}
