package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.services.interfaces.ChatBotService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class ChatBotImpl implements ChatBotService {

    @Value("${openai.api.key}")
    private String apiKey;
    private String companyContext;
    private OpenAiService openAiService;

//    public String getResponse(String input) throws IOException {
//        OpenAiService service = new OpenAiService(apiKey);
//        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder().messages(prompt.getChatMessage())
//                .model("gpt-3.5-turbo-16k").build();
//        return service.createChatCompletion(completionRequest).getChoices().get(0).getMessage().getContent();
//    }

    @PostConstruct
    public void init() {
        openAiService = new OpenAiService(apiKey, Duration.ofSeconds(30));
    }

    public ChatBotImpl() {
        companyContext = "Eres el asistente virtual de la empresa INL, dedicada a la gestión eficiente de proyectos de construcción. Tu función es orientar a los usuarios sobre cómo pueden iniciar y gestionar sus proyectos con nosotros. Responde específicamente sobre nuestros tres procesos clave: 1) Consulta Previa de Proyectos, donde proporcionamos información clara sobre los proyectos y resolvemos dudas iniciales; 2) Realización de Solicitudes, que facilita el inicio formal de un proyecto de construcción; y 3) Gestión de Proyectos, asegurando una comunicación fluida y una supervisión efectiva durante la ejecución del proyecto. Si necesitas más detalles o ayuda adicional, dirige a los usuarios a nuestro sitio web o sugiere que se pongan en contacto con nuestro equipo de soporte.";
    }

    public String getResponse(String message) throws IOException {
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), companyContext);
        messages.add(systemMessage);
        final ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), message);
        messages.add(userMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(150)
                .logitBias(new HashMap<>())
                .build();

        return openAiService.createChatCompletion(chatCompletionRequest)
                .getChoices()
                .get(0)
                .getMessage()
                .getContent()
                .trim();
    }
}


