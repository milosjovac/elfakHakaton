/**
 * Created by MilenCHE on 11/23/2014.
 */
var mongoose = require('mongoose');
var crypto = require('crypto');

/* Schema for profile data. */

var profileSchema = mongoose.Schema({
    theme: String,
    tags: [String],
    teacher
});

module.exports = mongoose.model("Profile", profileSchema);