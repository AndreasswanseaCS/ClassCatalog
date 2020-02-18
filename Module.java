
/**
 * Class to represent module data
 * @author 1906277
 */
public class Module {

    //fields for Module class
    private int level;
    private int code;
    private String name;
    private String deptCode;
    private String deptName;

    //2D array that hold all the department codes and department names
    private static final String[][] DEPT_CODE = {
            {"CS", "Computer Science"},
            {"MA", "Mathematics"}};
    private static final int MIN_LEVEL = 3; // lowest module level
    private static final int MAX_LEVEL = 6; // highest module level
    private static final int MIN_CODE = 100; // lowest module code
    private static final int MAX_CODE = 999; //highest module code

    /**
     * sets the module qualification level
     * @param newLevel will be so it can set the level
     * @return true if successful
     */
    public boolean setLevel(int newLevel) {
        if (newLevel >= MIN_LEVEL && newLevel <= MAX_LEVEL) {
            this.level = newLevel;
            return true;
        }
        return false;
    }

    /**
     * sets the module department code
     * @param newCode will be checked so it can set the code
     * @return true if successful
     */
    public boolean setCode(int newCode) {
        if (newCode >= MIN_CODE && newCode <= MAX_CODE) {
            this.code = newCode;
            return true;
        }
        return false;
    }

    /**
     * @param newName to set the name
     * @return true when the name has been set
     */
    public boolean setName(String newName) {
        this.name = newName;
        return true;
    }

    /**
     * sets the department name and department code
     *
     * @param newDeptCode the deptCode to set
     * @return true if successful
     */
    public boolean setDeptCode(String newDeptCode) {
        for (String[] elem : DEPT_CODE) {
            if (elem[0].equals(newDeptCode)) {
                this.deptCode = newDeptCode;
                this.deptName = elem[1];
                return true;
            }
        }
        return false;
    }

    /**
     * @return the department Name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the module code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the department Code
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * @return the module as a formated string
     */
    @Override
    public String toString() {
        return deptCode + ":" + level + "-" + code + " " + name + " (" + deptName + ")\n";
    }

}
