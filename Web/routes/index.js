var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res) {
  if(req.isAuthenticated())
    res.render('index', { title: 'Express' });

  res.redirect("/login");
});

module.exports = router;
