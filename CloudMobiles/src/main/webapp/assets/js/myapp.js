$(function() {
	//solving active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Registration':
		$('#registration').addClass('active');
		break;
	case 'View Products':
		$('#listProducts').addClass('active');
		break;
	case 'Login':
		$('#login').addClass('active');
		break;
	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active'); 
		break;
	}
	
})