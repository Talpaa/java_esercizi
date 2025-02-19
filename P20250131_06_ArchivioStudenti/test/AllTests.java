import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ArchivioTest.class, StudenteTest.class })
public class AllTests {

}
