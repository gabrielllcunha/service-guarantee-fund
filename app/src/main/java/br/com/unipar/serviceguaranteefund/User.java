package br.com.unipar.serviceguaranteefund;
import java.lang.String;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class User {

    public String cpf;
    public Date birthDate;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPayment(Date birthDate) {
        Calendar date = new GregorianCalendar();
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        int paymentDate = 0;
        if (day >= 1 && day <= 10) {
            paymentDate = 5;
        } else if (day >= 11 && day <= 20) {
            paymentDate = 10;
        } else if (day >= 21 && day <= 31) {
            paymentDate = 15;
        }
        if (month > 12) {
            int monthRest = month - 12;
            month = 0;
            month = month + monthRest;
            year = year + 1;
        }
        String payday = ("O pagamento deve ser efetuado no dia:") + paymentDate;
        return payday;
    }

    public int getAge(Date birthDate) {
        Calendar date = new GregorianCalendar();
        Calendar currently = Calendar.getInstance();
        date.setTime(birthDate);
        int age = currently.get(Calendar.YEAR) - date.get(Calendar.YEAR);
        date.add(Calendar.YEAR, age);
        return age;
    }

}
