package yte.parttime.demandApp.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageResponse {
    private final String message;
    private final MessageType messageType;
}
