const chatArea = document.getElementById('chat-area');
const inputQuestion = document.getElementById('input-question');

function addMessage(content, type) {
    const div = document.createElement('div');
    div.className = 'message ' + type;
    div.innerText = content;
    chatArea.appendChild(div);
    chatArea.scrollTop = chatArea.scrollHeight;
}

function sendMessage() {
    const question = inputQuestion.value.trim();
    if (!question) return;

    addMessage(question, 'user');
    inputQuestion.value = '';

    fetch('/api/chatbot/perguntar', {
        method: 'POST',
        headers: {'Content-Type': 'text/plain'},
        body: question
    })
        .then(response => response.text())
        .then(answer => addMessage(answer, 'bot'))
        .catch(() => addMessage("Ops, houve um erro ao se comunicar com o Chatbot.", 'bot'));
}

function restartChat() {
    chatArea.innerHTML = '';
    addMessage("Olá! Pergunte por uma receita de cozinha.", 'bot');
}

function endChat() {
    addMessage("Conversa encerrada. Obrigado por usar o Chatbot de Receitas!", 'bot');
    inputQuestion.disabled = true;
}

inputQuestion.addEventListener("keydown", function(event) {
    if (event.key === "Enter") sendMessage();
});

window.onload = restartChat;