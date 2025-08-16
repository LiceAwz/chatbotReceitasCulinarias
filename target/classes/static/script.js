const chatArea = document.getElementById('chat-area');
const inputQuestion = document.getElementById('input-question');

// Exibe uma mensagem no chat (pode ser HTML)
function addMessageHtml(content, type) {
    const div = document.createElement('div');
    div.className = 'message ' + type;
    div.innerHTML = content;
    chatArea.appendChild(div);
    chatArea.scrollTop = chatArea.scrollHeight;
}

// Envia a pergunta para o backend e exibe a resposta
function sendMessage() {
    const question = inputQuestion.value.trim();
    if (!question) return;

    addMessageHtml(question, 'user');
    inputQuestion.value = '';

    fetch('/api/chatbot/perguntar', {
        method: 'POST',
        headers: { 'Content-Type': 'text/plain' },
        body: question
    })
        .then(response => response.text())
        .then(answer => {
            if (answer.startsWith("Desculpe, não sei essa receita")) {
                addMessageHtml("Receita indisponível, por favor escolha outra!", 'bot');
            } else {
                addMessageHtml(answer, 'bot');
            }
        })
        .catch(() => addMessageHtml("Ops, houve um erro ao se comunicar com o Chatbot.", 'bot'));
}

// Reinicia o chat e exibe a lista de receitas disponíveis
function restartChat() {
    chatArea.innerHTML = '';
    fetch('/api/chatbot/receitas')
        .then(response => response.json())
        .then(recipes => {
            let msg = `
            <div class="msg-boas-vindas-titulo">Seja bem-vindo!</div>
            <div style="color:#eee;margin-bottom:10px;">Escolha uma das receitas disponíveis abaixo:</div>
            <ul class="msg-lista-receitas">
        `;
            recipes.forEach(recipe => {
                msg += `<li>${recipe}</li>`;
            });
            msg += `</ul>`;
            addMessageHtml(msg, 'bot');
            inputQuestion.disabled = false;
        })
        .catch(() => {
            addMessageHtml("<b>Erro ao carregar as receitas disponíveis!</b>", 'bot');
            inputQuestion.disabled = false;
        });
}

// Encerra o chat para novas interações
function endChat() {
    addMessageHtml("Conversa encerrada. Obrigado por usar o Chatbot de Receitas!", 'bot');
    inputQuestion.disabled = true;
}

// Permite enviar pergunta com Enter
inputQuestion.addEventListener("keydown", function(event) {
    if (event.key === "Enter") sendMessage();
});

// Inicia o chat ao carregar a página
window.onload = restartChat;