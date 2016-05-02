package web;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class MainRouter {

    Vertx vertx = Vertx.vertx();

    public Router create() {
        Router router = Router.router(vertx);

        router.get("/").handler(ctx -> {
            ctx.response().end("<p>Hello World</p>");
        });

        router.get("/test").handler(ctx -> {
            String param = ctx.request().getParam("param");
            ctx.response().end("<p>Your param was " + param + "</p>");
        });

        return router;
    }
}
