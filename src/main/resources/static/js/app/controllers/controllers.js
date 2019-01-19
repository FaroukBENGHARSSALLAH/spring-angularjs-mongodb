

	app.controller('HomeController', function ($sce, $http, $scope) {
		
		    $http.get("/vidulum/reset", {responseType: 'text'}).then(function(data){
		    	   $scope.videohtml =  $sce.trustAsHtml(data.data) ;
		    });	
		    
	   });
	
	
	app.controller('optionController', function ($http, $scope, $location) {
		
		
		$http.get("/vidulum/option/all").then(function(data){
			$scope.options = data.data;
    	       });	
		
		$scope.buy = function(optionRef){
		    var optionRef = (optionRef.length > 0) ? optionRef : '';
	 	    $http.get("/vidulum/option/buy?optionReference=" + optionRef + "&portfolioReference=1").success(function(data){
	 		$scope.options = data.data;
	 		$location.path( "/portfolio");
	 	          });
		};
		    
	});
	
	
		app.controller('portfolioController', function ($http, $scope) {	
			 	    $http.get("/vidulum/portfolio/get?portfolioReference=1").success(function(data){
			 		$scope.portfolio = data;
			 	       });
      });
		    
	