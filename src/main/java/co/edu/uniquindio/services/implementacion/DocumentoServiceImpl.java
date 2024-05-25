package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.entities.Documento;
import co.edu.uniquindio.model.dto.DocumentoDTO;
import co.edu.uniquindio.repositories.DocumentoRepo;
import co.edu.uniquindio.services.interfaces.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class DocumentoServiceImpl implements DocumentoService {

    //@Autowired
    private DocumentoRepo documentoRepository;

    @Override
    public DocumentoDTO saveDocumento(DocumentoDTO documentoDto) {
        Documento documento = new Documento();
        // Aquí copiar los campos de documentoDto a documento
        documento = documentoRepository.save(documento);
        return convertToDto(documento);
    }

    @Override
    public DocumentoDTO getDocumentoById(int id) {
        Documento documento = documentoRepository.findById(id).orElse(null);
        return convertToDto(documento);
    }

    @Override
    public List<DocumentoDTO> getAllDocumentos() {
        List<Documento> documentos = documentoRepository.findAll();
        return documentos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public DocumentoDTO updateDocumento(DocumentoDTO documentoDto) {
        Documento documento = new Documento();
        // Aquí copiar los campos de documentoDto a documento
        documento = documentoRepository.save(documento);
        return convertToDto(documento);
    }

    @Override
    public void deleteDocumento(int id) {
        documentoRepository.deleteById(id);
    }

    private DocumentoDTO convertToDto(Documento documento) {
        DocumentoDTO documentoDto = new DocumentoDTO(documento.getIdDocumento(), documento.getNombreDocumento(),documento.getDescripcion(),documento.getProyecto().getIdProyecto());
        // Aquí copiar los campos de documento a documentoDto
        return documentoDto;
    }
}