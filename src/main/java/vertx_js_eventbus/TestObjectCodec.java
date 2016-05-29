package vertx_js_eventbus;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.JsonObject;

public class TestObjectCodec implements MessageCodec<TestObject, TestObject> {
    @Override
    public void encodeToWire(Buffer buffer, TestObject s) {
	s.toJson().writeToBuffer(buffer);

    }

    @Override
    public TestObject decodeFromWire(int pos, Buffer buffer) {
	JsonObject o = new JsonObject();
	o.readFromBuffer(pos, buffer);

	return new TestObject(o);
    }

    @Override
    public TestObject transform(TestObject s) {
	return s;
    }

    @Override
    public String name() {
	return this.getClass().getSimpleName();
    }

    @Override
    public byte systemCodecID() {
	return -1;
    }
}
