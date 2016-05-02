import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import web.MainRouter;
import web.MainServer;

public class Main {

    public static void main(String[] args) {

        MainServer mainServer = new MainServer();
        MainRouter mainRouter = new MainRouter();

        HttpServer server = mainServer.create();
        Router router = mainRouter.create();

        server.requestHandler(router::accept).listen(8000);


    }

}
