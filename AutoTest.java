/**
 *
 * This is the automatic testing file for coursework 2 (CS-110)
 *
 * When you  compile and run this together with your code, it should
 * 1. compile correctly (with no warnings); and
 * 2. print "Pass!"
 * If it does both of these things, your code is working correctly.
 *
 * If it prints "Fail!" then the output from your code does not match that
 * which is expected - see the string 'expectedOutput' in the code below.
 *
 * To help you in that case, you can uncomment the debugging code.
 * - The block labelled **2** just prints out the actual and expected output and
 *   you can compare them visually
 * - The two blocks labelled **1** use the Java class StringDiff (supplied) so
 *   you must compile it with your code and AutoTest (just leaving it in the
 *   same folder as all the other code and typing 'javac *.java' will be fine.
 *   The code at the bottom of AutoTest then compares the expected and actual
 *   output, and prints all the differences between  and  characters
 */
public class AutoTest {

    public static void main(String[] args) {

        //Uncomment for debugging **1**
        //StringDiff stringDiff = new StringDiff();

        //This is the expected output of your code.
        String expectedOutput
                = "MA:3-100 Hard Sums (Mathematics)\n"
                + "MA:4-101 Difficult Theories (Mathematics)\n"
                + "MA:5-102 Cryptic Symbols (Mathematics)\n"
                + "MA:6-103 Very Hard Sums (Mathematics)\n"
                + "CS:3-104 Turn it off and on again (Computer Science)\n"
                + "CS:5-105 All-Nighter Training (Computer Science)\n"
                + "CS:6-106 Obfuscated C Programming (Computer Science)\n"
                + "\n"
                + "CS:3-104 Turn it off and on again (Computer Science)\n"
                + "CS:5-105 All-Nighter Training (Computer Science)\n"
                + "CS:6-106 Obfuscated C Programming (Computer Science)\n"
                + "\n"
                + "MA:6-103 Very Hard Sums (Mathematics)\n"
                + "CS:6-106 Obfuscated C Programming (Computer Science)\n"
                + "\n"
                + "MA:6-103 Legal so OK (Mathematics)\n"
                + "\n"
                + "\n"
                + "MA:6-103 Legal so OK (Mathematics)\n";

        //First we create a catalogue that contains only legal modules
        ModuleCatalog catalog = new ModuleCatalog();

        catalog.addModule(3, 100, "Hard Sums", "MA");
        catalog.addModule(4, 101, "Difficult Theories", "MA");
        catalog.addModule(5, 102, "Cryptic Symbols", "MA");
        catalog.addModule(6, 103, "Very Hard Sums", "MA");

        catalog.addModule(3, 104, "Turn it off and on again", "CS");
        catalog.addModule(4, 104, "Stop Eating Quiche", "CS");
        catalog.addModule(5, 105, "All-Nighter Training", "CS");
        catalog.addModule(6, 106, "Obfuscated C Programming", "CS");

        //Now we create a string consisting of: all modules; all CS modules; and
        //all level 6 modules.
        String actualOutput
                = catalog.formatCatalogList(catalog.getAllModules()) + "\n";
        actualOutput += catalog.formatCatalogList(catalog.getModulesByDeptCode("CS")) + "\n";
        actualOutput += catalog.formatCatalogList(catalog.getModulesByLevel(6)) + "\n";

        //Now create a catalogue to test errros - only one of these modules is
        //legal, and only that one shoudl be added to the catalogue
        ModuleCatalog errorCatalog = new ModuleCatalog();

        errorCatalog.addModule(0, 100, "Illegal Level", "MA");
        errorCatalog.addModule(4, 99, "Illegal Code", "MA");
        errorCatalog.addModule(5, 102, "Illegal Department", "CH");
        errorCatalog.addModule(6, 103, "Legal so OK", "MA");
        errorCatalog.addModule(6, 103, "Duplicate Code", "CS");

        //Again output all modules, all CS modules, all level 6 modules - since
        //only one legal module in level 6 gets added, this gets output twice - once
        //when we output all modules, and once when we output level 6 modules.
        actualOutput += errorCatalog.formatCatalogList(errorCatalog.getAllModules()) + "\n";
        actualOutput += errorCatalog.formatCatalogList(errorCatalog.getModulesByDeptCode("CS")) + "\n";
        actualOutput += errorCatalog.formatCatalogList(errorCatalog.getModulesByLevel(6));

        System.out.println(actualOutput);
        //This checks that your output matches (or not) the expected output
        if (actualOutput.equals(expectedOutput)){
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }

        //Uncomment for debugging **2**
        //System.out.println(expectedOutput);
        //System.out.println(actualOutput);

        //Uncomment for debugging **1**
        //String[] differences = stringDiff.difference(actualOutput, expectedOutput);
        //
        //for(String elem : differences){
        //    System.out.println("<" + elem + ">");
        //}

    }
}
