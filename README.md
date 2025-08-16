# chatbotReceitasCulinarias
java springboot html css js local Ready

---

## 📝 Summary

This application provides a **culinary recipe chatbot** accessible via browser, allowing users to ask objective questions about various recipes (e.g., "How to make rice?").
The questions and answers are maintained in the backend using Java/Spring Boot with simple persistence in a JSON file.
The interface is user-friendly, and the API can be adapted for other integrations.

The chatbot is perfect for quick recipe queries, providing agility, centralization, and ease in searching for detailed cooking instructions.

---

## 🧰 Prerequisites

- Java 17+ (e.g., Amazon Corretto)
- Maven 3.8+
- Web Browser (Google Chrome, Firefox, Edge, or similar)

---

## 💻 Getting started

Clone the repository and navigate to the project folder:

git clone[https://github.com/LiceAwz/chatbotReceitasCulinarias.git]
cd chatbotReceitasCulinarias

---

### Scope

This project's recipes are in `src/main/resources/receitas.json`.
The web interface is in `src/main/resources/static`.

---

### Compile

mvn clean compile

---

### Run

mvn spring-boot

Acess [http://localhost:8080/](http://localhost:8080/) in your browser.

---

### Usage Examples

When you open the interface, you'll see the available recipes.
Type, for example:

- Como fazer arroz?
- Como fazer panquecas?

---

## 📚 Documentation

You can easily edit the question-answer pairs in `receitas.json`.
The customizable interface and scripts are in the `static` folder.