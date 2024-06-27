package lessons._2024_06_14.mock;

public class SimpleAuditService implements AuditService {
	@Override
	public void logNewTrade(Trade trade) {
		throw new RuntimeException("implement logNewTrade() in SimpleAuditService");
	}
}