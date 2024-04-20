package com.vamsi.FirstJob.company;
import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deletecompanyById(Long id);

    Company getCompanyById(Long id);
}
