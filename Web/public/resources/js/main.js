var app = angular.module('app', [
  'ngRoute'
]);

/**
 * Configure the Routes
 */
app.config(['$routeProvider', function ($routeProvider) {
  $routeProvider
    // News Feed page
    .when("/", {
          templateUrl: "/modules/newsFeeds/home.html",
          controller: "FeedsCtrl"})
    // Pages
    .when("/about", {
          templateUrl: "/resources/templates/about.html",
          controller: "PageCtrl"})
    .when("/faq", {
          templateUrl: "/resources/templates/faq.html",
          controller: "PageCtrl"})
    .when("/pricing", {
          templateUrl: "/resources/templates/pricing.html",
          controller: "PageCtrl"})
    .when("/services", {
          templateUrl: "/resources/templates/services.html",
          controller: "PageCtrl"})
    .when("/contact", {
          templateUrl: "/resources/templates/contact.html",
          controller: "PageCtrl"})
    // Blog
    .when("/blog", {
          templateUrl: "/resources/templates/blog.html",
          controller: "BlogCtrl"})
    .when("/blog/post", {
          templateUrl: "/resources/templates/blog_item.html",
          controller: "BlogCtrl"})
    // else 404
    .otherwise("/404", {
          templateUrl: "/resources/templates/404.html",
          controller: "PageCtrl"});
}]);
