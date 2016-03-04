package ua.nure.yosin.SummaryTask3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nure.yosin.SummaryTask3.constants.ConstantsTest;
import ua.nure.yosin.SummaryTask3.controller.DOMControllerTest;
import ua.nure.yosin.SummaryTask3.controller.SAXControllerTest;
import ua.nure.yosin.SummaryTask3.controller.STAXControllerTest;
import ua.nure.yosin.SummaryTask3.entity.ProvidedStatusTest;
import ua.nure.yosin.SummaryTask3.entity.StatusTest;
import ua.nure.yosin.SummaryTask3.util.SorterTest;

@RunWith(Suite.class)
@SuiteClasses({ DOMControllerTest.class, SAXControllerTest.class,
		STAXControllerTest.class, DemoTest.class, ConstantsTest.class,
		SorterTest.class, ProvidedStatusTest.class, StatusTest.class })
public class AllTests {

}
