package com.vamsi.FirstJob.company.impl;

import com.vamsi.FirstJob.company.Company;
import com.vamsi.FirstJob.company.CompanyRepository;
import com.vamsi.FirstJob.company.CompanyService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceimpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceimpl(CompanyRepository companyRepository)
    {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent())
        {
            Company company1 = companyOptional.get();
            company1.setName(company.getName());
            company1.setDescription(company.getDescription());
            company1.setJobs(company.getJobs());
            companyRepository.save(company1);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
         companyRepository.save(company);
    }

    @Override
    public boolean deletecompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
