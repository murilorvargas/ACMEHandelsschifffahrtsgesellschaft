package modules.client;

import java.util.List;

import modules.client.dtos.CreateClientDTO;
import modules.client.dtos.FindClientByCodeDTO;
import modules.client.dtos.FindClientByEmailDTO;
import modules.client.dtos.FindClientByNameDTO;
import modules.client.entities.interfaces.IClientReadable;
import modules.client.repositories.InMemoryClientRepository;
import modules.client.repositories.interfaces.IClientRepository;
import shared.errors.ClientCodeAlreadyExists;
import shared.errors.ClientCodeNotFound;
import shared.errors.ClientEmailAlreadyExists;
import shared.errors.ClientEmailNotFound;
import shared.errors.ClientNameAlreadyExists;
import shared.errors.ClientNameNotFound;
import shared.errors.NoClientRegistered;

public class ClientService {

    private IClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = InMemoryClientRepository.instanceOf();
    }

    public IClientReadable createClient(CreateClientDTO createClientDTO) {

        IClientReadable validateCode = this.clientRepository.findByCode(createClientDTO.getCode());
        IClientReadable validateName = this.clientRepository.findByName(createClientDTO.getName());
        IClientReadable validateEmail = this.clientRepository.findByEmail(createClientDTO.getEmail());

        if (validateCode == null && validateName == null && validateEmail == null) {
            return this.clientRepository.create(createClientDTO.getCode(), createClientDTO.getName(),
                    createClientDTO.getEmail());
        } else {
            if (validateCode != null) {
                throw new ClientCodeAlreadyExists(String.valueOf(createClientDTO.getCode()));
            }
            if (validateName != null) {
                throw new ClientNameAlreadyExists(String.valueOf(createClientDTO.getName()));
            }
            if (validateEmail != null) {
                throw new ClientEmailAlreadyExists(String.valueOf(createClientDTO.getEmail()));
            }
        }

        return null;

    }

    public List<IClientReadable> findAllClients() {
        List<IClientReadable> client = this.clientRepository.findAll();
        if (client.isEmpty()) {
            throw new NoClientRegistered();
        }

        return client;
    }

    public IClientReadable findClientByCode(FindClientByCodeDTO findClientByCodeDTO) {
        IClientReadable client = this.clientRepository.findByCode(findClientByCodeDTO.getCode());

        if (client == null) {
            throw new ClientCodeNotFound(findClientByCodeDTO.getCode());
        }

        return client;
    }

    public IClientReadable findClientByName(FindClientByNameDTO findClientByNameDTO) {
        IClientReadable client = this.clientRepository.findByName(findClientByNameDTO.getName());

        if (client == null) {
            throw new ClientNameNotFound(findClientByNameDTO.getName());
        }

        return client;
    }

    public IClientReadable findClientByEmail(FindClientByEmailDTO findClientByEmailDTO) {
        IClientReadable client = this.clientRepository.findByEmail(findClientByEmailDTO.getEmail());

        if (client == null) {
            throw new ClientEmailNotFound(findClientByEmailDTO.getEmail());
        }

        return client;
    }

}
