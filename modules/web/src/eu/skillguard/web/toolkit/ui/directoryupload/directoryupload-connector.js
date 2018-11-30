eu_skillguard_web_toolkit_ui_directoryupload_DirectoryUpload = function() {
	var connector = this;
	var element = connector.getElement();
	$(element)
			.html(
					"<input type='file' multiple webkitdirectory id='fileURL'/><div class='row'><h4>Files to upload:</h4><ul id='fileOutput'></ul></div>   ");
	
	var files, 
	    file, 
	    extension, 
	    input = document.getElementById("fileURL"),
	    output = document.getElementById("fileOutput");
	    
	debugger;

	input.addEventListener("change", function (e) {
	    files = e.target.files;
	    output.innerHTML = "";

	    for (var i = 0, len = files.length; i < len; i++) {
	        file = files[i];
	        extension = file.name.split(".").pop();
	        output.innerHTML += "<li class='type-" + extension + "'>" + file.name + " (" +  Math.floor(file.size/1024 * 100)/100 + "KB)</li>";
	        //connector.filesSelected(file);
	        
	        
	        var url = 'http://localhost:8080/app/rest/v2/files?name=' + file.name; // send file name as parameter
	        
	        $.ajax({
	            type: 'POST',
	            url: url,
	            headers: {
	                'Authorization': 'Bearer ' + localStorage._cubaAccessToken // add header with access token
	            },
	            processData: false,
	            contentType: false,
	            dataType: 'json',
	            data: file,
	            success: function (data) {
	                alert('Upload successful');

	                $('#uploadedFile').attr('src',
	                    'http://localhost:8080/app/rest/v2/files/' + data.id + '?access_token=' + localStorage._cubaAccessToken); // update image url
	                $('#uploadedFile').show();
	            }
	        });
	    }
	    
	}, false);
	
}