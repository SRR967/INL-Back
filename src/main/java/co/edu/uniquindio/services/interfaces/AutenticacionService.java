package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.LoginDTO;
import co.edu.uniquindio.model.dto.TokenDTO;

public interface AutenticacionService {
    TokenDTO login (LoginDTO loginDTO) throws Exception;

}
