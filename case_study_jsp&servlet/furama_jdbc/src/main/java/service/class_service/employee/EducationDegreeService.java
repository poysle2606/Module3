package service.class_service.employee;

import model.employee.EducationDegree;
import repository.class_repository.employee.EducationDegreeRepository;
import repository.interface_repository.employee.IEducationDegreeRepository;
import service.interface_service.employee.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {

    IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> educationList() {
        return iEducationDegreeRepository.educationList();
    }
}
