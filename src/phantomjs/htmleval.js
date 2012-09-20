var args = phantom.args;
var url = 'http://www.google.com';
if (args.length >= 1) url = args[0];
var wp = require('webpage');
var page = wp.create();
page.open(url, function (status) {
    var content = page.evaluate(function () {
	return document.body.innerHTML;
    });
    console.log(content);
    phantom.exit();
});
