package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.DocumentoDTO;
import java.util.List;

public interface DocumentoService {
    DocumentoDTO saveDocumento(DocumentoDTO documentoDto);
    DocumentoDTO getDocumentoById(int id);
    List<DocumentoDTO> getAllDocumentos();
    DocumentoDTO updateDocumento(DocumentoDTO documentoDto);
    void deleteDocumento(int id);
}