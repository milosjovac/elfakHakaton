/**
 * Created by MilenCHE on 11/23/2014.
 */
var mongoose = require('mongoose');

/* Schema for profile data. */

var classSchema = mongoose.Schema({
    theme: String,
    tags: [String],
    teacher: Schema.Types.ObjectId,
    date_time: Date,
    max_students: Number,
    students: [Schema.Types.ObjectId]
});

module.exports = mongoose.model("Class", classSchema);