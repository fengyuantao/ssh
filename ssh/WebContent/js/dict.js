    function addselect(typeCode,postionId,selectName,selectedId){
    	// 创建一个选择对象
    	var $select = $("<select name="+selectName+" ></select>");
    	// 往select选择器里面最佳默认选项
    	$select.append($("<option value=''>---请选择---</option>"));
    	// ajax 获取code指定的数据
    	$.ajax(
    			{
    				url:"${pageContext.request.contextPath }/baseDictAction_execute",
    				type:"post",
    				data:{"code":typeCode},
    				success:function(data){
    					$(data[0]["success"]).each(function(index,element){
    						//alert(element["dict_item_name"]);
    						var $options = $("<option value='"+element["dict_id"]+"'>"+ element["dict_item_name"] +"</option>");
    						$select.append($options);
    						
    						// 判断是否回显
    						if(element["dict_id"] == selectedId){
    							$options.attr("selected","selected");
    						}
    						
    					});
    					//alert(data[0]["success"][0]["dict_item_name"]);
    				},
    				dataType:"json"
    			}
    	);
    	
    	
    	
    	//往positionId里面加入select
    	$("#"+postionId).append($select);
    }
