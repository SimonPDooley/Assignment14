var username = sessionStorage.getItem("user")
var message = document.querySelector("#message")


addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      console.log(username)
		
		var user = {
		"userId": 1,
		"username": username,
		"messages": [
					{"messageId": 1, "message": message.value, "userId": 1}
				  ]	
		}
		
	fetch(`http://localhost:8080/sendMessage`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(user)
	})
	.then((response) => response.json())
	.then((data) => {
		console.log(data)
		eraseText()
	})
    }
})

function eraseText() {
    document.getElementById("message").value = "";
}

async function getMessages() {
  let response = await fetch("/getMessages");

  if (response.status == 502) {

    await getMessages();
  } else if (response.status != 200) {
  
    showMessage(response.statusText);

    await new Promise(resolve => setTimeout(resolve, 500));
    await getMessages();
  } else {
 
    let message = await response.text();

    await getMessages();
  }
}

getMessages();