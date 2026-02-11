package rs.erste.egcpservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.erste.egcpservice.model.egcp.EGCPEvent;

import java.util.Optional;

@Repository
public interface EgcpEventRepository extends JpaRepository<EGCPEvent, Long> {

    Optional<EGCPEvent> findById(Long id);

}
