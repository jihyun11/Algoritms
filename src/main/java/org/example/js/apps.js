//HTML in JS
const title= document.getElementById("title");
console.dir(title);

title.innerText = "Got u!";
console.log(title.innerText);

//searching for Elements
const hellos = document.getElementsByClassName("hello");
console.log(hellos);

const hi = document.getElementsByTagName("h1");
console.log(hi);

const hii = document.querySelector(".hi h1"); //클래스네임(hi)와 그 안에 있는 어떠한것(h1)을 가져올 것인지 명시
console.log(hii); //h1인 요소가 많더라도, 그중 가장 1번째 element만 가져온다.

const hiii = document.querySelectorAll(".hi h1");
console.log(hiii); //h1인 요소가 많을 경우 다 가지고 오고 싶다 -> querySelectorAll 사용하면 됨

//Event
const colorChange = document.querySelector(".hi h1");
colorChange.style.color = "blue";

function handleHiClick() {
    colorChange.style.color = "red";
}

colorChange.addEventListener("click", handleHiClick);

//마우스 올려뒀을때
const mouse = document.querySelector(".mouse h1");

function handleMouseEnter() {
    mouse.style.color = "green";
    console.log("Mouse is here");
}

mouse.addEventListener("mouseenter", handleMouseEnter);

//마우스 올렸을때만
function handleMouseLeave() {
    mouse.style.color = "black";
    console.log("Mouse is leave");
}

mouse.addEventListener("mouseleave", handleMouseLeave);


//onclick vs addEventListener -> 이벤트를 따로 제거 가능해서, 후자가 더 좋긴함
//window

function handleWindowResize() {
    document.body.style.backgroundColor = "tomato";
}

window.addEventListener("resize", handleWindowResize);


//copy

function handleCopy() {
    alert("copier!");
}

window.addEventListener("copy", handleCopy);


//css in Js
const h1 = document.querySelector(".css h1");

function handleH1Click() {
    const currentColor = h1.style.color;
    let newColor;

    if(currentColor === "blue") {
        newColor = "tomato";
    } else {
        newColor = "blue";
    }
    h1.style.color = newColor;
}

h1.addEventListener("click", handleH1Click);

