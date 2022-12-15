package com.md4_casestudy_furame.service.impl.employee;

import com.md4_casestudy_furame.model.employee.EducationDegree;
import com.md4_casestudy_furame.repository.Employee.IEducationDegreeRepository;
import com.md4_casestudy_furame.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Optional<EducationDegree> findById(int id) {
        return educationDegreeRepository.findById(id);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(int id) {
        educationDegreeRepository.deleteById(id);
    }
}
