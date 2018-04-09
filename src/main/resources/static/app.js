var ws;
function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	//connect to stomp where stomp endpoint is exposed
	var socket = new WebSocket("ws://localhost:8080/greeting");
	ws = Stomp.over(socket);

	ws.connect({}, function(frame) {
		ws.subscribe("/user/queue/errors", function(message) {
			alert("Error " + message.body);
		});

		ws.subscribe("/user/queue/reply", function(message) {
			showGreeting(message.body);
		});
	}, function(error) {
		alert("STOMP error " + error);
	});
}

function disconnect() {
	if (ws != null) {
		ws.close();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendPrice() {
	var data = JSON.stringify({
		'price' : $("#price").val()
	})
	ws.send("/app/message", function (m) {console.log('succ')}, data);
}

function showGreeting(message) {
	console.log(message);
	var message = JSON.parse(message);
	console.log(message.lastPrice);
	console.log(message['listPrice']);
	$("#greetings").empty();
	for(var i = 0; i < message['listPrice'].length; i++){
		
		$("#greetings").append("<tr><td> "+ (i+1) +" </td><td> " + message['listPrice'][i] + "</td></tr>");
	}
	
	
	$("#averageVal").html(message.averagePrice);
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		//connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendPrice();
	});
});
