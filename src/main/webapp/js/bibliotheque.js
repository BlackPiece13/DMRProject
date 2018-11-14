$(document).ready(function() {
	/* Ajax */
	$("#search-input").keyup(function() {
		$.ajax({
			url : 'search',
			data : {
				"input-value" : $("#search-input").val()
			},
			type : 'GET',
			"error" : function(xhr, status, error) {
				console.log("code erruer " + error);
			},
			"success" : function(data, status, xhr) {

			}
		});
	});

	$("#login-button").click(function() {
		$.ajax({
			url : 'login',
			data : {
				"login" : $("#login").val(),
				"password" : $("#password").val()
			},
			type : 'POST',
			"error" : function(xhr, status, error) {
				$("#error-label").html(xhr.responseText);
			},
			"success" : function(data, status, xhr) {

			}
		});
	});

	$(".remove-button").click(function() {
		alert();
		// $.ajax({
		// url : 'removeMedia',
		// data : {
		// "button-id" : this.id,
		// },
		// type : 'POST',
		// "error" : function(xhr, status, error) {
		//
		// },
		// "success" : function(data, status, xhr) {
		// location.href = "https://www.w3schools.com";
		// }
		// });
	});

});