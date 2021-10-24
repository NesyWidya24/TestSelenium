package controllers;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

import java.io.File;
import java.lang.reflect.Method;

public class ExcelDataProvider extends InitMethod {
    @DataProvider(name = "multiSheeetExcelRead", parallel = true)
    public static Object[][] multiSheeetExcelRead(Method method) throws Exception {
        File file = new File("./src/test/resources/Excel Files/testIdentitasBaru.xlsx");
        String SheetName = method.getName();
        System.out.println(SheetName);
        return ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
    }

    @DataProvider(name = "excelSheetNameAsMethodName", parallel = true)
    public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception {
        File file = new File("./src/test/resources/Excel Files/" + method.getName() + ".xlsx");
        return ExcelUtils.getTableArray(file.getAbsolutePath());
    }
}
