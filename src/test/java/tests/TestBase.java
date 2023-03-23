package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

public class TestBase {

    static Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static AplicationManager app = new AplicationManager();

    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        app.init(false); // for  protected void init
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test Kuz " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED" + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED" + result.getMethod().getMethodName());
        }

        logger.info("=========================================================================");
    }
}
