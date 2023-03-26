package demo.chatgpt.demochatgpt.resources;

import demo.chatgpt.demochatgpt.dto.ResponseDto;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/questions")
@RequiredArgsConstructor
public class Peticion {

    private final ChatgptService chatgptService;

    @GetMapping("/send")
    public ResponseDto<String> send(@RequestParam String message){
        log.info("message is: {}", message);
        String response = chatgptService.sendMessage(message);
        log.info("response is: {}", response);
        return ResponseDto.success(response);
    }
}
