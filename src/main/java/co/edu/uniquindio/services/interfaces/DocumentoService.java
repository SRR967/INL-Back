package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.DocumentoDTO;
import java.util.List;

public interface DocumentoService {
    DocumentoDTO saveDocumento(DocumentoDTO documentoDto) throws Exception;
    DocumentoDTO getDocumentoById(int id) throws Exception;
    List<DocumentoDTO> getAllDocumentos() throws Exception;
    DocumentoDTO updateDocumento(DocumentoDTO documentoDto) throws Exception;
    void deleteDocumento(int id) throws Exception;
}