package vertx_js_eventbus;

import io.vertx.core.json.JsonObject;

public class TestObject {
    private JsonObject json;

    public TestObject() {
	this(new JsonObject());
    }

    public TestObject(TestObject request) {
	this(request.toJson());
    }

    public TestObject(String json) {
	this(new JsonObject(json));
    }

    public TestObject(JsonObject json) {
	this.json = json.copy();
    }

    public JsonObject toJson() {
	return json != null ? json.copy() : new JsonObject();
    }
}
