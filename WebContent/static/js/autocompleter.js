$(document).ready(function() {
	$(function() {
		$("#search").autocomplete({
			source: function(request, response) {
				$.ajax({
					url: "findUsersByPart.page",
					type: "GET",
					data: {
						term: request.term
					},
					dataType: "json",
					success: function(data) {
						response(data);
					}
				});
			}
		});
	});
});