/**
 * Created by MilenCHE on 11/23/2014.
 */
var mongoose = require('mongoose');

/* Schema for profile data. */

var commentSchema = mongoose.Schema({
    text: String,
    theme: Schema.Type.ObjectId,
    profile: Schema.Types.ObjectId
});

module.exports = mongoose.model("Comment", commentSchema);