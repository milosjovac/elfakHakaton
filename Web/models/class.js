/**
 * Created by MilenCHE on 11/23/2014.
 */
var mongoose = require('mongoose');
var crypto = require('crypto');

/* Schema for profile data. */

var profileSchema = mongoose.Schema({
    theme: String,
    tags: [String],
<<<<<<< HEAD
    teacher: String,
    date_time: Date,
    max_students: Number,
    students: [String]
=======
    teacher
>>>>>>> 277f45e2af2e4d3d583155bc7d3f25e51df19e93
});

module.exports = mongoose.model("Profile", profileSchema);
