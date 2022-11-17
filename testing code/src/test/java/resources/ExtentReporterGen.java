package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static constants.TestConstants.DOCUMENT_TITLE;
import static constants.TestConstants.REPORT_NAME;


/**
 * this class is used as a helper class to generate reports
 */
public class ExtentReporterGen {

    /**
     * this is a helper function used to generate an object of ExtentReports to be used later when reporting tests
     * @param path: this is the path of the directory where the generated reports will be stored
     * @return ExtentReports: this is the created report from this function
     */
    public static ExtentReports getReporterObject(String path){
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().enableOfflineMode(true);
        reporter.config().setDocumentTitle(DOCUMENT_TITLE);
        reporter.config().setReportName(REPORT_NAME);
        reporter.config().setTheme(Theme.STANDARD);

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "TestingTeam#1");
        return extentReports;
    }
}
