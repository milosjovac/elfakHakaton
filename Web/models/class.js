/**
 * Created by MilenCHE on 11/23/2014.
 */
var mongoose = require('mongoose');
var crypto = require('crypto');

/* Schema for profile data. */

var classSchema = mongoose.Schema({
    theme: String,
    tags: [String],
<<<<<<< HEAD
=======

>>>>>>> ae1cc78c67403839e34f737c3c85f164dbe26d1e
    teacher: String,
    date_time: Date,
    max_students: Number,
    students: [String]
});

module.exports = mongoose.model("Class", classSchema);
