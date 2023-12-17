package hellocucumber;

import io.cucumber.gherkin.GherkinParser;
import io.cucumber.messages.types.Envelope;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hellocucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {

    public static void main(String[] args) {
        String feature = "";
        GherkinParser parser = GherkinParser.builder().build();
        Stream<Envelope> parse = parser.parse("example.feature", feature.getBytes(StandardCharsets.UTF_8));
        parse.forEach(System.out::println);
    }

    public static String isItFriday(String today) {
        return "vendredi".equals(today) ? "Oui" : "Non";
    }

}
