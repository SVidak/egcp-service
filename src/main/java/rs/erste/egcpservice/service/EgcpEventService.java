package rs.erste.egcpservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.erste.egcpservice.dto.EGCPEventDTO;
import rs.erste.egcpservice.mapper.EGCPMapper;
import rs.erste.egcpservice.model.egcp.EGCPEvent;
import rs.erste.egcpservice.repository.EgcpEventRepository;

import java.util.Optional;

@Service
@Transactional
public class EgcpEventService {

    private final EgcpEventRepository egcpEventRepository;
    private final EGCPMapper egcpMapper;

    @Autowired
    public EgcpEventService(EgcpEventRepository egcpEventRepository, EGCPMapper egcpMapper) {
        this.egcpEventRepository = egcpEventRepository;
        this.egcpMapper = egcpMapper;
    }

    public EGCPEvent save(EGCPEventDTO egcpEventDTO){
        return egcpEventRepository.save(egcpMapper.toEGCPEvent(egcpEventDTO));
    }

    @Transactional(readOnly = true)
    Optional<EGCPEventDTO> findByID(Long id){
        return egcpEventRepository.findById(id).map(egcpMapper::toEGCPEventDTO);
    }
}
