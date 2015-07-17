 function getChildDetails(){
                
                          
                       var chwid = document.getElementById("chwid").value;   
//                    alert(chwid);

                if(document.getElementById("chwid").value!=""){  
                
                    $.ajax({  
                        url:"loadclients?chwid="+chwid,  
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                       
                            document.getElementById("data-table").innerHTML=data.view;
                     
                           alert(chwid);
				$('#data-table').dataTable().makeEditable({
                               "aoColumns": [ null,null,null ]    
                          
                       	});
				
			
                        }
                    }); 
                
                }//end of if
                
               
                
            }
            
            

       