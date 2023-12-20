// const & let & console.log()
const a = 5;
const b = 2;

let myName = "nico";
//const 로 myName을 정의했다면, 아래에서 새로운 값으로 재정의 할수 없다.

console.log( a + b );
console.log( a * b );
console.log( a / b );
console.log("hello " + myName);

myName = "nicolas";
console.log("your name is " + myName);

//null & undefined
const amIFat = null;
let something;
console.log(amIFat);
console.log(something);

//array
const array = [1, 2, "hello", false, true, undefined];
console.log(array[2]);

//object
const player = {
    name: "nico",
    points: 10,
    fat: true,
    handsome: false,
};
console.log(player);
console.log(player["name"]);
console.log(player.name);

console.log("바꾸기 전: " + player.fat);
player.fat = false;
console.log("바꾼 후: " + player.fat);

player.lastName = "potato"; //특별히 다른 선언을 안해줘도 여기서 바로 속성을 추가할수 있음
console.log(player);


//function
function seyHello(nameOfPerson, age) {
    console.log("Hello! My name is " + nameOfPerson + " and " + age);
}
seyHello("jihyun", 24);
seyHello("mozzi", 4);

const secondPlayer = {
    name: "jihyun",
    seyHello: function (otherPersonsName) {
        console.log("hello!" + otherPersonsName);
    },


};
secondPlayer.seyHello("mozzi");


//return
const age = 96;
function calculateKrAge(ageOfForeigner) {
    return ageOfForeigner + 2;
}

const krAge = calculateKrAge(age);
console.log(krAge);

//형변환
// const realAge = prompt("How old are you?");
// console.log(typeof realAge, typeof parseInt(realAge));

//조건문
const realAge2 = parseInt(prompt("How old are you?"));

if (isNaN(realAge2)) {
    console.log("Please write a number"); //숫자가 아닌걸 입력
} else if (realAge2 >= 18 && realAge2 <= 50) {
    console.log("Your age is " + realAge2.valueOf() + ". You can drink.");
} else {
    console.log("Your can't drink.");
}


