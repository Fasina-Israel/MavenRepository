package africa.group.semicolon.jijiMoji.controllers;

import africa.group.semicolon.jijiMoji.services.ListerService;
import africa.group.semicolon.jijiMoji.dtos.requests.RegisterListerRequest;
import africa.group.semicolon.jijiMoji.exceptions.JijiMojiAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ListerController {
    @Autowired
    private ListerService listerService;
    @PostMapping("/api/v1/lister")
    public ResponseEntity<?> register(@RequestBody RegisterListerRequest request){
        try{
            return  new ResponseEntity<>(listerService.registerLister(request), HttpStatus.CREATED);
        }
        catch(JijiMojiAppException exception){
            return  new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
