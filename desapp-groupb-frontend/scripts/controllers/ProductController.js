app.controller("ProductController", ['$scope', '$http', function ($scope, $http) {
	'use strict';

    $scope.baseUrl = "http://localhost:8080/sqtl/products/";
    $scope.productFind;
    $scope.productNew= {"name": "", "stock":"", "cost":""};
    $scope.hideProductForm = true;

    $scope.showProductForm= function(){
        $scope.hideProductForm = false;
    };

    $scope.resetProductForm=function(){
        $scope.productNew = {"name": "", "stock":"","cost":""};
        $scope.hideProductForm = true;
    };

    $scope.saveProductForm= function(product){
        $http.post($scope.baseUrl,
                {"name": product.name, "stock": product.stock, "cost": product.cost})
        .success(function(data){
            $scope.productNew = {"name": "", "stock":"","cost":""};
            $scope.hideProductForm = true;
            $scope.getAllProducts();           
        });
    };

    $scope.getAllProducts= function(){
        $http.get($scope.baseUrl + "all")
            .success(function(data){
                $scope.allProducts = data;
            });
    };

    $scope.findProduct = function(productName){
        $http.get($scope.baseUrl + productName)
            .success(function(data){
                $scope.allProducts = [data];
            });
    };

    $scope.getAllProducts();
}]);