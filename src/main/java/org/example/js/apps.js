const realAge2 = parseInt(prompt("How old are you?"));

if (isNaN(realAge2)) {
    console.log("Please write a number"); //숫자가 아닌걸 입력
} else if (realAge2 >= 18 && realAge2 <= 50) {
    console.log("Your age is " + realAge2.valueOf() + ". You can drink.");
} else {
    console.log("Your can't drink.");
}