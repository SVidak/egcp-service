package rs.erste.egcpservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.erste.egcpservice.model.egcp.EGCPEvent;

public interface EgcpRepository extends JpaRepository<EGCPEvent, Long> {

}
