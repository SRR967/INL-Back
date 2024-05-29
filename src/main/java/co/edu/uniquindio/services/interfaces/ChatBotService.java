package co.edu.uniquindio.services.interfaces;

import java.io.IOException;

public interface ChatBotService {
    String getResponse(String message) throws IOException;
}
