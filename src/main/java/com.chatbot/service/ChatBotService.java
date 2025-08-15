package main.java.com.chatbot.service;


import com.chatbot.model.ChatMessagePair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatBotService {

    private final List<com.chatbot.model.ChatMessagePair> pairQuestionAnswer = new ArrayList<>();

    public ChatBotService() {
        //Add recipes here.
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer arroz?"," Para fazer arroz, reforgue 2 colheres de alho e óleo com 1 xícara de arroz, coloque 2 xícaras de água, tempere e cozinhe até secar."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer macarrão ao alho e óleo?","Cozinhe 250g de macarrão em água com sal, escorra e reserve. Em uma panela, aqueça 3 colheres de óleo, doure 3 dentes de alho picados, adicione o macarrão, misture bem e sirva com salsinha."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer omelete?","Bata 2 ovos com sal e pimenta, aqueça 1 colher de óleo ou manteiga, despeje os ovos batidos, adicione recheio se quiser, cozinhe em fogo baixo e dobre ao meio."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer feijão?","Deixe 2 xícaras de feijão de molho por 8 horas, escorra e cozinhe na panela de pressão com água por 20 minutos. Refogue alho, cebola e temperos, junte o feijão cozido e deixe apurar."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer panqueca?","Bata no liquidificador 1 xícara de leite, 1 ovo, 1 xícara de farinha e sal. Aqueça uma frigideira untada, despeje pequenas porções da massa, cozinhe dos dois lados e recheie como preferir."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer café coado?","Ferva 500ml de água, adicione lentamente sobre 3 colheres de pó de café no coador, deixe escorrer e sirva quente."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer brigadeiro?","Em uma panela, misture 1 lata de leite condensado, 2 colheres de chocolate em pó e 1 colher de manteiga, cozinhe mexendo até desgrudar do fundo, espere esfriar e enrole."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer farofa simples?","Refogue 2 colheres de manteiga com 1 cebola picada, adicione 2 xícaras de farinha de mandioca, mexa bem, tempere com sal e cheiro-verde, e cozinhe até dourar levemente."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer mingau de aveia?","Em uma panela, misture 2 colheres de aveia, 1 xícara de leite e 1 colher de açúcar, cozinhe em fogo baixo mexendo até engrossar e sirva quente."));
        pairQuestionAnswer.add(new ChatMessagePair("Como fazer frango grelhado?","Tempere 2 filés de frango com sal, pimenta e limão, aqueça uma frigideira com um fio de óleo, grelhe por 3 minutos de cada lado até dourar e cozinhar por dentro."));
    }
 public String answer(String question){
        for (ChatMessagePair pair : pairQuestionAnswer){
            if (pair.getQuestion().equalsIgnoreCase(question.trim())){
                return pair.getAnswer();
            }
        }
        return "Desculpe, não sei essa receita. Tente outra receita!";
 }
}