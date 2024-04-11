const loginInput = document.querySelector("#login-form input");
const loginForm = document.querySelector("#login-form");
const greeting = document.querySelector("#greeting");
const loggedInUser = localStorage.getItem('username');
const logoutBtn = document.querySelector('#logout-btn');



const HIDDEN_CLASSNAME = "hidden";
const USERNAME_KEY = "username";

function onLoginSubmit(event) {
    event.preventDefault(); //submit 될때마다 새로고침되는 것을 막음
    const username = loginInput.value;
    localStorage.setItem(USERNAME_KEY, username); //localStorage에 username정보 저장 (세션 같은 존재)
    loginForm.classList.add(HIDDEN_CLASSNAME); //클래스네임에 hidden을 추가하여, 로그인하면 로그인폼이 안보이게 한다
    paintGreetings(username);
}

function paintGreetings(username) { //로그인 성공 시, 화면에 성공함을 표시하는 함수
    greeting.classList.remove(HIDDEN_CLASSNAME);
    greeting.innerText = `Hello, ${username}`;
}

const savedUsername = localStorage.getItem(USERNAME_KEY);
if (savedUsername === null) { //localstorage에 저쟝된 값이 있는지만 검사하는 조건문 (실제 동작은 onLoginSubmit 함수에서 해야한다)
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener("submit", onLoginSubmit);
} else {
    paintGreetings(savedUsername);
}


function updateLoginStatus() {
    if (loggedInUser) {
        logoutBtn.classList.remove('hidden');
        loginForm.classList.add('hidden');
    } else {
        logoutBtn.classList.add('hidden');
        loginForm.classList.remove('hidden');
    }
}


updateLoginStatus();

logoutBtn.addEventListener('click', function() {
    localStorage.removeItem('username');
    updateLoginStatus();
});