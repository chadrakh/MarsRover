package marsmission.marsrover.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class IdentifierTest {
    private final Identifier IDENTIFIER = new Identifier();
    @Test
    public void generateId_IncrementsId_WithEachCall() {
        long firstId = IDENTIFIER.generateId();
        long secondId = IDENTIFIER.generateId();

        assertEquals(firstId + 1, secondId);
    }
  
}