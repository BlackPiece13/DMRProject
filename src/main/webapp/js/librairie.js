




$(document).ready(function() {

	// Map to store the number of product selected per media
	var produits = new Object();
	produits["p1"] = 0;
	produits["p2"] = 0;
	produits["p3"] = 0;
	// Variable to store the total number of media selected by the user
	var nbProduits = 0;



	// Connection management //////////////////////////////////////////////////////////////////////

	// Event listener on 'show-connect' button to toggle the login form
	$("#show-login").click(function() {
		console.log("showing login ");
		$("#connection").slideToggle();
	});

	// Event listener on login button to validate and submit the login/password
	$("#login").click(function() {
		setCookie("login", $("#input-login").val() , 1);
		setCookie("sessionType", $("#select-type").val(), 1);
		updateVisibility();
		$("#connection").slideToggle();
	});

	// Event listenr on logout button to remove cookies
	$("#logout").click(function() {
		deleteCookie("login");
		deleteCookie("sessionType");
		updateVisibility();
	});

	// hide elements according to cookies
	updateVisibility();



	// Media management ///////////////////////////////////////////////////////////////////////////

	// Listener on "add" button
	$("#add").click(function(){
		$("#addMedia").slideToggle();
	});


	// Media selection managment ///////////////////////////////////////////////////////////////////

	// Listener on the + and - buttons of the products
	$(".p-button,.m-button").click(function(){
		var pid = $(this).attr("id").substring(0, $(this).attr("id").length-2);
		produits[pid] += ($(this).text() == "+") ? 1 : -1;
		nbProduits += ($(this).text() == "+") ? 1 : -1;
		updateMediaVisibility(pid);
		$("#"+pid+"-i").val(produits[pid]);
	});

	// Listener on the media inputs
	$(".media-input").change(function() {
		var id = $(this).attr("id").split("-")[0];
		var val = parseInt($(this).val());
		nbProduits -= produits[id];
		produits[id] = Math.max(isNaN(val) ? 0 : val, 0);
		nbProduits += produits[id];
		updateMediaVisibility(id);
	});



	// Visibility control methods /////////////////////////////////////////////////////////////////////

	function updateMediaVisibility(id) {
		if (getCookie("sessionType") == "user") {
			if (produits[id] > 0) {
				$("#"+id+"-i").show();
				$("#"+id+"-m").show();
			} else {
				$("#"+id+"-i").hide();
				$("#"+id+"-m").hide();
			}
			if (nbProduits > 0)
				$("#order").html("Order (" + nbProduits + ")").show();
			else
				$("#order").hide();
		} else {
			$("#"+id+"-p").hide();
			$("#"+id+"-i").hide();
			$("#"+id+"-m").hide();
		}
	}


	function updateVisibility() {
		var login = getCookie("login");
		var type = getCookie("sessionType");
		if (login == "") {
			$(".user").hide();
			$(".admin").hide();
			$("#order").hide();
			$("#logout").hide();
			$("#show-login").show();
		} else {
			$("#logout").show();
			$("#show-login").hide();
			if (type == "admin") {
				$(".user").hide();
				$(".admin").show();
				$("#order").hide();
			} else if (type == "user") {
				$(".user").show();
				$(".admin").hide();
				if (nbProduits > 0)
					$("#order").html("Order (" + nbProduits + ")").show();
				else
					$("#order").hide();
			}
		}
		for (var id of Object.keys(produits)) {
			updateMediaVisibility(id);
		}
	}



});


// W3schools function to manipulate coockies //////////////////////////////////////////////////////

function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires="+d.toUTCString();
	document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for(var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

function deleteCookie(cname) {
	document.cookie = cname + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}