var apiGateWayAddress = "http://localhost:8073"
document.querySelector("#id-login-btn").addEventListener("click", function(event) {
    event.preventDefault();
    var userName = document.querySelector("#login-userName").value
    var password = document.querySelector("#login-password").value

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "userName": userName,
        "password": password
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw
    };

    fetch(apiGateWayAddress + "/auth/login", requestOptions)
    .then(response => console.log(response))
    .catch(error => console.log('error', error));

}, false);