
$(document).ready(function(){
  $('.editIcon').click(function(e){
    var parent =  $(e.target).parents('.card');
    var target = parent[0].children[5];
    $(target).toggle();
  });
});

$(document).ready(function(){
	  $('.deleteIcon').click(function(e){
		  var r = confirm("Are you sure you want to delete this note?");
		  if (r != true) {
			  return false;
		  }
		  
	  });
	});
