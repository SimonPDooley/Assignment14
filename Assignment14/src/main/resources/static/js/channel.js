var username = sessionStorage.getItem("user")
var message = document.querySelector("#message")
var channel = sessionStorage.getItem("channel")
let messageList = document.querySelector(".message-list")

addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
      console.log(username)
		
		var userMessage = {
		"messageId": 1,
		"message": message.value,
		"user": username,
		"channel": null
		}
		
	fetch(`http://localhost:8080/sendMessage`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(userMessage)
	})
	.then((response) => response.json())
	.then((data) => {
		console.log(data)
		eraseText()
	})
    }
})

function eraseText() {
    document.getElementById("message").value = ""
}

async function getMessages() {
fetch(`http://localhost:8080/getMessages`).then(function (response){
		return response.json()
		}).then(function (allMessages){
			//console.log(allMessages)
			var updatedMessages = ""
			for (eachMessage of allMessages){
				console.log(eachMessage.message)
				updatedMessages +=  eachMessage.user +": " + eachMessage.message + '</br>'
			}
		
			messageList.innerHTML = updatedMessages


		}).catch(function (error){
			console.error('Something went wrong')
			console.error(error)
		})	

    await new Promise(resolve => setTimeout(resolve, 500));
    await getMessages();
}
getMessages()