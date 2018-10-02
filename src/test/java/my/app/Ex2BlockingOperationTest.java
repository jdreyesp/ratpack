package my.app;

import org.junit.Test;
import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Ex2BlockingOperationTest {

    @Test
    public void example2ShouldWorkAsExpected() throws Exception {
        final HandlingResult result = RequestFixture.handle(new Ex2BlockingOperation.DeletingHandler(), fixture -> fixture
        .pathBinding(Collections.singletonMap("days", "10"))
        .registry(r -> r.add(Ex2BlockingOperation.Datastore.class, days -> days)));

        assertEquals("10 records deleted", result.rendered(String.class));
    }
}
