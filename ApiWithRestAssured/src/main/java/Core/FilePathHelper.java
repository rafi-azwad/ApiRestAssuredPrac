package Core;

import java.io.File;

public class FilePathHelper {




        public static final String dir = System.getProperty("user.dir");
        static File f = new File(dir);
        static String filepath = f.getParent();
        public static final String FilePathInCore = filepath + "/E2EAutomation/src/main/java/repository/localRepo/";
        // D:\Apps\Programming Language\AutomationWithSelniumAdvanced\SeleniumFunctions\E2EAutomation
        public static final String postApiPath = FilePathInCore + "POSTEmployeeData.json";

        public static final String putApiPath = FilePathInCore + "PUTEmployeeData.json";








}