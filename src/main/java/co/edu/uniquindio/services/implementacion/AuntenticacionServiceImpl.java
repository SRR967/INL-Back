package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.dto.LoginDTO;
import co.edu.uniquindio.model.dto.TokenDTO;
import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.entities.Empleado;
import co.edu.uniquindio.model.entities.Usuario;
import co.edu.uniquindio.repositories.UsuarioRepo;
import co.edu.uniquindio.services.interfaces.AutenticacionService;
import co.edu.uniquindio.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuntenticacionServiceImpl implements AutenticacionService {

    private final UsuarioRepo usuarioRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioRepo.findByEmail(loginDTO.email()));

        if(usuarioOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }

        Usuario usuario = usuarioOptional.get();


        if( !passwordEncoder.matches(loginDTO.contrasena(), usuario.getContrasena()) ){
            throw new Exception("La contraseña ingresada es incorrecta");
        }

        String token = createToken(usuario);
        String refreshToken = createRefreshToken(usuario.getEmail());
        return new TokenDTO(token, refreshToken);
    }

    @Override
    public TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception{
        try {
            String email = jwtUtils.parseJwt(tokenDTO.refreshToken()).getBody().getSubject();
            Optional<Usuario> cuentaOptional = Optional.ofNullable(usuarioRepo.findByEmail(email));
            if (cuentaOptional.isEmpty()) {
                throw new Exception("No existe el correo ingresado");
            }
            Usuario cuenta = cuentaOptional.get();

            String jwtToken = createToken(cuenta);
            return new TokenDTO(jwtToken, tokenDTO.refreshToken());
        } catch (Exception e) {
            throw new Exception("El token de refresco no es valido");
        }
    }

    private String createToken(Usuario usuario){

        String rol;
        String nombre;
        if( usuario instanceof Cliente){
            rol = "cliente";
            nombre = ((Cliente) usuario).getNombre();
        }else if( usuario instanceof Empleado){
            rol = "empleado";
            nombre = ((Empleado) usuario).getNombre();
        }else{
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", usuario.getCedula());

        return jwtUtils.generarToken(usuario.getEmail(), map);
    }

    private String createRefreshToken(String email) {
        // Genera un token de refresco con una duración mayor que el token normal
        Map<String, Object> claims = new HashMap<>();
        return jwtUtils.generarToken(email, claims);
    }
}
