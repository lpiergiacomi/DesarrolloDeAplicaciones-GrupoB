angular.module("subiQueTeLlevoApp")
.controller("ProductController", function ($scope, $http, $rootScope) {
	'use strict';


    $scope.productUrl = $rootScope.baseUrl +"/products/"
    $scope.productFind;
    $scope.productNew = {"name": "", "stock":"", "cost":""};
    $scope.hideProductForm = true;


    $scope.showProductForm= function(){
        $scope.hideProductForm = false;
    };

    $scope.resetProductForm=function(){
        $scope.productNew = {"name": "", "stock":"","cost":""};
        $scope.hideProductForm = true;
    };

    $scope.saveProductForm= function(product){
        $http.post($scope.productUrl,
                {"name": product.name, "stock": product.stock, "cost": product.cost})
        .success(function(data){
            $scope.productNew = {"name": "", "stock":"","cost":""};
            $scope.hideProductForm = true;
            $scope.getAllProducts();
        });
    };

    $scope.getAllProducts= function(){
        $http.get($scope.productUrl + "all")
            .success(function(data){
                $scope.allProducts = data;
            });
    };

    $scope.findProduct = function(productName){
        $http.get($scope.productUrl + productName)
            .success(function(data){
                $scope.allProducts = [data];
            });
    };

    $scope.getAllProducts();
});
