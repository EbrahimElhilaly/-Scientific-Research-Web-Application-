(function ($j) {

    // doaa//
    var path1 = localStorage.getItem("path");
   // alert("path1 >>> " + path1);
   
                
  /* new design */
  var theme = localStorage.getItem("theme");
  if(!theme){
    theme='blue';
  }
  $("#switch_style").attr("href", path1+"/resources/css/" + theme + ".css");
  /* end: new design */
  
  switch_style = {

    onReady: function () {      
      this.switch_style_click();
    },
    
    switch_style_click: function(){
    	$(".box").click(function(){
    		var id = $(this).attr("id");
    // alert("id >>> " + id);
       
       // doaa//
    var path = $(this).attr("title");
   // alert("path2 >>> " + path);
    localStorage.setItem("path" , path);
    // end: doaa//
       
                /* new design */
                localStorage.setItem("theme", id);
                /* end: new design */
                
    		$("#switch_style").attr("href", path+"/resources/css/"+ id + ".css");    	
                   
    	});
    },
    
  };

  $j().ready(function () {
	  switch_style.onReady();
  });

})(jQuery);	
