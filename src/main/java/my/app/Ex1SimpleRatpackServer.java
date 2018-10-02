package my.app;

import ratpack.server.RatpackServer;

/**
 * Simple example. A netty server is set up in port 5050, handling two main endpoints:
 * /        => returns text body response with 'Hello world'
 * /:name    => returns text body response with 'Hello ' + :name (i.e. calling /diego will return 'Hello Diego')
 */
public class Ex1SimpleRatpackServer {

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server ->
                server.handlers(chain -> chain
                .get(ctx -> ctx.render("Hello world"))
                .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))));
    }
}
