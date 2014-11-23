/**
 * Created by MilenCHE on 11/23/2014.
 */
var mongoose = require('mongoose');

/* Schema for profile data. */

var classSchema = mongoose.Schema({
    theme: String,
    tags: [String],
    teacher: String,
    date_time: Date,
    max_students: Number,
    students: [String]
});

module.exports = mongoose.model("Class", classSchema);