package my.app;

import ratpack.exec.Promise;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.server.RatpackServer;

/**
 * Solution using asynchronous operation.
 */
public class Ex3AsyncOperation {

    public static class PromiseHandler implements Handler {

        @Override
        public void handle(Context ctx) {
            Promise.async((f) -> new Thread(() -> f.success("hello world")).start()).then(ctx::render);
        }
    }

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server.handlers(
                chain -> chain.get(ctx -> new PromiseHandler().handle(ctx))
        ));
    }
}
