<script>
	var sales = [[
	              
		
	
				[ 1 ,16000.0 ]
					
		
	
	                ]];
	

		window.onload = function(){
		Flotr.draw(document.getElementById("chart"),
				sales,
				{
				title: "Daily Sales in USD",
				
			 	bars:{
			 		show:true,
			 		barwidth:.5
					 	},
				yaxis:{
					min:0,
					
				},
			
				grid: {
					horizontalLines: false,
					verticalLines: false
					
				}
				 	}
		);
	};
</script>




<div class="dashboard">

Number of Customers: <input type="textarea" value=" <c:out value="${dashboard['customers']}"/>"/>
Number of Active Subscriptions: <c:out value="${dashboard['active']}"/>
Number of Cancelled Subscriptions: <c:out value="${dashboard['inactive']}"/>
Number of Orders: <c:out value="${dashboard['orders']}"/>
Total Sales : $  <c:out value="${dashboard['sales']}"/>
</div>


<div id="chart" style="width:600px; height:300px;"></div>

<script src="flotr2.min.js"></script>

