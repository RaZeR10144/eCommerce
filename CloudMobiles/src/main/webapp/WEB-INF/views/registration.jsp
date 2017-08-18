<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row centered-form">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 class="panel-title">
						Sign Up <small>for registration!</small>
					</h4>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="user" action="register" method="POST">
					
					
						<div class="form-group">
							<label class="control-label col-md-4" for="name">First Name :- </label>
							<div class="col-md-8">							
								<input type="text" name="firstName" 
									class="form-control" placeholder="First Name"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Last Name :- </label>
							<div class="col-md-8">							
								<input type="text" name="lastName" 
									class="form-control" placeholder="Last Name"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="address">Addresss :- </label>
							<div class="col-md-8">							
								<input type="text" name="address" 
									class="form-control" placeholder="Address"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Email :- </label>
							<div class="col-md-8">							
								<input type="text" name="email" 
									class="form-control" placeholder="abc@xyz.com"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Contact Number :- </label>
							<div class="col-md-8">							
								<input type="text" name="contactNumber" 
									class="form-control" placeholder="XXXXXXXXXX" maxlength="10"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Password :- </label>
							<div class="col-md-8">							
								<input type="password" name="password" 
									class="form-control" placeholder="Password"/>
							</div>
						</div>
						
						<!-- Radio button using bootstrap class of radio-inline -->
						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
								<label class="radio-inline">
									<input type="radio" name="role" value="USER" checked="checked"/> User
								</label>
								<label class="radio-inline">
									<input type="radio" name="role" value="SUPPLIER" /> Supplier
								</label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="subit" value="Submit" class="btn btn-primary"/>
							</div>
						</div>		

					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>