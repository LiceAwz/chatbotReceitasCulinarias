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
    const pergunta = inputQuestion.value.trim();
    if (!pergunta) return;

    addMessage(pergunta, 'user');
    inputQuestion.value = '';

    fetch('/api/chatbot/perguntar', {
        method: 'POST',
        headers: {'Content-Type': 'text/plain'},
        body: pergunta
    })
        .then(response => response.text())
        .then(resposta => {
            // TROCA a resposta padrão do back por "Receita indisponível"
            if (resposta.startsWith("Desculpe, não sei essa receita")) {
                addMessage("Receita indisponível, por favor escolha outra!", 'bot');
            } else {
                addMessage(resposta, 'bot');
            }
        })
        .catch(() => addMessage("Ops, houve um erro ao se comunicar com o Chatbot.", 'bot'));
}

function restartChat() {
    chatArea.innerHTML = '';
    addMessage("Seja Bem vindo, por favor escolha a receita que deseja", 'bot');
    inputQuestion.disabled = false;
}

function endChat() {
    addMessage("Conversa encerrada. Obrigado por usar o Chatbot de Receitas!", 'bot');
    inputQuestion.disabled = true;
}

inputQuestion.addEventListener("keydown", function(event) {
    if (event.key === "Enter") sendMessage();
});

window.onload = restartChat;