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
        return new TokenDTO(createToken(usuario));
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
}
