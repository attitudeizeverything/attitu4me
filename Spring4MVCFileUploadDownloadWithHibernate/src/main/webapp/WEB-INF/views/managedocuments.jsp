<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Upload/Download/Delete Documents</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
         var numbers;
            function sayHello(id)
			{       
			   
			   //var x=document.getElementById(id).checked;
			   if(document.getElementById(id).checked)
			   {
			     numbers=id;
			   }
			   /*else{
			   numbers.splice(numbers.indexOf(id),1);
			   }*/
			    
            }
		 
		 $(document).ready(function(){
         $("#myBtn").click(function(){
         $("#myModal").modal();
		var mymodal=$('#myModal');
		mymodal.find('.modal-body').text(numbers);
		});
	});
	<!--  submit json-->
	var id;
	function sendData() {
		var e=document.getElementById('ct');
    $.ajax({
        url: 'http://localhost:8080/Spring4MVCFileUploadDownloadWithHibernate/deviceLocation?cityName="'+e.options[e.selectedIndex].value+'"',
        type: 'POST',
		data:'',
        dataType: 'json',
		success:function(response){
			                   for(var i=0;i<response.length;i++)
							   {
							   $('#location').append($('<option id='+response[i].id+'>'+response[i].devceLocationName+'</option>'));
							   
							   }
							   console.log(response);
                            }
    });
	
	
}
function getDevices() {
	var e=document.getElementById('location');
    $.ajax({
        url: 'http://localhost:8080/Spring4MVCFileUploadDownloadWithHibernate/devices?deviceLocationId=' + e.options[e.selectedIndex].id,
        type: 'POST',
		data:'',
        dataType: 'json',
		success:function(response){ 
                             for(var i=0;i<response.length;i++)
							   {
							   $('#devices').append($('<option id='+response[i].id+'>'+response[i].deviceLocation.devceLocationName+' - '+response[i].deviceName+'</option>'));
							   //$('#image').html('<img src='+ response[i].deviceImageLocation+' width="42" height="42" />"');
							   }
							 console.log(response);
                            }
    });
}

function postJson() {
	var scdate=document.getElementById('scdate');
	var did=document.getElementById('devices');
	var markers = { "date": document.getElementById('scdate').value, "deviceId": did.options[did.selectedIndex].id,"contnetId":numbers};

    $.ajax({
        url: 'http://localhost:8080/Spring4MVCFileUploadDownloadWithHibernate/saveContents',
        type: 'POST',
		contentType:'application/json',
		data:JSON.stringify(markers),
        dataType: 'json',
		success: function(data){alert(data);
		console.log(data);},
        failure: function(errMsg) {alert(errMsg);
		console.log(data);}
    });
}

      </script>
  
    
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Documents </span></div>
		  	<div class="tablecontainer">
				<table class="table table-hover">
		    		<thead>
			      		<tr>
					        <th>No.</th>
					        <th>File Name</th>
					        <th>Type</th>
					        <th>Description</th>
					        <th width="100"></th>
					        <th width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${documents}" var="doc" varStatus="counter">
						<tr>
							<td>${counter.index + 1}</td>
							<td>${doc.name}</td>
							<td>${doc.type}</td>
							<td>${doc.description}</td>
							<td><input type="radio" id="${doc.id}" name="test" onclick="sayHello(${doc.id})"></td>
							<td><a href="<c:url value='/download-document-${user.id}-${doc.id}' />" class="btn btn-success custom-width">download</a></td>
							<td><a href="<c:url value='/delete-document-${user.id}-${doc.id}' />" class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
			
			<div class="container">
  
  <!-- Trigger the modal with a button -->
  <div>
  <button type="button" class="btn btn-info btn-lg" id="myBtn" align="right">schedule Campaign</button>
</div>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">schedule Campaign</h4>
        </div>
		<div>
		<table cellspacing="10" border="0" width="100%">
  <tr>
    <th>City</th>
    <th>Places</th>
	<th>Devices</th>
	<th>DATE</th>
  </tr>
  <tr>
    <td><select id="ct" onChange="sendData();">
  <option value="Bangalore">BANGALORE</option>
  <option value="Delhi">DELHI</option>
  <option value="Haveri">HAVERI</option>
</select></td>
<td> <select id="location" onChange="getDevices();">
</select> </td>
<td> <select id="devices"></select> </td>
<td><input type="date" name="bdaytime" id="scdate"></td>
  </tr>
</table>
</div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
		  
        </div>
        <div class="modal-footer">
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" onclick="postJson()" >Schedule Campaign</button>
          </div>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
			
		</div>
		
		
		


		
		
		
		<div class="panel panel-default">
			
			<div class="panel-heading"><span class="lead">Upload New Document</span></div>
			<div class="uploadcontainer">
				<form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
			
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Upload a document</label>
							<div class="col-md-7">
								<form:input type="file" path="file" id="file" class="form-control input-sm"/>
								<div class="has-error">
									<form:errors path="file" class="help-inline"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Description</label>
							<div class="col-md-7">
								<form:input type="text" path="description" id="description" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
			
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Upload" class="btn btn-primary btn-sm">
						</div>
					</div>
	
				</form:form>
				</div>
		</div>
	 	<div class="well">
	 		Go to <a href="<c:url value='/list' />">Users List</a>
	 	</div>
   	</div>
</body>
</html>