var express = require('express');
var router = express.Router();

var passport = require('passport');

var profile = require('../models/profile');

router.get('/:username', function(req, res) {

  Profile.findOne({username: req.params.username}, function(err, profile){
    if(err){
      console.log(err);
      return;
    }

    res.send(profile);
  })
});

router.put('/:username', function(req, res){
  var profile = new Profile();

  profile.first_name = req.body.first_name;
  profile.last_name = req.body.last_name;
  profile.picture = req.body.picture;
  profile.password = req.body.password;
  profile.tags_interested = req.body.tags_interested;
  profile.tags_teach = req.body.tags_teach;

  Profile.findOneAndUpdate({username: req.params.username}, profile, {upsert: true}, function (err, egsistingData){
    if(err){
      console.log(err);
      res.send("{success: false }");
    }

    res.send("{success: true }");
  });
});

module.exports = router;
