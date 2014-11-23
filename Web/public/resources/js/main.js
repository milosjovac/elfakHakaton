var app = angular.module('app', [
  'ngRoute'
]);

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
    // Home
    .when("/", {templateUrl: "/resources/templates/home.html", controller: "PageCtrl"})
    // Pages
    .when("/about", {templateUrl: "/resources/templates/about.html", controller: "PageCtrl"})
    .when("/faq", {templateUrl: "/resources/templates/faq.html", controller: "PageCtrl"})
    .when("/pricing", {templateUrl: "/resources/templates/pricing.html", controller: "PageCtrl"})
    .when("/services", {templateUrl: "/resources/templates/services.html", controller: "PageCtrl"})
    .when("/contact", {templateUrl: "/resources/templates/contact.html", controller: "PageCtrl"})
    // Blog
    .when("/blog", {templateUrl: "/resources/templates/blog.html", controller: "BlogCtrl"})
    .when("/blog/post", {templateUrl: "/resources/templates/blog_item.html", controller: "BlogCtrl"})
    // else 404
    .otherwise("/404", {templateUrl: "/resources/templates/404.html", controller: "PageCtrl"});
}]);

/**
 * Controls the Blog
 */
app.controller('BlogCtrl', function (/* $scope, $location, $http */) {
  console.log("Blog Controller reporting for duty.");
});

/**
 * Controls all other Pages
 */
app.controller('PageCtrl', function (/* $scope, $location, $http */) {
  console.log("Page Controller reporting for duty.");

  // Activates the Carousel
  $('.carousel').carousel({
    interval: 5000
  });

  // Activates Tooltips for Social Links
  $('.tooltip-social').tooltip({
    selector: "a[data-toggle=tooltip]"
  })
});