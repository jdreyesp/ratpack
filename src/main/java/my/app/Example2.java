package my.app;

import ratpack.exec.Blocking;
import ratpack.handling.Context;
import ratpack.handling.InjectionHandler;
import ratpack.server.RatpackServer;

/**
 * This example shows a blocking operation within Ratpack. Ratpack runs the `Blocking.get(...)` into a separate thread pool.
 * A Netty server is run, routing DELETE HTTP requests with path '/:days' to the DeletingHandler.
 * A unit test of this example is under /src/test/java package
 */
public class Example2 {

    @FunctionalInterface
    public interface Datastore {
        int deleteOlderThan(int days);
    }

    public static class DeletingHandler extends InjectionHandler {
        static void handle(final Context context, final Datastore datastore) {
            final int days = context.getPathTokens().asInt("days");
            Blocking.get(() -> datastore.deleteOlderThan(days))
                    .then(i -> context.render(i + " records deleted"));
        }
    }

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server ->
                server.handlers(chain -> chain.delete(":days", ctx -> DeletingHandler.handle(ctx, days -> days))));
    }
}
