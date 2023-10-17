package com.example.processclients.mappers;
import com.example.processclients.dtos.*;
import com.example.processclients.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImp {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }
    public Customer fromCustomerDT0(CustomerDTO customerDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }
    public AddressDTO fromAddress(Address address){
        AddressDTO addressDTO=new AddressDTO();
        BeanUtils.copyProperties(address,addressDTO);
        return addressDTO;
    }
    public Address fromAddressDT0(AddressDTO addressDTO){
        Address address=new Address();
        BeanUtils.copyProperties(addressDTO,address);
        return address;
    }
    public ContactDTO fromContact(Contact contact){
        ContactDTO contactDTO=new ContactDTO();
        BeanUtils.copyProperties(contact,contactDTO);
        return contactDTO;
    }
    public Contact fromContactDTO(ContactDTO contactDTO){
        Contact contact=new Contact();
        BeanUtils.copyProperties(contactDTO,contact);
        return contact;
    }
    public AuditDTO fromAudit(Audit audit){
        AuditDTO auditDTO=new AuditDTO();
        BeanUtils.copyProperties(audit,auditDTO);
        return auditDTO;
    }
    public Audit fromAuditDTO(AuditDTO auditDTO){
        Audit audit=new Audit();
        BeanUtils.copyProperties(auditDTO,audit);
        return audit;
    }
    public DocumentDTO fromDocument(Document document){
        DocumentDTO documentDTO=new DocumentDTO();
        BeanUtils.copyProperties(document,documentDTO);

        return documentDTO;
    }
    public Document fromDocumentDTO(DocumentDTO documentDTO){
        Document document=new Document();
        BeanUtils.copyProperties(documentDTO,document);
        return document;
    }
    public FinancialDTO fromFinancial(Financial financial){
        FinancialDTO financialDTO=new FinancialDTO();
        BeanUtils.copyProperties(financial,financialDTO);
        return financialDTO;
    }
    public Financial fromFinancialDTO(FinancialDTO financialDTO){
        Financial financial=new Financial();
        BeanUtils.copyProperties(financialDTO,financial);
        return financial;
    }
    public FurtherDetailsDTO fromFurtherDetails(FurtherDetails furtherDetails){
        FurtherDetailsDTO furtherDetailsDTO=new FurtherDetailsDTO();
        BeanUtils.copyProperties(furtherDetails,furtherDetailsDTO);
        return  furtherDetailsDTO;
    }
    public FurtherDetails fromFurtherDetailsDTO(FurtherDetailsDTO furtherDetailsDTO){
        FurtherDetails furtherDetails=new FurtherDetails();
        BeanUtils.copyProperties(furtherDetailsDTO,furtherDetails);
        return furtherDetails;
    }
    public KycDTO fromKyc(Kyc kyc){
        KycDTO kycDTO=new KycDTO();
        BeanUtils.copyProperties(kyc,kycDTO);
        return kycDTO;
    }
    public Kyc fromKycDTO(KycDTO kycDTO){
        Kyc kyc=new Kyc();
        BeanUtils.copyProperties(kycDTO,kyc);
        return kyc;
    }
    public OtherDetailsDTO fromOtherDetails(OtherDetails otherDetails){
        OtherDetailsDTO otherDetailsDTO=new OtherDetailsDTO();
        BeanUtils.copyProperties(otherDetails,otherDetailsDTO);
        return otherDetailsDTO;
    }
    public OtherDetails fromOtherDetailsDTO(OtherDetailsDTO otherDetailsDTO){
        OtherDetails otherDetails=new OtherDetails();
        BeanUtils.copyProperties(otherDetailsDTO,otherDetails);
        return otherDetails;
    }
    public RelationDTO fromRelation(Relation relation){
        RelationDTO relationDTO=new RelationDTO();
        BeanUtils.copyProperties(relation,relationDTO);

        return relationDTO;
    }
    public Relation fromRelationDTO(RelationDTO relationDTO){
        Relation relation=new Relation();
        BeanUtils.copyProperties(relationDTO,relation);
        return relation;
    }
    public DeletedCustomerDTO fromDeletedCustomer(DeletedCustomer deletedCustomer){
        DeletedCustomerDTO deletedCustomerDTO=new DeletedCustomerDTO();
        BeanUtils.copyProperties(deletedCustomer,deletedCustomerDTO);

        return deletedCustomerDTO;
    }
    public DeletedCustomer fromDeletedCustomerDTO(DeletedCustomerDTO deletedCustomerDTO){
        DeletedCustomer deletedCustomer=new DeletedCustomer();
        BeanUtils.copyProperties(deletedCustomerDTO,deletedCustomer);
        return  deletedCustomer;
    }

}
