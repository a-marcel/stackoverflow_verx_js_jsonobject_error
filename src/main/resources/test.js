exports.vertxStartAsync = function(startFuture) {
	console.log("ok");

	var io = Packages.io;
	var JsonObject = io.vertx.core.json.JsonObject;

	var TestObject = Packages.vertx_js_eventbus.TestObject;

	var eb = vertx.eventBus()
	var consumer = eb.consumer('reactWebChannel', function(message) {
		console.log("drin");
		
		var o = new TestObject();

		eb.send("test", {}, function(ar, ar_err) {
			console.log("drin2")

			// message.reply()
		});
	});

	consumer.completionHandler(function(res, res_err) {
		if (res_err == null) {
			console.log('The handler registration has reached all nodes')

			startFuture.complete()
		} else {
			console.log('Registration failed!')

			startFuture.fail()
		}
	});
}