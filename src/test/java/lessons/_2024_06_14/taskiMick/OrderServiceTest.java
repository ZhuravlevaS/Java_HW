package lessons._2024_06_14.taskiMick;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private PurchaseOrder order;

    @Mock
    private OrderRepositoryImpl orderRepository;

    @InjectMocks
    private OrderService orderService = new OrderService(orderRepository);;

    @BeforeEach
    void setUp() {

    }

    @Test
    void placeOrder() {
        orderService.placeOrder(order);
        verify(orderRepository).save(order);
    }

    @Test
    void getOrder() {
        when(orderRepository.findById(1)).thenReturn(order);

        PurchaseOrder result = orderService.getOrder(1);
        assertEquals(order, result);
    }
}
