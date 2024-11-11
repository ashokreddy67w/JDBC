package com.bankDAO;
import java.util.List;
import com.bank_model.bankconsumerdetails;
public interface BankDAO {
List<bankconsumerdetails> getAllBankCostumarDetails();
int insertBankCosumardetails(bankconsumerdetails bankconsumerdetails);
bankconsumerdetails getuserbyuseingemailidorphonenumberandpassword(String Emailidorphonenumber ,String password);
int updateAmounbyuseingAccountNumber(double Amount,long Account_Number);
}
