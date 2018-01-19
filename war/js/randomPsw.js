//随机密码
function getRandomNum(lbound, ubound) {
	return (Math.floor(Math.random() * (ubound - lbound)) + lbound);
}
function getRandomChar() {
	// var numberChars = "0123456789";
	// var lowerChars = "abcdefghijklmnopqrstuvwxyz";
	var upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var charSet = "";

	// charSet += numberChars;

	// charSet += lowerChars;

	charSet += upperChars;
	return charSet.charAt(getRandomNum(0, charSet.length));
}