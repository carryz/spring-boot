// $(function() {
//
// 	// Get the form.
// 	var form = $('#contact-form');
//
// 	// Get the messages div.
// 	var formMessages = $('.form-messege');
//
// 	// Set up an event listener for the contact form.
// 	$(form).submit(function(e) {
// 		// Stop the browser from submitting the form.
// 		e.preventDefault();
//
// 		// Serialize the form data.
// 		var formData = $(form).serialize();
//
// 		// Submit the form using AJAX.
// 		$.ajax({
// 			type: 'POST',
// 			url: $(form).attr('action'),
// 			data: formData
// 		})
// 		.done(function(response) {
// 			// Make sure that the formMessages div has the 'success' class.
// 			$(formMessages).removeClass('error');
// 			$(formMessages).addClass('success');
//
// 			// Set the message text.
// 			$(formMessages).text(response);
//
// 			// Clear the form.
// 			$('#contact-form input[type="text"],#contact-form input[type="email"],#contact-form textarea').val('');
// 		})
// 		.fail(function(data) {
// 			// Make sure that the formMessages div has the 'error' class.
// 			$(formMessages).removeClass('success');
// 			$(formMessages).addClass('error');
//
// 			// Set the message text.
// 			if (data.responseText !== '') {
// 				$(formMessages).text(data.responseText);
// 			} else {
// 				$(formMessages).text('Oops! An error occured and your message could not be sent.');
// 			}
// 		});
// 	});
//
// });

// $(document).ready(function () {
// });

function getmoney() {

    alert($("#begin").val());
    alert($("#end").val());
	if($("#begin").val()!=null && $("#end").val() != null){
		if($("#begin").val()>$("#end").val()){
			alert("开始时间不能大于结束时间");
		}
		else{
			alert(((("#begin").val().getDate()-($("#end").val()).getDate())).toString());
		}
	}

}