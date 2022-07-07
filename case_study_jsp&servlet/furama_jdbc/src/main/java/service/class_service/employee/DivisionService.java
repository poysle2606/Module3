package service.class_service.employee;

import model.employee.DivisionEmployee;
import repository.class_repository.employee.DivisionRepository;
import repository.interface_repository.employee.IDivisionRepository;
import service.interface_service.employee.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {

    IDivisionRepository iDivisionRepository = new DivisionRepository();
    @Override
    public List<DivisionEmployee> listDivision() {
        return iDivisionRepository.listDivision();
    }
}
