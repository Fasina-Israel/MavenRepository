package africa.group.semicolon.jijiMoji.services;

import africa.group.semicolon.jijiMoji.data.models.Lister;
import africa.group.semicolon.jijiMoji.data.repositories.ListerRepository;
import africa.group.semicolon.jijiMoji.dtos.requests.RegisterListerRequest;
import africa.group.semicolon.jijiMoji.dtos.responses.RegisterListerResponse;
import africa.group.semicolon.jijiMoji.exceptions.DuplicateEmailException;
import africa.group.semicolon.jijiMoji.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ListerServiceImpl implements ListerService{

    @Autowired
    private ListerRepository listerRepository;


    @Override
    public RegisterListerResponse registerLister(RegisterListerRequest request) {
        //Validate user does not exist (email)
        //find lister by email, if null
        Optional<Lister> optionalLister = listerRepository.findListerByEmail(request.getEmail());
        if(optionalLister.isPresent()) throw new DuplicateEmailException(request.getEmail() +"already exists");

        //create lister from requestdto
        Lister lister = ModelMapper.map(request);
        //save lister
        Lister savedLister = listerRepository.save(lister);
        //create response from saved lister
        RegisterListerResponse response = ModelMapper.map(savedLister);
        //return response
        return response;
        //else throw exception

    }
}
