/**
 * Created by MilenCHE on 11/23/2014.
 */
var express = require('express');
var router = express.Router();

var clas = require('../models/class');
var profile = require('../models/profile');
var tag = require('../models/tag');
var comment = require('../models/comment');

router.post('/class', function(req, res) {
    console.log(req.body);
    clas.findOne({'theme': req.body.theme}, function(err, classes){
        if(err){
            console.log(err);
            return;
        }

        if(classes) {
            res.send(new clas());
            return;
        }


        console.log(req.body);
        var newClass = new clas();

        newClass.teacher = req.body.teacher;
        newClass.theme = req.body.theme;
        newClass.tags = req.body.tags;
        newClass.date_time = req.body.date_time;
        newClass.max_students = req.body.max_students;
        newClass.students = req.body.students;

        newClass.save(function(err, returnClass){
            if(err)
            {
                console.log(err);
            }

            var ret = {"class_id" : returnClass._id}
            res.send(ret);

        })
    })
});

router.get('/class', function(req, res){
    profile.findOne({'_id': req.body._id}, function(err, user){
        var ret = [];

        user.tags.forEach(function(entry){
            tag.findOne({'tag': entry}, function(err, found){
                found.classes.forEach(function(cls) {
                    clas.findOne({'_id': cls}, function (err, aclass) {
                        ret.push(aclass);
                    })
                })
            });
        });

        res.send(ret);
    });
});

module.exports = router;
