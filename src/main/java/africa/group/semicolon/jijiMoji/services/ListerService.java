package africa.group.semicolon.jijiMoji.services;

import africa.group.semicolon.jijiMoji.dtos.requests.RegisterListerRequest;
import africa.group.semicolon.jijiMoji.dtos.responses.RegisterListerResponse;

public interface ListerService  {

    public RegisterListerResponse registerLister(RegisterListerRequest request);
}
