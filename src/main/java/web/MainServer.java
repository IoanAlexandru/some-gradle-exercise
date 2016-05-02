package web;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

public class MainServer {

    Vertx vertx = Vertx.vertx();

    public HttpServer create() {
        return vertx.createHttpServer();
    }

}
