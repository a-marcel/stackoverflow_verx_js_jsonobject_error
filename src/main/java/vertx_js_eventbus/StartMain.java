package vertx_js_eventbus;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import io.vertx.core.AbstractVerticle;

public class StartMain extends AbstractVerticle {

    public void start() {

	vertx.eventBus().registerDefaultCodec(TestObject.class, new TestObjectCodec());

	vertx.deployVerticle("test.js", (ar) -> {
	    vertx.eventBus().send("reactWebChannel", new JsonObject());
	});
    }

    public static void main(String[] args) {
	Vertx.factory.vertx().deployVerticle(StartMain.class.getName());
    }
}
