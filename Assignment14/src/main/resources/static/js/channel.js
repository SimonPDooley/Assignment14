var username = sessionStorage.getItem("user")
var message = document.querySelector("#message")
var channelName = document.querySelector("#channel").textContent
var channelId = document.querySelector("#channelID").textContent
var channelMessages = document.querySelector("#channelMessages").textContent
let messageList = document.querySelector(".message-list")


addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
		var userMessage = {
			"messageId": 1,
			"message": message.value,
			"user": username,
			"channel": {channelId : channelId, channelName: channelName, messages : []}
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
			var updatedMessages = ""
			const channelMessages = allMessages.filter(message => {
 				 return message.channel.channelName.includes(channelName)
			})
			for (eachMessage of channelMessages){
					updatedMessages +=  eachMessage.user.bold() +": " + eachMessage.message +'</br>'
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