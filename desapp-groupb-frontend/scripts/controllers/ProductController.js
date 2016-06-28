angular.module("subiQueTeLlevoApp")
.controller("ProductController", function ($scope, $http, $rootScope) {
	'use strict';

    $scope.productUrl = $rootScope.baseUrl +"/products/"
    $scope.productFind;
    $scope.productNew = {"name": "", "stock":"", "cost":""};
    $scope.hideProductForm = true;
    $scope.filteredAllProducts = [];
    $scope.currentPage = 1;
    $scope.itemsPerPage = 10;


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
        $scope.allProducts = [];
        $http.get($scope.productUrl + "all")
            .success(function(data){
                $scope.allProducts = data;
                $scope.totalItems = $scope.allProducts.length;
                $scope.pageChanged();
            });
    };

    $scope.pageChanged = function() {
        var end = $scope.currentPage * $scope.itemsPerPage,
            begin = ($scope.currentPage-1)* $scope.itemsPerPage;
        $scope.filteredAllProducts = $scope.allProducts.slice(begin, end);
    };

    $scope.findProduct = function(productName){
        $http.get($scope.productUrl + productName)
            .success(function(data){
                $scope.allProducts = [data];
            });
    };

    $scope.getAllProducts();
});
