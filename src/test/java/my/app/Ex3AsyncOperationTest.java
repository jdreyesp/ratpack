package my.app;

import org.junit.Test;
import ratpack.test.handling.HandlingResult;
import ratpack.test.handling.RequestFixture;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Ex3AsyncOperationTest {

    @Test
    public void example3ShouldWorkAsExpected() throws Exception {
        final HandlingResult result = RequestFixture.handle(new Ex3AsyncOperation.PromiseHandler(), fixture -> fixture
        .registry(r -> r.add(String.class)));

        assertEquals("hello world", result.rendered(String.class));
    }
}
