var cartApp1 = angular.module("cartApp",[]);
let cartApp = angular.module("cartApp",[]);

cartApp.controller("cartCtrl", function ($scope,$http){
    $scope.refreshCart = function (cartId){
        $http.get('/eMusic/rest/cart/'+$scope.cartId).success(function (data){
            $scope.cart = data;
        });
    };
    $scope.clearCart = function (){
        $http.delete('/eMusic/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId){
        $http.put('/eMusic/rest/cart/add/'+productId).success(function (data){
            $scope.refreshCart($http.get('/eMusic/rest/cart/cartId'));
            alert("Product successfully added to the cart!")
        });
    };

    $scope.removeFromCart = function (productId){
        $http.put('/eMusic/rest/cart/remove/'+productId).success(function (data){
            $scope.refreshCart($http.get('/eMusic/rest/cart/cartId'));
        });
    };
});