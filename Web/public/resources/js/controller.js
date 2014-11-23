/**
 * Created by JoleX on 23-Nov-2014.
 */
app.controller('FeedsCtrl', function ($scope, $location, $http ) {

    $scope.feeds = [
    {
        'title' : 'Some title',
        'body' : 'Some text',
        'user' :
            {'username': 'pPeric', 'rate' : 200}
        ,
        'tags': ['#s1','#s2'],
        'comments': [
            {'username': 'pPeric', 'comment' : 'This is my comment'},
            {'username': 'pPeric', 'comment' : 'This is my comment'},
            {'username': 'pPeric', 'comment' : 'This is my comment'},
            {'username': 'pPeric', 'comment' : 'This is my comment'},
            {'username': 'pPeric', 'comment' : 'This is my comment'}
        ]

    },

    {'title': 'Some title'}]
    ;


    // Activates the Carousel
    $('.carousel').carousel({
        interval: 5000
    });

    // Activates Tooltips for Social Links
    $('.tooltip-social').tooltip({
        selector: "a[data-toggle=tooltip]"
    })

});

app.controller('TeacherCtrl', function ($scope, $location, $http ) {

});

app.controller('ProfileCtrl', function ($scope, $location, $http ) {

    $http.get('http://10.10.66.245:3000/profile/mita').seccess(function(data){
        //$scope = data;
    });
    $("#interested").select2({closeOnSelect:false});
    $("#teach").select2({closeOnSelect:false});

    $("input").bind('keyup change',function() {
        var $t = $(this);
        var $par = $t.parent();
        var min = $t.attr("data-valid-min");
        var match = $t.attr("data-valid-match");
        var pattern = $t.attr("pattern");

        if (typeof match!="undefined"){
            if ($t.val()!=$('#'+match).val()) {
                $par.removeClass('has-success').addClass('has-error');
            }
            else {
                $par.removeClass('has-error').addClass('has-success');
            }
        }
        else if (!this.checkValidity()) {
            $par.removeClass('has-success').addClass('has-error');
        }
        else {
            $par.removeClass('has-error').addClass('has-success');
        }

        if ($par.hasClass("has-success")) {
            $par.find('.form-control-feedback').removeClass('fade');
        }
        else {
            $par.find('.form-control-feedback').addClass('fade');
        }

    });

    $scope.items = [
        {id:1,tag:'Java'},
        {id:2,tag:'Android'},
        {id:3,tag:'AngularJS'},
        {id:4,tag:'MondoDB'},
        {id:5,tag:'NodeJS'},
    ];
    $scope.rate = 200;
});

app.controller('SBuddyCtrl', function ($scope, $location, $http ) {

});
app.controller('AboutCtrl', function ($scope, $location, $http ) {

});
app.controller('ErrorCtrl', function ($scope, $location, $http ) {

});