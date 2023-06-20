package modules.harborDistance;

import java.util.List;

import modules.harbor.entities.interfaces.IHarborReadable;
import modules.harbor.repositories.interfaces.IHarborRepository;
import modules.harbor.repositories.InMemoryHarborRepository;
import modules.harborDistance.dtos.CreateDefaultHarborDistanceToAllHarborsDTO;
import modules.harborDistance.dtos.CreateHarborDistanceDTO;
import modules.harborDistance.entities.interfaces.IHarborDistanceReadable;
import modules.harborDistance.repositories.interfaces.IHarborDistanceRepository;
import modules.harborDistance.repositories.InMemoryHarborDistanceRepository;
import shared.errors.HarborDistanceAlreadyExists;
import shared.errors.HarborNotFound;
import shared.errors.NoHarborDistanceRegistered;

public class HarborDistanceService {
    private IHarborRepository harborRepository;
    private IHarborDistanceRepository harborDistanceRepository;

    public HarborDistanceService() {
        this.harborRepository = InMemoryHarborRepository.instanceOf();
        this.harborDistanceRepository = InMemoryHarborDistanceRepository.instanceOf();
    }

    public IHarborDistanceReadable createHarborDistance(CreateHarborDistanceDTO createHarborDistanceDTO) {
        IHarborReadable firstHarbor = this.harborRepository.findById(createHarborDistanceDTO.getFirstHarborId());
        if (firstHarbor == null) {
            throw new HarborNotFound(String.valueOf(createHarborDistanceDTO.getFirstHarborId()));
        }

        IHarborReadable secondHarbor = this.harborRepository.findById(createHarborDistanceDTO.getSecondHarborId());
        if (secondHarbor == null) {
            throw new HarborNotFound(String.valueOf(createHarborDistanceDTO.getSecondHarborId()));
        }

        IHarborDistanceReadable harborDistanceAlreadyExists = this.harborDistanceRepository.findByHarbors(
                createHarborDistanceDTO.getFirstHarborId(),
                createHarborDistanceDTO.getSecondHarborId());
        if (harborDistanceAlreadyExists != null) {
            throw new HarborDistanceAlreadyExists(
                    String.valueOf(createHarborDistanceDTO.getFirstHarborId()),
                    String.valueOf(createHarborDistanceDTO.getSecondHarborId()));
        }

        return this.harborDistanceRepository.create(createHarborDistanceDTO.getValue(), firstHarbor, secondHarbor);
    }

    public void createDefaultHarborDistanceToAllHarbors(
            CreateDefaultHarborDistanceToAllHarborsDTO createDefaultHarborDistanceToAllHarborsDTO) {
        IHarborReadable harbor = this.harborRepository
                .findById(createDefaultHarborDistanceToAllHarborsDTO.getHarborId());
        if (harbor == null) {
            throw new HarborNotFound(String.valueOf(createDefaultHarborDistanceToAllHarborsDTO.getHarborId()));
        }

        for (IHarborReadable otherHarbor : this.harborRepository.findAll()) {
            if (harbor.getId() != otherHarbor.getId()) {
                IHarborDistanceReadable harborDistanceAlreadyExists = this.harborDistanceRepository.findByHarbors(
                        harbor.getId(),
                        otherHarbor.getId());
                if (harborDistanceAlreadyExists == null) {
                    this.harborDistanceRepository.create(100, harbor, otherHarbor);
                }
            }
        }

    }

    public List<IHarborDistanceReadable> findAll() {
        List<IHarborDistanceReadable> harborDistances = harborDistanceRepository.findAll();

        if (harborDistances.isEmpty()) {
            throw new NoHarborDistanceRegistered();
        }

        return harborDistances;
    }
}
