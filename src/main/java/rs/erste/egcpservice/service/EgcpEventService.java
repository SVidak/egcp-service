package rs.erste.egcpservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.erste.egcpservice.model.egcp.EGCPEvent;
import rs.erste.egcpservice.repository.EgcpEventRepository;

import java.util.Optional;

@Service
@Transactional
public class EgcpEventService {

    private final EgcpEventRepository egcpEventRepository;

    @Autowired
    public EgcpEventService(EgcpEventRepository egcpEventRepository) {
        this.egcpEventRepository = egcpEventRepository;
    }

    public EGCPEvent save(EGCPEvent egcpEvent){
        return egcpEventRepository.save(egcpEvent);
    }

    @Transactional(readOnly = true)
    Optional<EGCPEvent> findByID(Long id){
        return egcpEventRepository.findById(id);
    }
}
