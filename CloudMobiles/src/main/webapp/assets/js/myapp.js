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
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active'); 
		break;
	}
	
	//code for jquery dataTable
	//create dataset
	var products = [
		
						['1','ABC'],
						['2','PQR'],
						['3','DAU'],
						['4','KHU'],
						['5','GRS'],
						['6','LDS'],
						['7','BDT'],
						['8','NDI']
					];
	var $table = $('#productListTable');
	
	//execute this code only where we have this table
	if($table.length)
		{
			//console.log('Inside the table!');
		
			var jsonUrl = '';
			if(window.categoryId == '')
				{
					jsonUrl = window.contextRoot + '/json/data/all/products';
				}
			else
				{
				jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
				}
			
			$table.DataTable({
				
				lengthMenu: [[3,5,10,-1],['3 Records', '5 Records', '10 Records', 'All']],
				pageLength: 3,
				ajax: {
					url: jsonUrl,
					dataSrc: ''
				},
				columns: [
							{
								data: 'code',
								mRender: function(data, type, row)
											{
												return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
											}
							},
							{
								data: 'name'
							},
							{
								data: 'brand'
							},
							{
								data: 'unitPrice',
								mRender: function(data,type,row)
											{
												return '&#8377 ' + data
											}
							},
							{
								data: 'quantity'
							},
							{
								data: 'id',
								bSortable: false,
								mRender: function(data,type,row)
											{
												var str='';
												str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160; ';
												str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
												return str;
											}
							}
						]
				
			});
		}
	
		
	
})