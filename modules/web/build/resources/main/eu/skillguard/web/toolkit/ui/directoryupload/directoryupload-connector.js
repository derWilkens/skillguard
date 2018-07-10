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
	        connector.filesSelected(file);
	    }
	    
	}, false);
	
}