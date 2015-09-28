var app= angular.module('Prod',[]);
app.controller('ProdController',function($scope,$http){
	$scope.nomp='';
	$scope.descriptionp='';
	$scope.prixp='';
	$scope.edit=true;
	$scope.error=false;
	$scope.imcomplete=false;
	$scope.produit=[];
	$scope.motcle='';
	$scope.pagecourrante=0;
	$scope.charger=function(){
		$http.get("http://localhost:9191/produitparmc?mc="+$scope.motcle+"&page="+$scope.pagecourrante)
		.success(function(data){
			$scope.produit=data;
			$scope.pages=new Array(data.totalPages);
		});
	};
	
	$scope.gotoPage=function(p){
		$scope.pagecourrante=p;
		$scope.charger();
	};
	
	$scope.editProduit=function(reference){
		if(reference=='new'){
			$scope.edit=true;
			$scope.error=true;
			$scope.imcomplete=true;
			
		}
	};

	
	
	$scope.$watch('nomp', function() {$scope.test();});
	$scope.$watch('descriptionp', function() {$scope.test();});
	$scope.$watch('prixp', function() {$scope.test();});
	
	
	$scope.test = function() {
		  $scope.incomplete = false;
		  if ($scope.edit && (!$scope.nomp.length ||
		  !$scope.descriptionp.length ||
		  !$scope.prixp.length )) {
		     $scope.incomplete = true;
		  }
		};


		$scope.save=function(){
			if($scope.incomplete==true  ){
				$http.get("http://localhost:9191/save?nom="+$scope.nomp+"&description="+descriptionp+"&prix="+$scope.prixp)
					.success(function(data){
					alert("success");
				});
			}
		};
	
	
});
